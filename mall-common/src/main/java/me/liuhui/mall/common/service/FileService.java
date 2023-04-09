package me.liuhui.mall.common.service;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.common.service.dto.SaveAdHtmlDTO;
import me.liuhui.mall.common.service.dto.TempToAdDTO;
import me.liuhui.mall.common.service.dto.TempToProductDTO;
import me.liuhui.mall.common.service.dto.UploadFileDTO;
import me.liuhui.mall.common.service.vo.FileVO;

import java.io.IOException;

/**
 * Created on 2020/10/22 16:26
 * <p>
 * Description: [TODO]
 * <p>
 * Company: []
 *
 * @author [清远]
 */
public interface FileService {
    /**
     * 上传临时文件
     *
     * @param dto
     * @return
     */
    ResultVO<FileVO> uploadTemp(UploadFileDTO dto) throws IOException;

    ResultVO<FileVO> tempToAd(TempToAdDTO dto);

    ResultVO<FileVO> tempToProduct(TempToProductDTO dto);

    ResultVO<FileVO> saveAdHtml(SaveAdHtmlDTO dto);
}
