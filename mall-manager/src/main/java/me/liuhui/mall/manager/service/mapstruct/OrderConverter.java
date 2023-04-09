
package me.liuhui.mall.manager.service.mapstruct;


import me.liuhui.mall.manager.service.dto.order.CreateOrderDTO;
import me.liuhui.mall.manager.service.dto.order.ModifyOrderDTO;
import me.liuhui.mall.manager.service.vo.order.OrderVO;
import me.liuhui.mall.repository.model.Order;
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
public interface OrderConverter {

    List<OrderVO> toVo(List<Order> entityList);

    Order createDtoToEntity(CreateOrderDTO dto);

    Order modifyDtoToEntity(ModifyOrderDTO dto);
}
