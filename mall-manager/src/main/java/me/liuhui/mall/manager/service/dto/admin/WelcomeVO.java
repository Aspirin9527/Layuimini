package me.liuhui.mall.manager.service.dto.admin;

import me.liuhui.mall.repository.model.dao.DateCount;
import lombok.Data;

import java.util.List;

/**
 * Created on 2020/11/11 14:37
 * <p>
 * Description: [TODO]
 * <p>
 * Company: []
 *
 * @author [清远]
 */
@Data
public class WelcomeVO {
    private Long userNum;
    private Long productNum;
    private Long orderNum;
    private Double orderAmount;
    private List<DateCount> loginCount;
    private List<DateCount> orderCount;
}
