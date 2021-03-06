package com.mobaijun.common.util.text;

import java.util.regex.Pattern;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: WafUtil
 * class description： web 过滤工具类
 *
 * @author MoBaiJun 2022/5/12 10:37
 */
public class WafUtils {

    /**
     * 过滤xss
     *
     * @param value value
     * @return String
     */
    public static String stripXss(String value) {
        String rlt = null;
        Pattern scriptPattern;
        if (null != value) {
            // NOTE: It's highly recommended using the ESAPI library and uncomment the following line to
            // avoid encoded attacks.
            rlt = value.replaceAll("", "");

            // Avoid anything between script tags
            scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
            rlt = scriptPattern.matcher(rlt).replaceAll("");

            // Avoid anything in a src='...' type of expression
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE
                    | Pattern.MULTILINE | Pattern.DOTALL);
            rlt = scriptPattern.matcher(rlt).replaceAll("");

            // Remove any lonesome </script> tag
            scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
            rlt = scriptPattern.matcher(rlt).replaceAll("");

            // Remove any lonesome <script ...> tag
            scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE
                    | Pattern.MULTILINE | Pattern.DOTALL);
            rlt = scriptPattern.matcher(rlt).replaceAll("");

            // Avoid eval(...) expressions
            scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE
                    | Pattern.MULTILINE | Pattern.DOTALL);
            rlt = scriptPattern.matcher(rlt).replaceAll("");

            // Avoid expression(...) expressions
            scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE
                    | Pattern.MULTILINE | Pattern.DOTALL);
            rlt = scriptPattern.matcher(rlt).replaceAll("");

            // Avoid javascript:... expressions
            scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
            rlt = scriptPattern.matcher(rlt).replaceAll("");

            // Avoid vbscript:... expressions
            scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
            rlt = scriptPattern.matcher(rlt).replaceAll("");

            // Avoid onload= expressions
            scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE
                    | Pattern.MULTILINE | Pattern.DOTALL);
            rlt = scriptPattern.matcher(rlt).replaceAll("");
        }
        return rlt;
    }

    /**
     * 过滤SQL注入内容
     *
     * @param value 待处理内容
     * @return String
     */
    public static String stripSqlInjection(String value) {
        return value.replaceAll("('.+--)|(--)|(\\|)|(%7C)", "")
                .replaceAll("('.+--)|(--)|(%7C)", "");
    }

    /**
     * 过滤SQL/XSS注入内容
     *
     * @param value 待处理内容
     * @return String
     */
    public static String stripSqlXss(String value) {
        return stripXss(stripSqlInjection(value));
    }
}
