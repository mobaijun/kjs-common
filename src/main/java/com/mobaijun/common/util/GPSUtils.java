/*
 * Copyright (C) 2022 www.mobaijun.com
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
package com.mobaijun.common.util;

import com.mobaijun.common.util.number.NumberUtils;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: GPSUtils<br>
 * class description：<br>
 *
 * @author MoBaiJun 2022/5/18 10:29
 */
public class GPSUtils {
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
        return NumberUtils.round(distance * EARTH_RADIUS_KM, 4);
    }
}