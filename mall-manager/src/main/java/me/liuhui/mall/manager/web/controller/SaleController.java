package me.liuhui.mall.manager.web.controller;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.ProductService;
import me.liuhui.mall.manager.service.dto.product.ListProductDTO;
import me.liuhui.mall.manager.service.vo.product.ListProductVO;
import me.liuhui.mall.manager.service.vo.product.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    @Autowired
    private ProductService productService;


    /**
     * 获取已上架的货品
     * @param dto
     * @return
     */
    @PostMapping("getGoods")
    public ResultVO<ListProductVO> list(ListProductDTO dto) {
        dto.setStatus(1);
        return productService.list(dto);
    }

    @GetMapping("detail")
    public ResultVO<ProductVO> detail(@NotNull Long id) {
        return productService.detail(id);
    }
}
