package com.mobaijun.common.util.gps;

import com.mobaijun.common.model.Model;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

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
        Assert.assertNotNull(result);
    }

    @Test
    public void testParseGpsCoordinate() throws Exception {
        double[] result = GPSUtil.parseGpsCoordinate("gpsCoordinate");
        //Assert.assertArrayEquals(new double[]{0d}, result);
    }

    @Test
    public void testGenerateRandomCoordinates() throws Exception {
        Model<BigDecimal, BigDecimal> result = GPSUtil.generateRandomCoordinates(0d, 0d, 0d, 0d);
        Assert.assertEquals(new Model<BigDecimal, BigDecimal>(new BigDecimal(0), new BigDecimal(0)), result);
    }
}

