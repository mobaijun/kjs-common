package com.mobaijun.common.util.http;

import cn.hutool.http.GlobalHeaders;
import cn.hutool.http.Header;
import cn.hutool.http.HttpConnection;
import cn.hutool.log.Log;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: HttpUtils
 * class description： http 工具类
 *
 * @author MoBaiJun 2022/7/18 10:05
 */
public class HttpUtils {

    /**
     * tools log
     */
    private static final Log log = Log.get(HttpUtils.class);

    /**
     * 获取 http 链接
     *
     * @param url url
     * @return HttpConnection
     */
    public static HttpConnection getHttpConnection(String url) {
        return HttpConnection.create(url, null).header(Header.USER_AGENT.getValue(),
                GlobalHeaders.INSTANCE.header(Header.USER_AGENT.getValue()), false);
    }
}
