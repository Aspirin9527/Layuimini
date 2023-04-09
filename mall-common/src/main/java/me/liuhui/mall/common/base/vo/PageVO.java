package me.liuhui.mall.common.base.vo;

import lombok.Data;

import java.util.List;

/**
 * Created on 2019/11/18 17:31
 * <p>
 * Description: [TODO]
 * <p>
 *
 * @author [清远]
 */

@Data
public class PageVO<T> {

    /**
     * 总共多少条记录
     */
    private Long total;
    /**
     * 数据
     */
    private List<T> list;


    @Override
    public String toString() {
        return "PageVO{" +
                "total=" + total +
                '}';
    }
}
