/*
 * Copyright (C) 2022 [www.mobaijun.com]
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
package com.mobaijun.common.minitable;

import com.mobaijun.common.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: MiniTable<br>
 * class description: 生成 ASCII TABLE 的主核心类.<br>
 *
 * @author MoBaiJun 2022/12/29 9:29
 */
public class MiniTable {

    /**
     * 表格标题.
     */
    private String title;

    /**
     * 最后处理行类型.
     */
    private RowType lastRowType;

    /**
     * 用于拼接字符串的 StringBuilder 对象.
     */
    private StringBuilder join;

    /**
     * 用来存放每行数据的有序Map.
     */
    private List<Row> rows;

    /**
     * 用来存放每列长度最大值的Map.
     */
    private Map<Integer, Integer> maxColMap;

    /**
     * 默认的空构造方法.
     */
    public MiniTable() {
        this.init();
    }

    /**
     * 包含标题的构造方法.
     *
     * @param title 标题
     */
    public MiniTable(String title) {
        this.init();
        this.title = title;
    }

    /**
     * 初始化数据.
     */
    private void init() {
        this.join = new StringBuilder();
        this.rows = new ArrayList<>();
        this.maxColMap = new HashMap<>(10);
    }

    /**
     * 将集合中的元素添加到表格中的表头数据中.
     *
     * @param headers 表头数据
     * @return MiniTable对象
     */
    public <T> MiniTable addHeaders(List<T> headers) {
        return this.appendRows(RowType.HEADER, headers.toArray());
    }

    /**
     * 向表格中添加表头数据.
     *
     * @param objects 表头数据
     * @return MiniTable对象
     */
    @SafeVarargs
    public final <T> MiniTable addHeaders(T... objects) {
        return this.appendRows(RowType.HEADER, (Object) objects);
    }

    /**
     * 向表格中添加一行普通数据.
     *
     * @param data 普通行数据
     * @return MiniTable对象
     */
    public <T> MiniTable addData(List<T> data) {
        return this.appendRows(RowType.DATA, data.toArray());
    }

    /**
     * 向表格中添加一行普通数据.
     *
     * @param objects 普通行数据
     * @return MiniTable对象
     */
    @SafeVarargs
    public final <T> MiniTable addData(T... objects) {
        return this.appendRows(RowType.DATA, objects);
    }

    /**
     * 向表格添加中一行数据.
     *
     * @param objects 表行数据
     * @return MiniTable对象
     */
    @SafeVarargs
    private final <T> MiniTable appendRows(RowType rowType, T... objects) {
        int len;
        if (objects != null && (len = objects.length) > 0) {
            if (this.maxColMap.size() > len) {
                throw new IllegalArgumentException("The number of columns that inserted a row of data into the table is different from the number of previous columns, check!");
            }

            // 遍历传入的数据集合，并将其存入到行数据对象中.
            List<String> data = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Object o = objects[i];
                String value = o == null ? "null" : o.toString();
                data.add(value);

                // 获取第 i 列的最大长度值，如果该列数据不存在，就存储起来.
                Integer maxColSize = this.maxColMap.get(i);
                if (maxColSize == null) {
                    this.maxColMap.put(i, value.length());
                    continue;
                }

                // 如果当前列的长度大于了以前的最大列，就覆盖最大列长度为当前的列长度.
                if (value.length() > maxColSize) {
                    this.maxColMap.put(i, value.length());
                }
            }
            this.rows.add(new Row(rowType, data));
        }
        return this;
    }

    /**
     * 构建表格标题所在行的字符串.
     *
     * <p>这里重点需要计算出标题所占用的最大字符串长度，然后截取出标题的字符串.
     * 计算标题字符串最大长度的公式: `maxTitleSize = n * (maxColSize) + (n - 1) * 3`;
     * </p>
     */
    private void buildTitle() {
        if (this.title != null) {
            // 计算出标题字符串最大长度.
            int maxTitleSize = 0;
            for (Integer maxColSize : this.maxColMap.values()) {
                maxTitleSize += maxColSize;
            }
            maxTitleSize += 3 * (this.maxColMap.size() - 1);

            // 如果最大的标题字符串长度大于了现有的标题，就对现有的标题进行截取.
            if (this.title.length() > maxTitleSize) {
                this.title = this.title.substring(0, maxTitleSize);
            }

            // 拼接出标题行的上边框和标题行的数据.
            this.join.append("+");
            for (int i = 0; i < maxTitleSize + 2; i++) {
                this.join.append("-");
            }
            this.join.append("+\n")
                    .append("|")
                    .append(StringUtil.center(this.title, maxTitleSize + 2, ' '))
                    .append("|\n");

            this.lastRowType = RowType.TITLE;
        }
    }

    /**
     * 构建生成表格 table，先构建出标题，然后遍历每行数据进行构建.
     */
    private void buildTable() {
        this.buildTitle();

        // 遍历每行的数据，生成表格的行数据.
        for (int i = 0, len = this.rows.size(); i < len; i++) {
            List<String> data = this.rows.get(i).getData();
            switch (this.rows.get(i).getRowType()) {
                // 如果当前行是表头，则需要考虑生成上下边框.
                case HEADER:
                    if (this.lastRowType != RowType.HEADER) {
                        this.buildRowBorder(data);
                    }
                    this.buildRowData(data);
                    this.buildRowBorder(data);
                    break;
                // 如果当前行是普通数据行，则需要考虑在最后一行处追加下边框.
                case DATA:
                    this.buildRowData(data);
                    if (i == len - 1) {
                        this.buildRowBorder(data);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 构建边框行的方法.
     *
     * @param data 行
     */
    private void buildRowBorder(List<String> data) {
        this.join.append("+");
        for (int i = 0, len = data.size(); i < len; i++) {
            this.join.append("-".repeat(Math.max(0, this.maxColMap.get(i) + 2)));
            this.join.append("+");
        }
        this.join.append("\n");
    }

    /**
     * 构建数据行的方法.
     *
     * @param data 行数据
     */
    private void buildRowData(List<String> data) {
        this.join.append("|");
        for (int i = 0, len = data.size(); i < len; i++) {
            this.join.append(StringUtil.center(data.get(i), this.maxColMap.get(i) + 2, ' '))
                    .append("|");
        }
        this.join.append("\n");
    }

    /**
     * 渲染出生成的结果.
     *
     * @return Table的ASCII字符串
     */
    public String render() {
        this.buildTable();
        return this.join.toString();
    }
}
