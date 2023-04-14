package me.liuhui.mall.manager.service.vo.order;

import lombok.Data;

import java.util.List;

/**
 * @author lin
 * @date 2023年04月14日 16:37
 */
@Data
public class OrderAnalyseVO {

    private String clusterGroup;

    private List<double[]> features;

}
