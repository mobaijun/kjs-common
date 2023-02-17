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

import com.mobaijun.common.util.text.Charsets;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: RequestOutputStream<br>
 * class description: <br>
 *
 * @author MoBaiJun 2023/1/5 14:11
 */
class RequestOutputStream extends BufferedOutputStream {

    private final CharsetEncoder encoder;

    /**
     * Create request output stream
     *
     */
    RequestOutputStream(final OutputStream stream, final String charset, final int bufferSize) {
        super(stream, bufferSize);
        encoder = Charset.forName(getValidCharset(charset)).newEncoder();
    }

    /**
     * Write string to stream
     *
     * @return this stream
     * @throws IOException
     */
    RequestOutputStream write(final String value) throws IOException {
        final ByteBuffer bytes = encoder.encode(CharBuffer.wrap(value));
        super.write(bytes.array(), 0, bytes.limit());

        return this;
    }

    private static String getValidCharset(final String charset) {
        if (charset != null && charset.length() > 0) {
            return charset;
        } else {
            return Charsets.UTF_8_NAME;
        }
    }

    CharsetEncoder getEncoder() {
        return encoder;
    }
}
