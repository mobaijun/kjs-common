package com.mobaijun.common.util.collection;

import java.util.HashMap;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: CountMap
 * class description：计数map
 *
 * @author MoBaiJun 2022/5/31 11:35
 */
public class CountMap<KEY> extends HashMap<KEY, Integer> {

    public void increment(KEY key) {
        put(key, get(key) + 1);
    }

    public void increment(KEY key, int step) {
        put(key, get(key) + step);
    }

    @Override
    public Integer get(Object key) {
        Integer integer = super.get(key);
        return integer == null ? 0 : integer;
    }
}
