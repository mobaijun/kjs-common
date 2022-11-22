package com.mobaijun.common.util.test.download;

import cn.hutool.core.lang.UUID;
import com.mobaijun.common.download.DownloadUtils;

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
        DownloadUtils.downloadFile("https://tencent.cos.mobaijun.com/img/icon/avatar.jpg",
                "F:\\ideaProject\\kjs-project\\kjs-common\\src\\test\\java\\com\\mobaijun\\common\\util\\test\\download");

        // 下载文件（uuid文件名）
        DownloadUtils.downLoadJpg("https://tencent.cos.mobaijun.com/img/icon/avatar.jpg", UUID.fastUUID().toString(),
                "F:\\ideaProject\\kjs-project\\kjs-common\\src\\test\\java\\com\\mobaijun\\common\\util\\test\\download");

        // 下载文件（uuid文件名）日期做目录
        DownloadUtils.pictureStorage("F:\\ideaProject\\kjs-project\\kjs-common\\src\\test\\java\\com\\mobaijun\\common\\util\\test\\download",
                "https://tencent.cos.mobaijun.com/img/icon/avatar.jpg");
    }
}
