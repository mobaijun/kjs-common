package com.mobaijun.common.util.http;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: PostmanUtils
 * class description：实现postman中主要请求方式
 * 运行环境：
 * fastjson-1.2.7
 * jdk1.8.0_131
 *
 * @author MoBaiJun 2022/5/26 9:11
 */
public class PostmanUtils {


    public static String sendPost(String url, Map<String, Object> param, String charset) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        String line;
        StringBuilder sb = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性 设置请求格式
            conn.setRequestProperty("contentType", charset);
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            //设置超时时间
           conn.setConnectTimeout(60);
           conn.setReadTimeout(60);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应    设置接收格式
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
        } catch (Exception e) {
            System.out.println("发送 POST请求出现异常!" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String postUrl = "http://192.168.31.80:8000/rpc/2.0/cvsaas/v1/device/add";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("deviceName", "守护小猪窝");
        params.put("rtspAddress", "rtmp://rtmp01open.ys7.com/openlive/b41d634ec9984700a03db5865dc514cc.hd");
        params.put("deviceStatus", "1");
        params.put("remark", "监控小猪窝");
        JSONObject powerObject = JSONUtil.parseObj(params.toString());
        System.out.println("map转换json:" + powerObject);
        System.out.println("Post请求返回数据:" + PostmanUtils.sendPost(postUrl, powerObject, "utf-8"));
    }
}
