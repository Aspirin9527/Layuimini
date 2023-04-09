package me.liuhui.mall.manager.web.controller;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.common.service.FileService;
import me.liuhui.mall.common.service.dto.UploadFileDTO;
import me.liuhui.mall.common.service.vo.FileVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created on 2020/10/21 16:27
 * <p>
 * Description: [TODO]
 * <p>
 * Company: []
 *
 * @author [清远]
 */
@Slf4j
@RequestMapping("/api/file")
@RestController
public class FileController {

    @Resource
    private FileService fileService;

    @PostMapping("/upload")
    public ResultVO<FileVO> devUpload(@RequestParam MultipartFile file) throws IOException {
        UploadFileDTO dto = new UploadFileDTO();
        dto.setFilename(file.getOriginalFilename());
        dto.setInputStream(file.getInputStream());
        return fileService.uploadTemp(dto);
    }

//    @PostMapping("/upload")
//    public ResultVO<String> upload(@RequestParam MultipartFile file) throws IOException {
//        String date = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
//        String path = "/" + date + "/" + System.currentTimeMillis() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
//        File targetFile = new File(tempPath + path);
//        if (!targetFile.getParentFile().exists()) {
//            boolean mkdirs = targetFile.getParentFile().mkdirs();
//            log.info("创建父目录{}{}", targetFile.getAbsolutePath(), mkdirs ? "成功" : "失败");
//        }
//        file.transferTo(targetFile);
//        return ResultVO.buildSuccessResult(fileDomain + path);
//    }
}
