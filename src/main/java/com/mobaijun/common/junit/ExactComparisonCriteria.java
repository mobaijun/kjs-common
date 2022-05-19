package com.mobaijun.common.junit;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: ExactComparisonCriteria
 * class description：
 *
 * @author MoBaiJun 2022/5/19 11:33
 */
public class ExactComparisonCriteria extends ComparisonCriteria {
    @Override
    protected void assertElementsEqual(Object expected, Object actual) {
        Assert.assertEquals(expected, actual);
    }
}
