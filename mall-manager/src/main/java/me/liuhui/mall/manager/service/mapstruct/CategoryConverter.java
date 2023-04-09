
package me.liuhui.mall.manager.service.mapstruct;


import me.liuhui.mall.manager.service.dto.category.CreateCategoryDTO;
import me.liuhui.mall.manager.service.dto.category.ModifyCategoryDTO;
import me.liuhui.mall.manager.service.vo.category.CategoryVO;
import me.liuhui.mall.repository.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

/**
 * Created on 2020/10/14 18:51
 * <p>
 *
 * @author [清远]
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter {

    List<CategoryVO> toVo(List<Category> entityList);

    Set<CategoryVO> toVo(Set<Category> entityList);

    Category createDtoToEntity(CreateCategoryDTO dto);

    Category modifyDtoToEntity(ModifyCategoryDTO dto);
}
