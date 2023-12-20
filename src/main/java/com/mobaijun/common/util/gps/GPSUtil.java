/*
 * Copyright (C) 2022 [www.mobaijun.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mobaijun.common.util.gps;

import com.mobaijun.common.constant.RegxConstant;
import com.mobaijun.common.model.Model;
import com.mobaijun.common.util.number.NumberUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: GPSUtils<br>
 * class description：<br>
 *
 * @author MoBaiJun 2022/5/18 10:29
 */
public class GPSUtil {
    /**
     * 地球半径（单位：公里）
     */
    public final static double EARTH_RADIUS_KM = 6378.137;

    /**
     * 根据经纬度计算地球上任意两点间的距离
     *
     * @param lat1 起点纬度
     * @param lng1 起点经度
     * @param lat2 终点纬度
     * @param lng2 终点经度
     * @return 两点距离（单位：千米）
     */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = Math.toRadians(lat1);
        double radLat2 = Math.toRadians(lat2);

        double radLng1 = Math.toRadians(lng1);
        double radLng2 = Math.toRadians(lng2);

        double deltaLat = radLat1 - radLat2;
        double deltaLng = radLng1 - radLng2;

        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(deltaLat / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(deltaLng / 2), 2)));
        return NumberUtil.round(distance * EARTH_RADIUS_KM, 4);
    }

    /**
     * 解析 GPS 坐标字符串，返回经纬度信息。
     *
     * @param gpsCoordinate GPS 坐标字符串，格式如 "40.7128, -74.0060"
     * @return 包含经度和纬度的数组，索引 0 为经度，索引 1 为纬度
     * @throws IllegalArgumentException 如果坐标格式不正确
     */
    public static double[] parseGpsCoordinate(String gpsCoordinate) {
        Pattern pattern = Pattern.compile(RegxConstant.COORDINATE_PATTERN);
        Matcher matcher = pattern.matcher(gpsCoordinate.trim());

        if (matcher.matches()) {
            double longitude = Double.parseDouble(matcher.group(1));
            double latitude = Double.parseDouble(matcher.group(3));
            return new double[]{longitude, latitude};
        } else {
            throw new IllegalArgumentException("Invalid GPS coordinate format: " + gpsCoordinate);
        }
    }

    /**
     * 在矩形内随机生成经纬度.
     *
     * @param minLon 最小经度
     * @param maxLon 最大经度
     * @param minLat 最小纬度
     * @param maxLat 最大纬度
     * @return Coordinate 对象，包含生成的经度和纬度
     * @throws IllegalArgumentException 如果参数范围不合法
     */
    public static Model<BigDecimal, BigDecimal> generateRandomCoordinates(double minLon, double maxLon, double minLat, double maxLat) {
        // 参数校验
        if (minLon >= maxLon || minLat >= maxLat) {
            throw new IllegalArgumentException("Invalid coordinate range.");
        }

        // 使用 ThreadLocalRandom 获取随机数生成器
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // 生成随机经纬度
        double randomLongitude = random.nextDouble(minLon, maxLon);
        double randomLatitude = random.nextDouble(minLat, maxLat);

        // 使用 BigDecimal 进行小数位数控制
        BigDecimal longitude = BigDecimal.valueOf(randomLongitude).setScale(6, RoundingMode.HALF_UP);
        BigDecimal latitude = BigDecimal.valueOf(randomLatitude).setScale(6, RoundingMode.HALF_UP);

        return new Model<>(longitude, latitude);
    }
}