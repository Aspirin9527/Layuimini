
package me.liuhui.mall.manager.service.impl;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.common.search.document.ProductDoc;
import me.liuhui.mall.common.service.FileService;
import me.liuhui.mall.common.service.dto.TempToProductDTO;
import me.liuhui.mall.common.service.vo.FileVO;
import me.liuhui.mall.manager.exception.ServiceException;
import me.liuhui.mall.manager.runtime.AdminSessionHolder;
import me.liuhui.mall.manager.service.ProductService;
import me.liuhui.mall.manager.service.dto.product.CreateProductDTO;
import me.liuhui.mall.manager.service.dto.product.ListProductDTO;
import me.liuhui.mall.manager.service.dto.product.ModifyProductDTO;
import me.liuhui.mall.manager.service.mapstruct.ProductConverter;
import me.liuhui.mall.manager.service.vo.product.ListProductVO;
import me.liuhui.mall.manager.service.vo.product.ProductVO;
import me.liuhui.mall.repository.dao.AdItemDao;
import me.liuhui.mall.repository.dao.CategoryDao;
import me.liuhui.mall.repository.dao.ProductDao;
import me.liuhui.mall.repository.dao.ProductDetailDao;
import me.liuhui.mall.repository.model.Category;
import me.liuhui.mall.repository.model.Product;
import me.liuhui.mall.repository.model.ProductDetail;
import me.liuhui.mall.repository.model.enums.AdItemStatus;
import me.liuhui.mall.repository.model.enums.ProductStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 2020/10/14 20:12
 * <p>
 * Description: [TODO]
 * <p>
 *
 * @author [清远]
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Value("${mall.file.product.path}")
    private String productFilePath;
    @Resource
    private ProductConverter productConverter;
    @Resource
    private ProductDao productDao;
    @Resource
    private CategoryDao categoryDao;
    @Resource
    private AdItemDao adItemDao;
    @Resource
    private ProductDetailDao productDetailDao;
    @Resource
    private FileService fileService;
    /*@Resource
    private ProductSearcher productSearcher;*/

    @Override
    public ResultVO<ListProductVO> list(ListProductDTO dto) {
        if (StringUtils.isBlank(dto.getOrderBy())) {
            dto.setOrderBy("id desc");
        }
        Map<String, Object> cond = dto.toMap();
        long count = productDao.count(cond);
        List<Product> products = productDao.selectList(cond);
        ListProductVO vo = new ListProductVO();
        vo.setTotal(count);
        vo.setList(productConverter.toVo(products));
        return ResultVO.buildSuccessResult(vo);
    }


    @Override
    public ResultVO<ProductVO> detail(Long id) {
        Product product = productDao.selectByPk(id);
        if (product == null) {
            return ResultVO.buildFailResult("产品不存在");
        }
        ProductVO productVO = productConverter.toVo(product);
        ProductDetail productDetail = productDetailDao.selectByProductId(id);
        if (productDetail != null) {
            productVO.setDetail(productDetail.getDetail());
        }
        return ResultVO.buildSuccessResult(productVO);
    }

    @Override
    public ResultVO<Boolean> publish(Set<Long> ids) {
        List<Product> list = new ArrayList<>(ids.size());
        StringBuilder failMsg = new StringBuilder();
        for (Long id : ids) {
            Product product = productDao.selectByPk(id);
            if (product == null) {
                failMsg.append("产品不存在:").append(id);
                continue;
            }
            if (ProductStatus.SELLING.getCode().equals(product.getStatus())) {
                failMsg.append("产品是上架状态:").append(product.getName());
                continue;

            }
            if (product.getStock() <= 0) {
                failMsg.append("库存不能为0:").append(product.getName());
                continue;
            }
            product.setStatus(ProductStatus.SELLING.getCode());
            productDao.update(product, "status");
            list.add(product);
        }
        /*if (list.size() > 0) {
            productSearcher.save(convertDoc(list));
        }*/
        if (StringUtils.isNotBlank(failMsg.toString())) {
            return ResultVO.buildFailResult(failMsg.toString());
        }
        return ResultVO.buildSuccessResult();
    }

    private List<ProductDoc> convertDoc(List<Product> products) {
        return products.stream().map(product -> {
            ProductDoc doc = productConverter.toDoc(product);
            doc.setCategoryIds(Arrays.stream(product.getAllCategoryIds().split(",")).map(Long::valueOf).collect(Collectors.toList()));
            doc.setCategoryNames(getCategoryName(doc.getCategoryIds()));
            return doc;
        }).collect(Collectors.toList());

    }

    private List<String> getCategoryName(List<Long> categoryIds) {
        Map<String, Object> cond = new HashMap<>(2);
        cond.put("id", categoryIds);
        List<Category> categories = categoryDao.selectList(cond, "name");
        return categories.stream().map(Category::getName).collect(Collectors.toList());
    }


    @Override
    public ResultVO<Boolean> suspend(Set<Long> ids) {
        StringBuilder failMsg = new StringBuilder();
        for (Long id : ids) {
            Product product = productDao.selectByPk(id);
            if (product == null) {
                failMsg.append("产品不存在:").append(id);
                continue;
            }
            if (ProductStatus.SUSPEND.getCode().equals(product.getStatus())) {
                failMsg.append("产品是下架状态:").append(product.getName());
                continue;

            }

            product.setStatus(ProductStatus.SUSPEND.getCode());
            productDao.update(product, "status");
            //productSearcher.delete(id);
        }
        if (StringUtils.isNotBlank(failMsg.toString())) {
            return ResultVO.buildFailResult(failMsg.toString());
        }
        return ResultVO.buildSuccessResult();
    }

    /**
     * 统计广告位中商品
     *
     * @param id
     * @return
     */
    private long countPromotion(Long id) {
        Map<String, Object> cond = new HashMap<>(2);
        cond.put("objectId", id);
        cond.put("status", AdItemStatus.PUBLISHED.getCode());
        return adItemDao.count(cond);
    }

    @Override
    public ResultVO<Boolean> create(CreateProductDTO dto) {
        Product entity = productConverter.createDtoToEntity(dto);
        String allCategoryIds = dto.getAllCategoryIds();
        String[] split = allCategoryIds.split(",");
        String categoryId = split[split.length - 1];
        entity.setCategoryId(Long.parseLong(categoryId));
        entity.setCreateTime(new Date());
        entity.setStatus(ProductStatus.SUSPEND.getCode());
        entity.setCreateAdmin(AdminSessionHolder.getCurrentAdmin().getUsername());
        productDao.insert(entity);

        String[] pics = processPics(dto.getPicFilenames(), entity.getId());
        entity.setPicFilenames(String.join(",", pics));
        entity.setMainPic(pics[0]);
        productDao.update(entity, "picFilenames", "mainPic");

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(entity.getId());
        productDetail.setDetail(dto.getDetail());
        productDetailDao.insert(productDetail);
        return ResultVO.buildSuccessResult();
    }

    private String[] processPics(String picFilenames, Long id) {
        String[] oldPic = picFilenames.split(",");
        String[] pics = new String[oldPic.length];
        int i = 0;
        for (String pic : oldPic) {
            if (pic.startsWith(productFilePath)) {
                pics[i++] = pic;
            } else {
                TempToProductDTO fileDto = new TempToProductDTO();
                fileDto.setProductId(id);
                fileDto.setTempFilePath(pic);
                ResultVO<FileVO> fileVo = fileService.tempToProduct(fileDto);
                if (!fileVo.isSuccess()) {
                    throw new ServiceException("图片" + pic + "处理异常:" + fileVo.getMsg());
                }
                pics[i++] = fileVo.getData().getPath();
            }
        }
        return pics;
    }

    @Override
    public ResultVO<Boolean> modify(ModifyProductDTO dto) {
        Product product = productDao.selectByPk(dto.getId());
        if (product == null) {
            return ResultVO.buildFailResult("产品不存在");
        }
        if (!ProductStatus.SUSPEND.getCode().equals(product.getStatus())) {
            return ResultVO.buildFailResult("请先下架产品！");
        }
        Product entity = productConverter.modifyDtoToEntity(dto);
        String[] pics = processPics(dto.getPicFilenames(), entity.getId());
        entity.setPicFilenames(String.join(",", pics));
        entity.setMainPic(pics[0]);
        String allCategoryIds = dto.getAllCategoryIds();
        String[] split = allCategoryIds.split(",");
        String categoryId = split[split.length - 1];
        entity.setCategoryId(Long.parseLong(categoryId));
        productDao.update(entity);
        ProductDetail productDetail = productDetailDao.selectByProductId(dto.getId());
        if (productDetail == null) {
            productDetail = new ProductDetail();
            productDetail.setProductId(product.getId());
            productDetail.setDetail(dto.getDetail());
            productDetailDao.insert(productDetail);
        } else {
            productDetail.setDetail(dto.getDetail());
            productDetailDao.update(productDetail);
        }
        return ResultVO.buildSuccessResult();
    }

    @Override
    public ResultVO<Boolean> delete(Set<Long> ids) {
        for (Long id : ids) {
            productDao.delete(id);
        }
        return ResultVO.buildSuccessResult();
    }

}
