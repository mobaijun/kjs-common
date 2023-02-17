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

