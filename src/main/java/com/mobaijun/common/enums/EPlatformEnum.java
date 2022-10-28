package com.mobaijun.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: EPlatformEnum
 * enum description： 操作系统枚举
 *
 * @author MoBaiJun 2022/10/28 9:47
 */
@Getter
@AllArgsConstructor
public enum EPlatformEnum {

    /**
     * any
     */
    Any("any"),

    /**
     * Linux
     */
    Linux("Linux"),

    /**
     * Mac OS
     */
    Mac_OS("Mac OS"),

    /**
     * Mac OS X
     */
    Mac_OS_X("Mac OS X"),

    /**
     * Windows
     */
    Windows("Windows"),

    /**
     * OS/2
     */
    OS2("OS/2"),

    /**
     * Solaris
     */
    Solaris("Solaris"),

    /**
     * SunOS
     */
    SunOS("SunOS"),

    /**
     * MPE/iX
     */
    MPEiX("MPE/iX"),

    /**
     * HP-UX
     */
    HP_UX("HP-UX"),

    /**
     * AIX
     */
    AIX("AIX"),

    /**
     * OS/390
     */
    OS390("OS/390"),

    /**
     * FreeBSD
     */
    FreeBSD("FreeBSD"),

    /**
     * Irix
     */
    Irix("Irix"),

    /**
     * Digital Unix
     */
    Digital_Unix("Digital Unix"),

    /**
     * NetWare
     */
    NetWare_411("NetWare"),

    /**
     * OSF1
     */
    OSF1("OSF1"),

    /**
     * OpenVMS
     */
    OpenVMS("OpenVMS"),

    /**
     * Others
     */
    Others("Others");

    /**
     * 描述
     */
    private final String description;
}
