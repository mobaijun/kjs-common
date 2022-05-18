package com.mobaijun.common.util.download;

import com.mobaijun.common.util.constant.Constant;
import com.mobaijun.common.util.constant.DateConstant;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: DownloadUtils
 * 类描述： 文件下载
 *
 * @author MoBaiJun 2022/5/5 8:59
 */
public class DownloadUtils {

    /**
     * 存储图片
     *
     * @param picUrls 下载地址
     * @param path    存储地址
     * @return url path
     */
    public static String pictureStorage(String picUrls, String path) {
        // 生成文件名称
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        Date date = new Date();
        String dataForm = new SimpleDateFormat(DateConstant.YYYY_MM_DD).format(date);
        String filePath = path + dataForm + "/";
        // 如果不存在,创建文件夹
        File f = new File(filePath);
        if (!f.exists()) {
            // 输出文件流
            f.mkdirs();
        }
        String fileName = DownloadUtils.downLoadJpg(picUrls, uuid, filePath);
        return "" + dataForm + "/" + fileName + "";
    }


    /**
     * 下载文件到本地
     *
     * @param urlString url
     * @param uuid      uuid
     * @param localPath 存储路径
     * @return url path
     */
    public static String downLoadJpg(String urlString, String uuid, String localPath) {
        try {
            // 网络URL
            URL url = new URL(urlString);
            // 打开网络连接
            URLConnection connection = url.openConnection();
            // 输入流
            InputStream inputStream = connection.getInputStream();
            OutputStream outputStream = Files.newOutputStream(Paths.get(localPath + uuid + Constant.IMAGE_JPG));
            // 缓冲区对象
            byte[] b = new byte[1024];
            // 读取计数器
            int len;
            while ((len = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, len);
            }
            // 关闭输入流操作
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 关闭输出流操作
            try {
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 监听下载成功
        } catch (Exception e) {
            // 监听下载失败
            e.printStackTrace();
        }
        return uuid + Constant.IMAGE_JPG;
    }
}
