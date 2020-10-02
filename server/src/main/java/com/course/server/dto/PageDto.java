package com.course.server.dto;

import java.util.List;

/**
* 分页工具类
* @author Winston.Wang
* @date 2020/9/20
* @version 1.0
**/
public class PageDto<T>{

    /**
     * 当前页
     */
    private int pageNum;

    /**
     * 每页条数
     */
    private int pageSize;

    /**
     * 总条数
     */
    private long total;


    /**
     * 返回数据
     */
    private List<T> list;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageDto{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
