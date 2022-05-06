package com.mobaijun.common.service.impl;

import com.mobaijun.common.service.FileService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: FileServiceImpl
 * 类描述： 文件上传
 *
 * @author MoBaiJun 2022/5/6 16:33
 */
public class FileServiceImpl implements FileService {

    @Override
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request) {

    }

    @Override
    public <T> T uploadFile(MultipartFile file) {
        return null;
    }
}
