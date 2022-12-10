package com.mobaijun.common.test.util;

import com.mobaijun.common.constant.LicenseConstant;
import com.mobaijun.common.util.LicenseTitleAppenderUtil;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: LicenseTitleAppenderUtilsTest
 * class description:
 *
 * @author MoBaiJun 2022/11/22 17:48
 */
public class LicenseTitleAppenderUtilsTest {
    public static void main(String[] args) {
        LicenseTitleAppenderUtil.append("D:\\ideaProject\\kjs-projects\\kjs-common\\src\\main\\java\\com\\mobaijun\\common"
                , LicenseConstant.APACHE_2);
    }
}
