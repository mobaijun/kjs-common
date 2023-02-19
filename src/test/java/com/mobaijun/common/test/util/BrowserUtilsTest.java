package com.mobaijun.common.test.util;

import com.mobaijun.common.util.BrowserUtil;
import org.junit.Test;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: BrowserUtilsTest
 * class description:
 *
 * @author MoBaiJun 2022/11/22 17:48
 */
public class BrowserUtilsTest {

    @Test
    public void openUrlTest() {
        // Invoke the default browser to open the specified webpage
        BrowserUtil.openUrl("https://www.mobaijun.com");
    }
}
