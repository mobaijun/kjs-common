package com.mobaijun.common.test.util;

import com.mobaijun.common.util.LicenseTitleAppenderUtils;
import com.mobaijun.common.constant.LicenseConstant;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: LicenseTitleAppenderUtilsTest
 * class description:
 *
 * @author MoBaiJun 2022/11/22 17:48
 */
public class LicenseTitleAppenderUtilsTest {
    public static void main(String[] args) {
        LicenseTitleAppenderUtils.append("D:\\ideaProject\\kjs-projects\\kjs-common\\src\\main\\java\\com\\mobaijun\\common"
                , LicenseConstant.APACHE_2);
    }
}
