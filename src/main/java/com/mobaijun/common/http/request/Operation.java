package com.mobaijun.common.http.request;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: Operation<br>
 * class description: <br>
 *
 * @author MoBaiJun 2023/1/5 14:11
 */
public abstract class Operation<V> implements Callable<V> {

    /**
     * Run operation
     *
     * @return result
     */
    protected abstract V run() throws RequestException, IOException;

    /**
     * Operation complete callback
     */
    protected abstract void done() throws IOException;

    public V call() throws RequestException {
        boolean thrown = false;
        try {
            return run();
        } catch (RequestException e) {
            thrown = true;
            throw e;
        } catch (IOException e) {
            thrown = true;
            throw new RequestException(e);
        } finally {
            try {
                done();
            } catch (IOException e) {
                if (!thrown) {
                    throw new RequestException(e);
                }
            }
        }
    }

}

