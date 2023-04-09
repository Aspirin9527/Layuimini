package me.liuhui.mall.manager.web.controller;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.ProductService;
import me.liuhui.mall.manager.service.dto.product.CreateProductDTO;
import me.liuhui.mall.manager.service.dto.product.ListProductDTO;
import me.liuhui.mall.manager.service.dto.product.ModifyProductDTO;
import me.liuhui.mall.manager.service.vo.product.ListProductVO;
import me.liuhui.mall.manager.service.vo.product.ProductVO;
import me.liuhui.mall.manager.web.annotation.PerCode;
import me.liuhui.mall.repository.model.enums.ProductStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Validated
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @PerCode("product:mgt")
    @GetMapping("list")
    public ResultVO<ListProductVO> list(ListProductDTO dto) {
        return productService.list(dto);
    }

    @PerCode("product:update")
    @GetMapping("detail")
    public ResultVO<ProductVO> detail(@Validated @NotNull Long id) {
        return productService.detail(id);
    }


    @PerCode("product:publish")
    @PostMapping("publish")
    public ResultVO<Boolean> publish(@RequestBody @Validated @NotNull @Size(min = 1) Set<Long> ids) {
        return productService.publish(ids);
    }

    @PerCode("product:suspend")
    @PostMapping("suspend")
    public ResultVO<Boolean> suspend(@RequestBody @Validated @NotNull @Size(min = 1) Set<Long> ids) {
        return productService.suspend(ids);
    }


    @PerCode("product:add")
    @PostMapping("create")
    public ResultVO<Boolean> create(@Validated @RequestBody CreateProductDTO dto) {
        return productService.create(dto);
    }

    @PerCode("product:update")
    @PostMapping("modify")
    public ResultVO<Boolean> modify(@Validated @RequestBody ModifyProductDTO dto) {
        return productService.modify(dto);
    }

    @PerCode("product:del")
    @DeleteMapping("delete")
    public ResultVO<Boolean> delete(@RequestBody @Validated @NotNull @Size(min = 1) Set<Long> ids) {
        return productService.delete(ids);
    }

    @PerCode({"ad:add", "ad:update"})
    @GetMapping("select")
    public ResultVO<ListProductVO> select(ListProductDTO dto) {
        dto.setStatus(ProductStatus.SELLING.getCode());
        return productService.list(dto);
    }

}
