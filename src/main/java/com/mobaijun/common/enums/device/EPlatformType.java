/*
 * Copyright (C) 2022 [www.mobaijun.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mobaijun.common.enums.device;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * enum name: EPlatformType<br>
 * enum description： 操作系统枚举
 *
 * @author MoBaiJun 2022/10/28 9:47
 */
@Getter
@RequiredArgsConstructor
public enum EPlatformType {

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