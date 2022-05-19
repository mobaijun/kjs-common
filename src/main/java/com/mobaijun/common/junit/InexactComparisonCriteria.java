package com.mobaijun.common.junit;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: InexactComparisonCriteria
 * class description：
 *
 * @author MoBaiJun 2022/5/19 11:29
 */
public class InexactComparisonCriteria extends ComparisonCriteria {
    public Object fDelta;

    public InexactComparisonCriteria(double delta) {
        fDelta = delta;
    }

    public InexactComparisonCriteria(float delta) {
        fDelta = delta;
    }

    @Override
    protected void assertElementsEqual(Object expected, Object actual) {
        if (expected instanceof Double) {
            Assert.assertEquals((Double) expected, (Double) actual, (Double) fDelta);
        } else {
            Assert.assertEquals((Float) expected, (Float) actual, (Float) fDelta);
        }
    }
}
