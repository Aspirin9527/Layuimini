package me.liuhui.mall.manager.kmeans;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lin
 * @date 2023年04月13日 14:38
 */
public class DataPoint {
    private String goods;
    private final double[] features;

    public DataPoint(String goods, double[] features) {
        this.goods = goods;
        this.features = features;
    }

    public DataPoint(double[] features) {
        this.features = features;
    }

    public double[] getFeatures() {
        return features;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < features.length; i++) {
            sb.append(features[i]);
            if (i < features.length - 1) {
                sb.append(", ");
            }
        }
        if (!StringUtils.isBlank(goods)){
            sb.append(",").append(goods);
        }
        sb.append(")");
        return sb.toString();
    }
}
