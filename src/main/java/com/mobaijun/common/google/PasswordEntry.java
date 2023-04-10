package com.mobaijun.common.google;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: PasswordEntity<br>
 * class description:  PasswordEntry类封装了密码管理器导出的每一条密码记录的信息，包括网站或应用程序名称、用户名、密码、URL、笔记/注释。
 *
 * @author MoBaiJun 2023/4/6 10:54
 */
@Getter
@Setter
@ToString
public class PasswordEntry {

    /**
     * 网站或应用程序名称
     */
    private String name;

    /**
     * 用户名或电子邮件地址
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * URL
     */
    private String url;

    /**
     * 笔记或注释
     */
    private String note;

    public PasswordEntry(String name, String url, String username, String password, String note) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.url = url;
        this.note = note;
    }
}
