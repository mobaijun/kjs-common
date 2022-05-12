package com.mobaijun.common.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: LicenseTitleAppenderUtil
 * class description：一键添加开源协议头
 *
 * @author MoBaiJun 2022/5/12 11:35
 */
public class LicenseTitleAppenderUtil {

    /**
     * 添加开源协议
     *
     * @param codeDirectory 代码路径
     * @param licenseHeader 协议头
     */
    public static void append(String codeDirectory, String licenseHeader) {
        List<File> files = FileUtil.loopFiles(codeDirectory);
        for (File file : files) {
            if (file.getName().endsWith(".java")) {
                List<String> strings = FileUtil.readLines(file, CharsetUtil.UTF_8);
                if (!strings.get(0).equals("/*")) {
                    ArrayList<Object> newLines = new ArrayList<>();
                    newLines.add(licenseHeader);
                    newLines.addAll(strings);
                    FileUtil.writeUtf8Lines(newLines, file);
                }
            }
        }
    }
}
