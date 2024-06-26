package com.atguigu.ssyx.product.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName: FileUploadService
 * Package: com.atguigu.ssyx.product.service
 */
public interface FileUploadService {

    //文件上传
    String fileUpload(MultipartFile file) throws Exception;
}
