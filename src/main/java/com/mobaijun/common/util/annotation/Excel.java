package com.mobaijun.common.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.BigDecimal;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: Excel
 * 类描述： 自定义数据导出注解
 *
 * @author MoBaiJun 2022/4/25 15:20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Excel {

    /**
     * 导出时在excel中排序
     *
     * @return 数量
     */
    int sort() default Integer.MAX_VALUE;

    /**
     * 导出到Excel中的名字.
     *
     * @return name
     */
    String name() default "";

    /**
     * 日期格式, 如: yyyy-MM-dd
     *
     * @return String
     */
    String dateFormat() default "";

    /**
     * 如果是字典类型，请设置字典的type值 (如: sys_user_sex)
     *
     * @return String
     */
    String dictType() default "";

    /**
     * 读取内容转表达式 (如: 0=男,1=女,2=未知)
     *
     * @return String
     */
    String readConverterExp() default "";

    /**
     * 分隔符，读取字符串组内容
     *
     * @return String
     */
    String separator() default ",";

    /**
     * BigDecimal 精度 默认:-1(默认不开启BigDecimal格式化)
     *
     * @return int
     */
    int scale() default -1;

    /**
     * BigDecimal 舍入规则 默认:BigDecimal.ROUND_HALF_EVEN
     *
     * @return int
     */
    int roundingMode() default BigDecimal.ROUND_HALF_EVEN;

    /**
     * 导出类型（0数字 1字符串）
     *
     * @return ColumnType
     */
    ColumnType cellType() default ColumnType.STRING;

    /**
     * 导出时在excel中每个列的高度 单位为字符
     *
     * @return double
     */
    double height() default 14;

    /**
     * 导出时在excel中每个列的宽 单位为字符
     *
     * @return double
     */
    double width() default 16;

    /**
     * 文字后缀,如% 90 变成90%
     *
     * @return String
     */
    String suffix() default "";

    /**
     * 当值为空时,字段的默认值
     *
     * @return String
     */
    String defaultValue() default "";

    /**
     * 提示信息
     *
     * @return String
     */
    String prompt() default "";

    /**
     * 设置只能选择不能输入的列内容.
     *
     * @return String[]
     */
    String[] combo() default {};

    /**
     * 是否导出数据,应对需求:有时我们需要导出一份模板,这是标题需要但内容需要用户手工填写.
     *
     * @return boolean
     */
    boolean isExport() default true;

    /**
     * 另一个类中的属性名称,支持多级获取,以小数点隔开
     *
     * @return String
     */
    String targetAttr() default "";

    /**
     * 是否自动统计数据,在最后追加一行统计数据总和
     *
     * @return boolean
     */
    boolean isStatistics() default false;

    /**
     * 字段类型（0：导出导入；1：仅导出；2：仅导入）
     *
     * @return Type
     */
    Type type() default Type.ALL;

    enum Type {
        ALL(0),
        EXPORT(1),
        IMPORT(2);
        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    enum ColumnType {
        NUMERIC(0),
        STRING(1);
        private final int value;

        ColumnType(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }
}
