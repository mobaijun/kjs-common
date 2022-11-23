package com.mobaijun.common.test.seo;

import com.mobaijun.common.util.PrintUtils;
import com.mobaijun.common.util.seo.PostUrlUtils;

import java.io.IOException;
import java.util.Vector;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: PostUrlUtilsTest
 * class description:
 *
 * @author MoBaiJun 2022/11/23 13:34
 */
public class PostUrlUtilsTest {

    /**
     * 示例 demo
     *
     * @param args args
     * @throws IOException io 异常
     */
    public static void main(String[] args) throws IOException {
        Vector<String> urls = new Vector<>();
        urls.addElement("https://www.mobaijun.com");
        urls.addElement("https://www.mobaijun.com/tags/");
        urls.addElement("https://www.mobaijun.com/posts/2902111757.html");
        PrintUtils.print(PostUrlUtils.postUrl(urls, "http://data.zz.baidu.com/urls?site=https://www.mobaijun.com&token=IICsd5lPpvqZp6ztH15"));
    }
}
