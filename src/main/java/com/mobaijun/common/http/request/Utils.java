package com.mobaijun.common.http.request;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author biezhi
 * @date 2017/9/30
 */
public class Utils {

    public static byte[] toBytes(InputStream is) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[4096];
        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        return buffer.toByteArray();
    }

    /**
     * Represents array of any type as list of objects so we can easily iterate over it
     *
     * @param array of elements
     * @return list with the same elements
     */
    private static List<Object> arrayToList(final Object array) {
        if (array instanceof Object[]) {
            return Arrays.asList((Object[]) array);
        }

        List<Object> result = new ArrayList<Object>();
        // Arrays of the primitive types can't be cast to array of Object, so this:
        if (array instanceof int[]) {
            for (int value : (int[]) array) {
                result.add(value);
            }
        } else if (array instanceof boolean[]) {
            for (boolean value : (boolean[]) array) {
                result.add(value);
            }
        } else if (array instanceof long[]) {
            for (long value : (long[]) array) {
                result.add(value);
            }
        } else if (array instanceof float[]) {
            for (float value : (float[]) array) {
                result.add(value);
            }
        } else if (array instanceof double[]) {
            for (double value : (double[]) array) {
                result.add(value);
            }
        } else if (array instanceof short[]) {
            for (short value : (short[]) array) {
                result.add(value);
            }
        } else if (array instanceof byte[]) {
            for (byte value : (byte[]) array) {
                result.add(value);
            }
        } else if (array instanceof char[]) {
            for (char value : (char[]) array) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Encode the given URL as an ASCII {@link String}
     * <p>
     * This method ensures the path and query segments of the URL are properly
     * encoded such as ' ' characters being encoded to '%20' or any UTF-8
     * characters that are non-ASCII. No encoding of URLs is done by default by
     * the {@link Request} constructors and so if URL encoding is needed this
     * method should be called before calling the {@link Request} constructor.
     *
     * @return encoded URL
     */
    public static String encode(final CharSequence url)
            throws RequestException {
        URL parsed;
        try {
            parsed = new URL(url.toString());
        } catch (IOException e) {
            throw new RequestException(e);
        }

        String host = parsed.getHost();
        int port = parsed.getPort();
        if (port != -1) {
            host = host + ':' + port;
        }

        try {
            String encoded = new URI(parsed.getProtocol(), host, parsed.getPath(),
                    parsed.getQuery(), null).toASCIIString();
            int paramsStart = encoded.indexOf('?');
            if (paramsStart > 0 && paramsStart + 1 < encoded.length()) {
                encoded = encoded.substring(0, paramsStart + 1)
                        + encoded.substring(paramsStart + 1).replace("+", "%2B");
            }
            return encoded;
        } catch (URISyntaxException e) {
            IOException io = new IOException("Parsing URI failed", e);
            throw new RequestException(io);
        }
    }

    /**
     * Append given map as query parameters to the base URL
     * <p>
     * Each map entry's key will be a parameter name and the value's
     * {@link Object#toString()} will be the parameter value.
     *
     * @return URL with appended query params
     */
    public static String append(final CharSequence url, final Map<?, ?> params) {
        final String baseUrl = url.toString();
        if (params == null || params.isEmpty()) {
            return baseUrl;
        }

        final StringBuilder result = new StringBuilder(baseUrl);

        addPathSeparator(baseUrl, result);
        addParamPrefix(baseUrl, result);

        Map.Entry<?, ?> entry;
        Iterator<?> iterator = params.entrySet().iterator();
        entry = (Map.Entry<?, ?>) iterator.next();
        addParam(entry.getKey().toString(), entry.getValue(), result);

        while (iterator.hasNext()) {
            result.append('&');
            entry = (Map.Entry<?, ?>) iterator.next();
            addParam(entry.getKey().toString(), entry.getValue(), result);
        }

        return result.toString();
    }

    /**
     * Append given name/value pairs as query parameters to the base URL
     * <p>
     * The params argument is interpreted as a sequence of name/value pairs so the
     * given number of params must be divisible by 2.
     *
     * @param params name/value pairs
     * @return URL with appended query params
     */
    public static String append(final CharSequence url, final Object... params) {
        final String baseUrl = url.toString();
        if (params == null || params.length == 0) {
            return baseUrl;
        }

        if (params.length % 2 != 0) {
            throw new IllegalArgumentException(
                    "Must specify an even number of parameter names/values");
        }

        final StringBuilder result = new StringBuilder(baseUrl);

        addPathSeparator(baseUrl, result);
        addParamPrefix(baseUrl, result);

        addParam(params[0], params[1], result);

        for (int i = 2; i < params.length; i += 2) {
            result.append('&');
            addParam(params[i], params[i + 1], result);
        }

        return result.toString();
    }

    private static StringBuilder addPathSeparator(final String baseUrl,
                                                  final StringBuilder result) {
        // Add trailing slash if the base URL doesn't have any path segments.
        //
        // The following test is checking for the last slash not being part of
        // the protocol to host separator: '://'.
        if (baseUrl.indexOf(':') + 2 == baseUrl.lastIndexOf('/')) {
            result.append('/');
        }
        return result;
    }

    private static StringBuilder addParamPrefix(final String baseUrl,
                                                final StringBuilder result) {
        // Add '?' if missing and add '&' if params already exist in base url
        final int queryStart = baseUrl.indexOf('?');
        final int lastChar = result.length() - 1;
        if (queryStart == -1) {
            result.append('?');
        } else if (queryStart < lastChar && baseUrl.charAt(lastChar) != '&') {
            result.append('&');
        }
        return result;
    }

    private static StringBuilder addParam(final Object key, Object value,
                                          final StringBuilder result) {
        if (value != null && value.getClass().isArray()) {
            value = arrayToList(value);
        }

        if (value instanceof Iterable<?>) {
            Iterator<?> iterator = ((Iterable<?>) value).iterator();
            while (iterator.hasNext()) {
                result.append(key);
                result.append("[]=");
                Object element = iterator.next();
                if (element != null) {
                    result.append(element);
                }
                if (iterator.hasNext()) {
                    result.append("&");
                }
            }
        } else {
            result.append(key);
            result.append("=");
            if (value != null) {
                result.append(value);
            }
        }
        return result;
    }
}
