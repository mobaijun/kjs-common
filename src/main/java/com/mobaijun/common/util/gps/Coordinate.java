package com.mobaijun.common.util.gps;

import lombok.Data;

/**
 * Description: [经纬度类]
 * Author: [xiazh]
 * Date: [2024/1/2 11:49]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Data
public class Coordinate {
    /**
     * 纬度
     */
    private double latitude;
    /**
     * 经度
     */
    private double longitude;

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
