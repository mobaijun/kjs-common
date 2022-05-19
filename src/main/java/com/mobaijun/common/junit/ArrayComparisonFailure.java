package com.mobaijun.common.junit;

import java.util.ArrayList;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: ArrayComparisonFailure
 * class description：
 *
 * @author MoBaiJun 2022/5/19 11:28
 */
public class ArrayComparisonFailure extends AssertionError {

    private static final long serialVersionUID = 1L;

    /*
     * We have to use the f prefix until the next major release to ensure
     * serialization compatibility.
     * See https://github.com/junit-team/junit4/issues/976
     */
    private final List<Integer> fIndices = new ArrayList<Integer>();
    private final String fMessage;
    private final AssertionError fCause;

    /**
     * Construct a new <code>ArrayComparisonFailure</code> with an error text and the array's
     * dimension that was not equal
     *
     * @param cause the exception that caused the array's content to fail the assertion test
     * @param index the array position of the objects that are not equal.
     * @see Assert#assertArrayEquals(String, Object[], Object[])
     */
    public ArrayComparisonFailure(String message, AssertionError cause, int index) {
        this.fMessage = message;
        this.fCause = cause;
        initCause(fCause);
        addDimension(index);
    }

    public void addDimension(int index) {
        fIndices.add(0, index);
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause() == null ? fCause : super.getCause();
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        if (fMessage != null) {
            sb.append(fMessage);
        }
        sb.append("arrays first differed at element ");
        for (int each : fIndices) {
            sb.append("[");
            sb.append(each);
            sb.append("]");
        }
        sb.append("; ");
        sb.append(getCause().getMessage());
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getMessage();
    }
}
