package com.mobaijun.common.enhance;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

import java.lang.annotation.Annotation;

/**
 * software：IntelliJ IDEA 2022.2.3
 * class name: EnhanceAssert
 * class description: 增强断言
 *
 * @author MoBaiJun 2022/11/23 21:09
 */
public class EnhanceAssert extends Assert {

    /**
     * annotation字段值非空
     */
    public static <T extends Annotation> T annotationFieldValueNotEmpty(T annotation, String fieldName, String errorMsgTemplate, Object... params) {
        Object annotationFieldValue = EnhanceAnnotationUtils.getAnnotationFieldValue(annotation, fieldName);
        isTrue(ObjectUtil.isNotEmpty(annotationFieldValue), errorMsgTemplate, params);
        return annotation;
    }

    /**
     * 检测value必须在 【min,max】区间中，当有一边的边界是空则直接判定另一边边界即可
     * min\max不能同时为空
     */
    public static int checkBetween(Integer value, Integer min, Integer max) {
        if ((min == null && max == null) || value == null) {
            throw new IllegalArgumentException(StrUtil.format("【value parameter must not null】 and 【min and max parameter cannot be empty at the same time】"));
        }
        if (max == null) {
            if (value < min) {
                throw new IllegalArgumentException(StrUtil.format("Length must greater or equal to {}.", min));
            }
        } else if (min == null) {
            if (value > max) {
                throw new IllegalArgumentException(StrUtil.format("Length must less than or equal to {}.", max));
            }
        } else {
            Assert.checkBetween(value.intValue(), min.intValue(), max.intValue());
        }
        return value;
    }

    /**
     * 判断形参targetObjects里面的元素全部不为空Empty
     *
     * @param thrownFlag    true抛出异常
     * @param targetObjects 需要校验的参数
     */
    public static boolean allNotEmpty(boolean thrownFlag, Object[] targetObjects) {
        //校验标志
        boolean checkFlag = true;
        if (targetObjects != null) {
            for (Object targetObject : targetObjects) {
                if (ObjectUtil.isEmpty(targetObject)) {
                    checkFlag = false;
                    break;
                }
            }
        } else {
            checkFlag = false;
        }

        if (!checkFlag && thrownFlag) {
            throw new IllegalArgumentException("[Assertion failed] - this all arguments must not empty");
        }
        return checkFlag;
    }

    /**
     * 判断形参是否全部不为空，false是不抛出异常
     *
     * @param targetObjects 需要校验的参数
     */
    public static boolean allNotEmpty(Object... targetObjects) {
        return allNotEmpty(false, targetObjects);
    }

    /**
     * 判断形参targetObjects里面的元素含有不为空的值
     *
     * @param thrownFlag    true抛出异常
     * @param targetObjects 需要校验的参数
     */
    public static boolean hasNotEmpty(boolean thrownFlag, Object[] targetObjects) {
        //校验标志
        boolean checkFlag = false;
        if (targetObjects != null) {
            for (Object targetObject : targetObjects) {
                if (ObjectUtil.isNotEmpty(targetObject)) {
                    checkFlag = true;
                    break;
                }
            }
        }
        if (!checkFlag && thrownFlag) {
            throw new IllegalArgumentException("[Assertion failed] - this all arguments must has one element not empty");
        }
        return checkFlag;
    }

    /**
     * 判断形参targetObjects里面的元素含有不为空的值
     * 校验不通过false则抛出异常，true则正常返回
     *
     * @param targetObjects 需要校验的参数
     */
    public static boolean hasNotEmpty(Object... targetObjects) {
        return hasNotEmpty(false, targetObjects);
    }

    /**
     * 判断两个形参是否相等
     *
     * @param thrownFlag 不相等是否抛出异常
     */
    public static boolean equal(boolean thrownFlag, Object target1, Object target2) {
        if (!ObjectUtil.equal(target1, target2)) {

            if (thrownFlag) {
                throw new IllegalArgumentException("[Assertion failed] - 【target1==" + target1 + "】、【target2==" + target2 + "】Parameters must equal ");
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    /**
     * 判断两个形参是否相等，不相等直接抛出异常
     */
    public static boolean equal(Object target1, Object target2) {
        return equal(true, target1, target2);
    }

    /**
     * 断言target1 小于等于 target2，不通过直接抛出异常
     *
     * @param target1 必须实现
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean le(boolean thrownFlag, T target1, T target2) {
        if (!equal(false, target1, target2)) {
            if (ObjectUtil.isEmpty(target1) && ObjectUtil.isNotEmpty(target2)) {
                return true;
            } else if (ObjectUtil.isEmpty(target1) && ObjectUtil.isEmpty(target2)) {
                return true;
            } else {
                boolean comparableFlag = target1 instanceof Comparable && target2 instanceof Comparable;
                if (comparableFlag) {
                    Comparable<T> target1Comparable = (Comparable<T>) target1;
                    if (target1Comparable.compareTo(target2) > 0) {
                        if (thrownFlag) {
                            throw new IllegalArgumentException("[Assertion failed] - 【target1==" + target1 + "】 must less than 【target2==" + target2 + "】");
                        } else {
                            return false;
                        }
                    }
                } else {
                    throw new IllegalArgumentException("[Assertion Parameter Type failed] - 【target1==" + target1 + "】、【target2==" + target2 + "】Parameters must be implemented  Comparable interface");
                }
            }
        }
        return true;
    }


    public static boolean le(Object target1, Object target2) {
        return le(true, target1, target2);
    }
}
