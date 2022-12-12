package com.mobaijun.common.test.function;

import com.mobaijun.common.function.VoidMethod;
import com.mobaijun.common.function.impl.IfFunction;
import com.mobaijun.common.util.collection.CollectionUtil;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: FunctionTest
 * class description: lambda 方法测试
 *
 * @author MoBaiJun 2022/11/22 14:33
 */
public class FunctionTest {
    public static void main(String[] args) {
        VoidMethod voidMethod = FunctionTest::start;

        IfFunction<String> ifFunction = new IfFunction<>(CollectionUtil.newHashMap(10));
        // 定义好要判断的条件和对应执行的方法
        ifFunction.add("1", () -> System.out.println("苹果"))
                .add("2", () -> System.out.println("西瓜"))
                .add("3", () -> System.out.println("橙子"));

        // 要进入的条件
        ifFunction.doIf("3");
        // 执行默认方法
        ifFunction.doIfWithDefault("4", () -> System.out.println("默认方法"));
    }

    private static void start() {
        System.out.println("true = " + true);
    }
}
