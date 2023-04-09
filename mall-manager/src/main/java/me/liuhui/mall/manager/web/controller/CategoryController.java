package me.liuhui.mall.manager.web.controller;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.CategoryService;
import me.liuhui.mall.manager.service.dto.category.CreateCategoryDTO;
import me.liuhui.mall.manager.service.dto.category.ModifyCategoryDTO;
import me.liuhui.mall.manager.service.vo.category.CategoryVO;
import me.liuhui.mall.manager.web.annotation.PerCode;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Validated
@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Resource
	private CategoryService categoryService;



	@PerCode("category:add")
	@PostMapping("create")
	public ResultVO<Boolean> create(@Validated @RequestBody CreateCategoryDTO dto) {
		return categoryService.create(dto);
	}

	@PerCode("category:update")
	@PostMapping("modify")
	public ResultVO<Boolean> modify(@Validated @RequestBody ModifyCategoryDTO dto) {
		return categoryService.modify(dto);
	}

	@PerCode("category:del")
	@DeleteMapping("delete")
	public ResultVO<Boolean> delete(@RequestBody @Validated @NotNull @Size(min = 1) Set<Long> ids) {
		return categoryService.delete(ids);
	}

	@PerCode({"category:mgt", "product:add", "product:modify"})
	@GetMapping("sub-category")
	public ResultVO<List<CategoryVO>> subCategory(Long pid) {
		return categoryService.subCategory(pid);
	}


}
