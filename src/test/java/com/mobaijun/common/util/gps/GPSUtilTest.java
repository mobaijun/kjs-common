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
        double result = GPSUtil.getDistance(0d, 0d, 0d, 0d);
        Assert.assertEquals(0d, result);
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

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme