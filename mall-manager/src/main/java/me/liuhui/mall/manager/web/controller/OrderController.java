package me.liuhui.mall.manager.web.controller;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.OrderService;
import me.liuhui.mall.manager.service.ProductService;
import me.liuhui.mall.manager.service.dto.order.CreateOrderDTO;
import me.liuhui.mall.manager.service.dto.order.ListOrderDTO;
import me.liuhui.mall.manager.service.dto.order.ModifyOrderDTO;
import me.liuhui.mall.manager.service.dto.order.OrderDTO;
import me.liuhui.mall.manager.service.dto.product.ListProductDTO;
import me.liuhui.mall.manager.service.vo.order.ListOrderVO;
import me.liuhui.mall.manager.service.vo.product.ListProductVO;
import me.liuhui.mall.manager.web.annotation.PerCode;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Validated
@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Resource
	private OrderService orderService;
	@Resource
	private ProductService productService;

	@PerCode("order:mgt")
	@GetMapping("list")
	public ResultVO<ListOrderVO> list(ListOrderDTO dto) {
		return orderService.list(dto);
	}

	//@PerCode("order:add")
	@PostMapping("create")
	public ResultVO<Boolean> create(@RequestBody OrderDTO dto) {
		return orderService.create(dto);
	}

	@PerCode("order:update")
	@PostMapping("modify")
	public ResultVO<Boolean> modify(@Validated @RequestBody ModifyOrderDTO dto) {
		return orderService.modify(dto);
	}

	@PerCode("order:del")
	@DeleteMapping("delete")
	public ResultVO<Boolean> delete(@RequestBody @Validated @NotNull @Size(min = 1) Set<Long> ids) {
		return orderService.delete(ids);
	}

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


}
