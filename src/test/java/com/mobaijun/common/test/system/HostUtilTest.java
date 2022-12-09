package com.mobaijun.common.test.system;

import com.mobaijun.common.util.PrintUtil;
import com.mobaijun.common.util.collection.CollectionUtil;
import com.mobaijun.common.util.system.HostUtil;

import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: HostUtilTest
 * class description: host 测试用例
 *
 * @author MoBaiJun 2022/12/10 0:45
 */
public class HostUtilTest {

    /**
     * 52.74.223.119 github.com
     * 69.171.248.65 github.global.ssl.fastly.net
     * 185.199.111.153 assets-cdn.github.com
     *
     * @param args 参数列表
     */
    public static void main(String[] args) {
        Map<String, String> map = CollectionUtil.newHashMap(10);
        map.put("69.171.248.65", "github.global.ssl.fastly.net");
        map.put("52.74.223.119", "github.com");
        map.put("185.199.111.153", "assets-cdn.github.com");
        // 打印是否修改成功
        map.forEach((key, value) -> PrintUtil.println(HostUtil.append(key, value)));

        // 打印修改后的结果
        PrintUtil.println(HostUtil.readHosts());
    }
}
