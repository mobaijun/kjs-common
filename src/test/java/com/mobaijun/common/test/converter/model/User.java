package com.mobaijun.common.test.converter.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: User
 * class description: 测试用户对象
 *
 * @author MoBaiJun 2022/12/10 18:40
 */
@Getter
@Setter
@ToString
public class User {
    private String name;
    private String address;
    private Integer age;
    private char deleted;
}
