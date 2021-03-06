package com.mobaijun.common.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;

import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: RedirectUrlBuildUtil
 * class description：构建redirect url的工具类
 *
 * @author MoBaiJun 2022/5/12 11:38
 */
public class RedirectUrlBuildUtils {

    /**
     * 构建redirect url
     *
     * @param originUrl 原始的url
     * @param paramsMap url上要拼接的参数信息
     * @return String
     */
    public static String createRedirectUrl(String originUrl, Map<String, ?> paramsMap) {
        if (StrUtil.isBlank(originUrl)) {
            return null;
        }
        if (ObjectUtil.isEmpty(paramsMap)) {
            return originUrl;
        } else {
            return originUrl + "?" + URLUtil.buildQuery(paramsMap, CharsetUtil.CHARSET_UTF_8);
        }
    }
}
