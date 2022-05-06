package com.mobaijun.common.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * InterfaceName: FileService
 * 接口描述： 文件上传接口
 *
 * @author MoBaiJun 2022/5/6 16:32
 */
public interface FileService {

    /**
     * 通用下载
     *
     * @param fileName 文件名称
     * @param delete   是否删除
     * @param response HttpServletResponse
     * @param request  HttpServletRequest
     */
    void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request);

    /**
     * 通用上传请求
     *
     * @param file 文件
     * @param <T>  类型
     */
    <T> T uploadFile(MultipartFile file);
}
