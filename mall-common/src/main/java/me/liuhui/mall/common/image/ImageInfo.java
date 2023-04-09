package me.liuhui.mall.common.image;

import lombok.Data;

/**
 * Created on 2018/9/4 10:31
 * <p>
 * Description: []
 * <p>
 * Company: []
 *
 * @author [清远]
 */
@Data
public class ImageInfo {
    private Integer width;
    private Integer height;
    private String extension;
    /**
     * 单位M
     */
    private Double size;
    private String path;
    private String quality;


}
