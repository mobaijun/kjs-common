package com.mobaijun.common.annotation.env;

import com.mobaijun.common.enums.EnvEnum;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * annotation name: Env<br>
 * annotation description: 环境注解<br>
 *
 * @author MoBaiJun 2022/12/16 16:00
 */
public @interface Env {

    /**
     * 默认值
     *
     * @return dev
     */
    EnvEnum value() default EnvEnum.DEV;
}
