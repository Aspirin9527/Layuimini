package me.liuhui.mall.common.service.dto;

import lombok.Data;

import java.io.InputStream;

/**
 * Created on 2020/10/22 16:29
 * <p>
 * Description: [TODO]
 * <p>
 * Company: []
 *
 * @author [清远]
 */
@Data
public class UploadFileDTO {
    private String filename;
    private InputStream inputStream;
}
