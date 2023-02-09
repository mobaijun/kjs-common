package com.mobaijun.common.http.request;

import java.io.Flushable;
import java.io.IOException;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: FlushOperation<br>
 * class description: <br>
 *
 * @author MoBaiJun 2023/1/5 14:11
 */
public abstract class FlushOperation<V> extends Operation<V> {

    private final Flushable flushable;

    /**
     * Create flush operation
     *
     */
    protected FlushOperation(final Flushable flushable) {
        this.flushable = flushable;
    }

    @Override
    protected void done() throws IOException {
        flushable.flush();
    }

}
