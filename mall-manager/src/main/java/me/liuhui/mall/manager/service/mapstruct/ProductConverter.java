
package me.liuhui.mall.manager.service.mapstruct;


import me.liuhui.mall.common.search.document.ProductDoc;
import me.liuhui.mall.manager.service.dto.product.CreateProductDTO;
import me.liuhui.mall.manager.service.dto.product.ModifyProductDTO;
import me.liuhui.mall.manager.service.vo.product.ProductVO;
import me.liuhui.mall.repository.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Created on 2020/10/14 18:51
 * <p>
 *
 * @author [清远]
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    List<ProductVO> toVo(List<Product> entityList);

    ProductVO toVo(Product product);

    Product createDtoToEntity(CreateProductDTO dto);

    Product modifyDtoToEntity(ModifyProductDTO dto);

    ProductDoc toDoc(Product product);
}
