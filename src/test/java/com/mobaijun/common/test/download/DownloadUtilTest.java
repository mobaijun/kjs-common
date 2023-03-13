package com.mobaijun.common.test.download;

import com.mobaijun.common.download.DownloadUtil;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: DownloadUtilTest<br>
 * class description:
 *
 * @author MoBaiJun 2023/3/13 11:47
 */
public class DownloadUtilTest {

    @Test
    public void downloadFile() throws IOException {
        DownloadUtil.downloadFile("https://tencent.cos.mobaijun.com/img/banner/2.jpg",
                "D:\\ideaProject\\kjs-projects\\kjs-common\\src\\test\\java\\com\\mobaijun\\common\\test\\download\\2.jpg");
    }

    @Test
    public void copyFile() {
        DownloadUtil.copyFile(new File("D:\\ideaProject\\kjs-projects\\kjs-common\\src\\test\\java\\com\\mobaijun\\common\\test\\download\\2.jpg"),
                new File("D:\\ideaProject\\kjs-projects\\kjs-common\\src\\test\\java\\com\\mobaijun\\common\\test\\download\\3.jpg"));
    }
}