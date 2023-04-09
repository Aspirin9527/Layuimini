package me.liuhui.mall.repository.model.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Created on 2020/11/11 16:44
 * <p>
 * Description: [TODO]
 * <p>
 * Company: []
 *
 * @author [清远]
 */
@Data
public class DateCount {
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date date;
    private Long num;
}
