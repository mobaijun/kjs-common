package com.mobaijun.common.util.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: PageResult
 * class description： 分页返回结果
 *
 * @author MoBaiJun 2022/7/1 9:24
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class PageResult<T> {
    /**
     * 分页数据
     */
    protected List<T> records = Collections.emptyList();

    /**
     * 数据总量
     */
    protected Long total = 0L;

    public PageResult() {
    }

    public PageResult(long total) {
        this.total = total;
    }

    public PageResult(List<T> records, long total) {
        this.records = records;
        this.total = total;
    }
}
