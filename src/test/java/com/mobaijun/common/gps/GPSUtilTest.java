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
package com.mobaijun.common.gps;

import com.mobaijun.common.gps.model.Coordinate;
import com.mobaijun.common.model.Model;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

/**
 * Description: [GPSUtilTest测试类]
 * Author: [xzh]
 * Date: [2023/12/28 11:37]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2021.1.4]
 */
public class GPSUtilTest {

    @Test
    public void testGetDistance() throws Exception {
        // 北京的经纬度
        Coordinate beijing = new Coordinate(39.9d, 116.3d);
        // 武汉的经纬度
        Coordinate wuhan = new Coordinate(114.29d, 30.58d);
        double result = GPSUtil.getDistance(beijing.getLatitude(), beijing.getLongitude(), wuhan.getLatitude(), wuhan.getLongitude());
        System.out.println(result);
    }

    @Test
    public void testParseGpsCoordinate() {
        double[] result = GPSUtil.parseGpsCoordinate("gpsCoordinate");
    }

    @Test
    public void testGenerateRandomCoordinates() {
        Model<BigDecimal, BigDecimal> result = GPSUtil.generateRandomCoordinates(0d, 0d, 0d, 0d);
        Assert.assertEquals(new Model<>(new BigDecimal(0), new BigDecimal(0)), result);
    }
}
