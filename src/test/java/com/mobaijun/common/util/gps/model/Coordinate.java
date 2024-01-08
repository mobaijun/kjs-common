package com.mobaijun.common.util.gps.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Description: [经纬度类]
 * Author: [xiazh]
 * Date: [2024/1/2 11:49]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Coordinate {

    /**
     * 纬度
     */
    private double latitude;

    /**
     * 经度
     */
    private double longitude;
}
