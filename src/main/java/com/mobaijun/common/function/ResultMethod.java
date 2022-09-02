package com.mobaijun.common.function;

/**
 * software：IntelliJ IDEA 2022.1
 * interface name: ResultMethod
 * interface description：
 *
 * @author MoBaiJun 2022/9/2 14:15
 */
@FunctionalInterface
public interface ResultMethod<T> {

    /**
     * 执行并返回一个结果
     *
     * @return 结果
     */
    T run();
}
