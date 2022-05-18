package com.mobaijun.common.util.sensitive;

import cn.hutool.core.date.DateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: TestDemo
 * class description：
 *
 * @author MoBaiJun 2022/5/18 10:55
 */
@Getter
@Setter
public class TestDemo {
    @Mask(prefixNoMaskLen = 2, suffixNoMaskLen = 2)
    private String arce;

    @Mask(prefixNoMaskLen = 1)
    private String name;

    @Mask(prefixNoMaskLen = 4)
    private String birthday;

    @Mask(prefixNoMaskLen = 4)
    private String email;

    @Override
    public String toString() {
        // 重写toString（）方法
        return new MaskToStringBuilder(this).toString();
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        testDemo.setArce("4547665157465765");
        testDemo.setName("墨白君");
        testDemo.setEmail("mobaijun8@163.com");
        testDemo.setBirthday(DateTime.now().toString());
        System.out.println("testDemo = " + testDemo);
    }
}
