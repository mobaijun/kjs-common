package com.mobaijun.common.base.controller;

import com.mobaijun.common.base.BaseWrapper;
import com.mobaijun.common.exception.CustomException;
import com.mobaijun.common.result.ErrorTip;
import com.mobaijun.common.result.SuccessTip;
import com.mobaijun.common.util.ObjectUtils;
import com.mobaijun.common.util.StringUtils;
import com.mobaijun.common.util.page.PageInfo;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: BaseController
 * 类描述： 通用数据处理
 *
 * @author MoBaiJun 2022/4/22 16:54
 */
public class BaseController {

    /**
     * 成功
     */
    protected static String SUCCESS = "SUCCESS";

    /**
     * 错误
     */
    protected static String ERROR = "ERROR";

    /**
     * 重定向
     */
    protected static String REDIRECT = "redirect:";

    /**
     * 转发
     */
    protected static String FORWARD = "forward:";

    /**
     * 成功返回
     */
    protected static SuccessTip<?> SUCCESS_TIP = new SuccessTip<>();

    /**
     * 异常返回
     */
    protected static ErrorTip<?> ERROR_TIP = new ErrorTip<>();

    /**
     * 参数是否为空的校验
     *
     * @param object  对象
     * @param message 消息
     */
    public void assertNotNull(Object object, String message) {
        if (ObjectUtils.isEmpty(object)) {
            throw new CustomException(message);
        }
    }

    /**
     * 参数是否为空的校验
     *
     * @param str     字符串
     * @param message 消息
     */
    public void assertNotEmpty(String str, String message) {
        if (StringUtils.isEmpty(str)) {
            throw new CustomException(message);
        }
    }

    /**
     * 判断条件是否符合
     *
     * @param condition 判断条件
     * @param message   消息
     */
    public void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new CustomException(message);
        }
    }

    /**
     * 把service层的分页信息，封装为bootstrap table通用的分页封装
     *
     * @param page 分页信息
     * @param <T>  分页对象
     * @return 分页结果集
     */
    protected <T> PageInfo<T> packForBt(PageInfo<T> page) {
        return new PageInfo<T>(page);
    }

    /**
     * 包装一个list，让list增加额外属性
     *
     * @param warpper warpper
     * @return Object
     */
    protected Object warpObject(BaseWrapper warpper) {
        return warpper.warp();
    }
}
