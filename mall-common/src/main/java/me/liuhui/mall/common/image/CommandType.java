package me.liuhui.mall.common.image;

/**
 * Created on 2018/9/6 15:57
 * <p>
 * Description: []
 * <p>
 * Company: []
 *
 * @author [清远]
 */
public enum CommandType {
    CONVERT("转换处理"), IDENTIFY("图片信息"), COMPOSITE("图片合成");
    private final String name;

    CommandType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
