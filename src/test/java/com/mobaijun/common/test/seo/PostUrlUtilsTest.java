package com.mobaijun.common.test.seo;

import org.junit.Test;

import java.util.Vector;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: PostUrlUtilsTest
 * class description:
 *
 * @author MoBaiJun 2022/11/23 13:34
 */
public class PostUrlUtilsTest {

    @Test
    public void postUrlUtilsTest() {
        Vector<String> urls = new Vector<>();
        urls.addElement("https://www.mobaijun.com");
        urls.addElement("https://www.mobaijun.com/tags/");
        urls.addElement("https://www.mobaijun.com/posts/2902111757.html");
        // PrintUtil.print(PostUrlUtil.postUrl(urls, "http://data.zz.baidu.com/urls?site=https://www.mobaijun.com&token=IICsd5lPpvqZp6ztH15"));
    }
}
