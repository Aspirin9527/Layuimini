package me.liuhui.mall.manager.service.dto.order;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author lin
 * @date 2023年04月13日 18:23
 */
@Data
public class AnalyseOrderDTO {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minCreateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxCreateTime;
}
