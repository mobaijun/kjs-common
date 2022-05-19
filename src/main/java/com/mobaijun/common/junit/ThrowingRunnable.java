package com.mobaijun.common.junit;

/**
 * software：IntelliJ IDEA 2022.1
 * interface name: ThrowingRunnable
 * interface description：
 * 接口描述：This interface facilitates the use of org.junit.Assert.assertThrows(Class, ThrowingRunnable)
 * from Java 8. It allows method references to void methods (that declare checked exceptions) to be
 * passed directly into assertThrows without wrapping. It is not meant to be implemented directly.
 *
 * @author MoBaiJun 2022/5/19 11:31
 */
public interface ThrowingRunnable {
    void run() throws Throwable;
}
