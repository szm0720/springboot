package com.redis.normal.common;


public class Page {
    private Integer page;//页号 默认1
    private Integer limit = 10;//每页条数 默认10
    private Long total;//总条数

    public Page() {

    }

    public Page(Integer page, Integer limit, Long total) {
        this.page = (page ==null || page.intValue() <1) ? 1 : page;
        this.limit = limit;
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = (page ==null || page.intValue() <1) ? 1 : page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
