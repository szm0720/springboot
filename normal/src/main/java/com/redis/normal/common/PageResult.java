package com.redis.normal.common;

import com.redis.normal.enums.CodeEnum;

/**
 *
 */
public class PageResult<T> {
    /**
     * 码值
     */
    private  String code;
    /**
     * 文案
     */
    private  String msg;
    /**
     * 数据
     */
    private T data;
    /**
     * 分页
     */
    private Page page;
    /**
     * 是否分页
     */
    private Boolean paging = false;
    public static <T> PageResult getPageSuccess(T data) {
        if(data instanceof com.github.pagehelper.Page){
            com.github.pagehelper.Page<T> p = (com.github.pagehelper.Page<T>)data;
            Page page = new Page();
            page.setLimit(p.getPageSize());
            page.setPage(p.getPageNum());
            page.setTotal(p.getTotal());
            return new PageResult<T>(data, CodeEnum.OK.getCode(), CodeEnum.OK.getMsg(),page,true);
        }
        return new PageResult<T>(data, CodeEnum.OK.getCode(), CodeEnum.OK.getMsg(), null,false);
    }
    public static <T> PageResult getPageFail(String data, String code, String msg) {
        return new PageResult<String>(data,code,msg, null,false);
    }
    public PageResult(T data, String code, String msg, Page page, boolean notPaging) {
        this.data=data;
        this.code=code;
        this.msg = msg;
        this.page = page;
        this.paging = notPaging;
    }
    public PageResult() {
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getPaging() {
        return paging;
    }

    public void setPaging(Boolean paging) {
        this.paging = paging;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
