package com.mobaijun.common.result;

import lombok.Getter;
import lombok.Setter;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: Tip
 * 类描述： 返回给前台的提示（最终转化为json形式）
 *
 * @Author MoBaiJun 2022/4/22 17:22
 */
@Getter
@Setter
public abstract class AbstractTip<T> {

    /**
     * 状态码
     */
    protected int code;

    /**
     * 返回消息
     */
    protected String message;

    /**
     * 返回数据
     */
    protected T data;
}
