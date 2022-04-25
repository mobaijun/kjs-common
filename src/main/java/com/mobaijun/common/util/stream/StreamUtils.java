package com.mobaijun.common.util.stream;

import com.mobaijun.common.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: StreamUtils
 * 类描述： Stream工具类
 *
 * @author MoBaiJun 2022/4/24 11:27
 */
public class StreamUtils {

    /**
     * 映射
     *
     * @param data 不能为空
     * @param fun  fun
     * @param <T>  <T, R>
     * @param <R>  <T, R>
     * @return data为空抛出异常IllegalArgumentException
     */
    public static <T, R> List<R> map(List<T> data, Function<T, R> fun) {
        if (CollectionUtils.isNull(data)) {
            throw new IllegalArgumentException();
        }
        return data.stream().map(fun).collect(Collectors.toList());
    }

    /**
     * @param data data
     * @param pre  pre
     * @param <T>  List<T>
     * @return data为空返回data
     */
    public static <T> List<T> filter(List<T> data, Predicate<T> pre) {
        if (CollectionUtils.isNull(data)) {
            return null;
        }
        return data.stream().filter(pre).collect(Collectors.toList());
    }

    /**
     * 排序
     *
     * @param data       data
     * @param comparator comparator
     * @param <T>        <T> List<T>
     * @return data为空返回data
     */
    public static <T> List<T> sorted(List<T> data, Comparator<T> comparator) {
        if (CollectionUtils.isNull(data)) {
            return null;
        }
        return data.stream().sorted(comparator).collect(Collectors.toList());
    }

    /**
     * @param data data
     * @param <T>  <T> List<T>
     * @return data为空返回data
     */
    public static <T> List<T> distinct(List<T> data) {
        if (CollectionUtils.isNull(data)) {
            return null;
        }
        return data.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 判断是否包含匹配元素
     *
     * @param data data
     * @param pre  pre
     * @param <T>  <T>
     * @return <T>
     */
    public static <T> boolean anyMatch(List<T> data, Predicate<T> pre) {
        if (CollectionUtils.isNull(data)) {
            return false;
        }
        return data.parallelStream().anyMatch(pre);
    }

    /**
     * 将list进行join操作
     *
     * @param data data
     * @param join join
     * @return 返回join之后的字符串, data为空返回null
     */
    public static String join(List<String> data, String join) {
        if (CollectionUtils.isNull(data)) {
            return null;
        }
        return data.stream().collect(Collectors.joining(join == null ? "" : join));
    }
}
