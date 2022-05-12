package com.mobaijun.common.util.thread;

/**
 * software：IntelliJ IDEA 2022.1
 * interface name: RemoveThreadLocalApi
 * interface description：对程序进行拓展，方便清除ThreadLocal
 *
 * @author MoBaiJun 2022/5/12 11:33
 */
public interface RemoveThreadLocalApi {

    /**
     * 具体删除ThreadLocal的逻辑
     */
    void removeThreadLocalAction();
}
