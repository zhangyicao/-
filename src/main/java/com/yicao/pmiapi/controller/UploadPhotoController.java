package com.yicao.pmiapi.controller;

import com.yicao.pmiapi.pojo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@RestController
@Slf4j
public class UploadPhotoController {
    /**
     * 时间格式化
     */
//    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/");

    /**
     * 图片保存路径，自动从yml文件中获取数据
     * 示例： E:/images/
     */
    @Value("${file-save-path}")
    private String fileSavePath;

    @PostMapping(path = "/upload")
    public JsonResult uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //1.后半段目录：  2020/03/15
//        String directory = simpleDateFormat.format(new Date());
        /**
         *  2.文件保存目录  E:/images/2020/03/15/
         *  如果目录不存在，则创建
         */
        File dir = new File(fileSavePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        log.info("图片上传，保存位置：" + fileSavePath);
        //3.给文件重新设置一个名字
        //后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
        //4.创建这个新文件
        File newFile = new File( fileSavePath + newFileName);
        //5.复制操作
        try {
            file.transferTo(newFile);
            //协议 :// ip地址 ：端口号 / 文件目录(/images/2020/03/15/xxx.jpg)
            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/images/" + newFileName;
            log.info("图片上传，访问URL：" + url);
            return JsonResult.builder().data(url).message("上传成功！").code(1).build();
        } catch (IOException e) {
            return JsonResult.builder().data(null).message("IO异常！").code(-1).build();
        }
    }
}
