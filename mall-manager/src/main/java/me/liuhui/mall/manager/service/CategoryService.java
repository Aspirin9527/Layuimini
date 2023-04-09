package me.liuhui.mall.manager.service;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.dto.category.CreateCategoryDTO;
import me.liuhui.mall.manager.service.dto.category.ModifyCategoryDTO;
import me.liuhui.mall.manager.service.vo.category.CategoryVO;

import java.util.List;
import java.util.Set;


public interface CategoryService {


	ResultVO<Boolean> create(CreateCategoryDTO dto);

	ResultVO<Boolean> modify(ModifyCategoryDTO dto);

	ResultVO<Boolean> delete(Set<Long> ids);

	ResultVO<List<CategoryVO>> subCategory(Long pid);
}
