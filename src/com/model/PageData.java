package com.model;

import java.util.List;
import java.util.Objects;

public class PageData {
    // 页码
    private int pageNum;
    // 每页数据总数
    private int pageSize = 6;
    // 获取每页数据的开始位置
    private int start;
    // 分页数据的集合
    private List list;
    // 总记录数
    private int count;
    // 总页数
    private int pageCount;

    public PageData() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        pageCount = count % pageSize == 0 ?
                count / pageSize : count / pageSize + 1;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getStart() {
        return start = (pageNum - 1) * pageSize;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
