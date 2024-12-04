package com.mobaijun.common.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Description: [用户]
 * Author: [mobaijun]
 * Date: [2024/12/4 11:57]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User implements Serializable {
    String name;
    Integer age;
    Integer height;
}
