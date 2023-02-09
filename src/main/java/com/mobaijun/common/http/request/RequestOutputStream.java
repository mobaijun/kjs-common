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
