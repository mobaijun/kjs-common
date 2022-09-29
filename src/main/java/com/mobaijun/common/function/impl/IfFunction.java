package com.mobaijun.common.function.impl;

import com.mobaijun.common.function.JudgeFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: IfFunction
 * class description：代替'if else' 和 'switch'的方法
 *
 * @param <K> 限定的参数类型
 * @author MoBaiJun 2022/9/29 8:34
 */
public class IfFunction<K> {

    /**
     * 通过map保存
     */
    private Map<K, JudgeFunction> map;

    /**
     * 通过map类型来保存对应的条件key和方法
     *
     * @param map a map
     */
    public IfFunction(Map<K, JudgeFunction> map) {
        this.map = map;
    }

    /**
     * 添加条件
     *
     * @param key      需要验证的条件（key）
     * @param function 要执行的方法
     * @return this.
     */
    public IfFunction<K> add(K key, JudgeFunction function) {
        this.map.put(key, function);
        return this;
    }

    /**
     * 确定key是否存在，如果存在，则执行相应的方法。
     *
     * @param key the key need to verify
     */
    public void doIf(K key) {
        if (this.map.containsKey(key)) {
            map.get(key).invoke();
        }
    }

    /**
     * 确定key是否存在，如果存在，则执行相应的方法。
     * 否则将执行默认方法
     *
     * @param key             需要验证的条件（key）
     * @param defaultFunction 要执行的方法
     */
    public void doIfWithDefault(K key, JudgeFunction defaultFunction) {
        if (this.map.containsKey(key)) {
            map.get(key).invoke();
        } else {
            defaultFunction.invoke();
        }
    }

    public static void main(String[] args) {
        IfFunction<String> ifFunction = new IfFunction<>(new HashMap<>(5));
        // 定义好要判断的条件和对应执行的方法
        ifFunction.add("1", () -> System.out.println("苹果"))
                .add("2", () -> System.out.println("西瓜"))
                .add("3", () -> System.out.println("橙子"));

        // 要进入的条件
        ifFunction.doIf("3");
        // 执行默认方法
        ifFunction.doIfWithDefault("4", () -> System.out.println("默认方法"));
    }
}