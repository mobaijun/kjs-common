package com.mobaijun.common.test.download;

import com.mobaijun.common.download.DownloadUtil;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: DownloadUtilsTest
 * class description: 下载测试工具类
 *
 * @author MoBaiJun 2022/11/22 14:27
 */
public class DownloadUtilsTest {
    public static void main(String[] args) {
        // 进度条下载
        DownloadUtil.downloadFile("https://tencent.cos.mobaijun.com/img/icon/avatar.jpg",
                "F:\\ideaProject\\kjs-project\\kjs-common\\src\\test\\java\\com\\mobaijun\\common\\util\\test\\download");

        // 下载文件（uuid文件名）
        DownloadUtil.downLoadJpg("https://tencent.cos.mobaijun.com/img/icon/avatar.jpg",
                "F:\\ideaProject\\kjs-project\\kjs-common\\src\\test\\java\\com\\mobaijun\\common\\util\\test\\download");

        // 下载文件（uuid文件名）日期做目录
        DownloadUtil.pictureStorage("F:\\ideaProject\\kjs-project\\kjs-common\\src\\test\\java\\com\\mobaijun\\common\\util\\test\\download",
                "https://tencent.cos.mobaijun.com/img/icon/avatar.jpg");
    }
}
