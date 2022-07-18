package com.mobaijun.common.download;

import cn.hutool.core.io.FileUtil;
import com.mobaijun.common.util.constant.DateConstant;
import com.mobaijun.common.util.constant.FileConstant;
import com.mobaijun.common.util.date.DateUtils;
import com.mobaijun.common.util.uid.UuidUtils;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

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
     * @param path    存储地址
     * @param picUrls 下载地址
     * @return 文件存储地址：2022-07-18\59bed7171c9549508f7c5791ab79218e.jpg
     */
    public static String pictureStorage(String path, String picUrls) {
        String dataForm = DateUtils.parseLocalDateTime(DateConstant.YYYY_MM_DD);
        String filePath = path + dataForm + "\\";
        // 如果不存在,创建文件夹
        File f = new File(filePath);
        if (!f.exists()) {
            // 输出文件流
            FileUtil.mkdir(f);
        }
        String fileName = DownloadUtils.downLoadJpg(picUrls, UuidUtils.getUUID(), filePath);
        return dataForm + "\\" + fileName;
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
            OutputStream outputStream = Files.newOutputStream(Paths.get(localPath + uuid + FileConstant.IMAGE_JPG));
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
        return uuid + FileConstant.IMAGE_JPG;
    }
}
