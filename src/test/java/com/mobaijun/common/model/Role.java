package com.mobaijun.common.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Description: []
 * Author: [mobaijun]
 * Date: [2024/12/4 12:00]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Role implements Serializable {
    String roleName;
    Integer seqNo;
}
