package com.mobaijun.common.util.page;

import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: PageInfo
 * class description：分页结果的封装(for Bootstrap Table)
 *
 * @author MoBaiJun 2022/5/11 14:37
 */
public class PageInfo<T> {

    /**
     * 结果集
     */
    private List<T> data;

    /**
     * 总数
     */
    private long total;

    /**
     * 每页大小
     */
    private int size = 10;

    /**
     * 页码
     */
    private int page = 1;

    public PageInfo(PageInfo<T> pageInfo) {
        this.data = pageInfo.getData();
        this.total = pageInfo.getTotal();
        this.page = pageInfo.getPage();
        this.size = pageInfo.getSize();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
