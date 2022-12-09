package com.mobaijun.common.util.system;

import cn.hutool.core.io.FileUtil;
import com.mobaijun.common.constant.JdkConstant;
import com.mobaijun.common.util.text.Charsets;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * software：IntelliJ IDEA 2022.2.3<br/>
 * class name: HostUtil<br/>
 * class description: host 工具类<br/>
 * 如果遇到 host 文件没有权限写入，请先右键host文件 -> 安全 -> 当前用户 -> 编辑 -> 当前用户 -> 勾选完全控制，如下图<br/>
 * <img src="https://tencent.cos.mobaijun.com//xxbj_img/image-20221210004329990.png"/>
 *
 * @author MoBaiJun 2022/12/9 23:15
 */
public class HostUtil {

    /**
     * Windows host file path
     */
    private static final Path WIN_HOSTS_PATH = Paths.get("C:\\Windows\\System32\\drivers\\etc\\hosts");

    /**
     * linux host file path
     */
    private static final Path LINUX_HOSTS_PATH = Paths.get("/etc/hosts");

    /**
     * Windows
     */
    private static final String WINDOWS = "Windows";

    /**
     * Windows flush dns
     */
    private static final String FLUSH_DNS = "ipconfig /flushdns";

    /**
     * Line break character
     */
    private static final String END = String.format("%n");


    /**
     * 获取操作系统类型返回 host 文件地址
     *
     * @return host 文件地址
     */
    public static String getOsName() {
        String osName = java.lang.System.getProperty(JdkConstant.OS_NAME);
        if (WINDOWS.regionMatches(1, osName, 1, 1)) {
            return WIN_HOSTS_PATH.toString();
        }
        return LINUX_HOSTS_PATH.toString();
    }


    /**
     * 读取 host 文件内容
     *
     * @return list 集合
     */
    public static List<String> readHosts() {
        return FileUtil.readLines(getOsName(), Charsets.UTF_8)
                .stream()
                .filter(it -> !it.trim().matches("(^#.*)|(\\s*)"))
                .map(it -> it.replaceAll("#.*", "").trim()
                        .replaceAll("\\s+", "\t"))
                .collect(Collectors.toList());
    }


    /**
     * 追加写入 host
     *
     * @param ip  IP 地址
     * @param url 映射地址
     * @return 是否成功
     */
    public static boolean append(String ip, String url) {
        // 存在返回 false
        if (exists(ip, url)) {
            return false;
        }
        List<String> sets = readHosts();
        sets.add(String.format("%s\t%s", ip, url));
        return FileUtil.writeUtf8String(String.join(END, sets), getOsName()).exists() && flushDns();
    }

    /**
     * 当前 IP 地址是否存在 host 文件中
     *
     * @param ip  IP 地址
     * @param url 映射地址
     * @return 是否存在
     */
    public static boolean exists(String ip, String url) {
        return readHosts().contains(String.format("%s\t%s", ip, url));
    }

    /**
     * 刷新 dbs
     *
     * @return 是否成功
     */
    public static boolean flushDns() {
        try {
            Runtime.getRuntime().exec(FLUSH_DNS);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
