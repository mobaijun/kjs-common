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
package com.mobaijun.common.util.number;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: BigDecimalChain<br>
 * description: 大数字类型工具类
 *
 * @author MoBaiJun 2022/11/6 1:21
 */
public class BigDecimalChain {

    /**
     * 大数字
     */
    private BigDecimal value;

    public BigDecimalChain(Object value) {
        this.value = convertBigDecimal(value, null);
    }

    /**
     * 开始计算的初始值
     */
    public static BigDecimalChain startOf(Object value) {
        return new BigDecimalChain(value);
    }

    /**
     * 加
     */
    public BigDecimalChain add(Object other) {
        return operator(BigDecimal::add, other);
    }

    /**
     * 加
     *
     * @param preoperational 加之前先把 other 四舍五入法保留 preoperational 位小数
     */
    public BigDecimalChain add(Object other, Integer preoperational) {
        return operator(BigDecimal::add, other, preoperational);
    }

    /**
     * 减
     */
    public BigDecimalChain subtract(Object other) {
        return operator(BigDecimal::subtract, other);
    }

    /**
     * 减
     *
     * @param preoperational 减之前先把 other 四舍五入法保留 preoperational 位小数
     */
    public BigDecimalChain subtract(Object other, Integer preoperational) {
        return operator(BigDecimal::subtract, other, preoperational);
    }

    /**
     * 乘
     */
    public BigDecimalChain multiply(Object other) {
        return operator(BigDecimal::multiply, other);
    }

    /**
     * 乘
     *
     * @param preoperational 乘之前先把 other 四舍五入法保留 preoperational 位小数
     */
    public BigDecimalChain multiply(Object other, Integer preoperational) {
        return operator(BigDecimal::multiply, other, preoperational);
    }

    /**
     * 除以
     */
    public BigDecimalChain divide(Object other) {
        return operator(BigDecimal::divide, other);
    }

    /**
     * 除以
     *
     * @param preoperational 除之前先把 other 四舍五入法保留 preoperational 位小数
     */
    public BigDecimalChain divide(Object other, Integer preoperational) {
        return operator(BigDecimal::divide, other, preoperational);
    }

    /**
     * 除以
     *
     * @param scale 结果保留 scale 位小数
     */
    public BigDecimalChain divideWithScale(Object other, Integer scale) {
        return baseOperator(otherValue -> this.value
                .divide(otherValue, scale, RoundingMode.HALF_UP), other, null);
    }

    /**
     * 除以
     *
     * @param scale          结果保留 scale 位小数
     * @param preoperational 除以之前先把 other 四舍五入法保留 preoperational 位小数
     */
    public BigDecimalChain divideWithScale(Object other, Integer scale, Integer preoperational) {
        return baseOperator(otherValue -> this.value
                .divide(otherValue, scale, RoundingMode.HALF_UP), other, preoperational);
    }


    public BigDecimal getValue() {
        return value;
    }

    public BigDecimal getValue(int scale) {
        return value.setScale(scale, RoundingMode.HALF_UP);
    }

    public Double getDouble() {
        return getValue().doubleValue();
    }

    public Double getDouble(int scale) {
        return getValue(scale).doubleValue();
    }

    public Long getLong() {
        return getValue().longValue();
    }

    public Integer getInteger() {
        return getValue().intValue();
    }

    private BigDecimalChain operator(BiFunction<BigDecimal, BigDecimal, BigDecimal> operator, Object other) {
        return operator(operator, other, null);
    }

    private BigDecimalChain operator(BiFunction<BigDecimal, BigDecimal, BigDecimal> operator, Object other, Integer beforeOperteScale) {
        return baseOperator(otherValue -> operator.apply(this.value, otherValue), other, beforeOperteScale);
    }

    /**
     * 基本运算符
     *
     * @param operatorFunction 运算符函数
     * @param other            other
     * @param preoperational   preoperational
     * @return BigDecimalChain
     */
    private synchronized BigDecimalChain baseOperator(Function<BigDecimal, BigDecimal> operatorFunction, Object other, Integer preoperational) {
        if (other == null) {
            return this;
        }
        if (other instanceof BigDecimalChain) {
            this.value = operatorFunction.apply(((BigDecimalChain) other).getValue());
            return this;
        }
        this.value = operatorFunction.apply(convertBigDecimal(other, preoperational));
        return this;
    }

    /**
     * 转换大小树
     *
     * @param value 值
     * @param scale 取值
     * @return BigDecimal
     */
    private BigDecimal convertBigDecimal(Object value, Integer scale) {
        if (value == null) {
            return BigDecimal.ZERO;
        }
        BigDecimal res;
        if (value instanceof Number) {
            res = BigDecimal.valueOf(((Number) value).doubleValue());
        } else {
            try {
                res = new BigDecimal(value.toString());
            } catch (NumberFormatException e) {
                return BigDecimal.ZERO;
            }
        }

        if (scale != null) {
            res = BigDecimal.valueOf(res.setScale(scale, RoundingMode.HALF_UP).doubleValue());
        }
        return res;
    }
}