package com.me.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: tianchong
 * @Date: 2018/5/16 16:41
 * @Description:
 */
@ApiModel("分页对象【Page】")
public class Page {
    @ApiModelProperty(value = "页号 默认1")
    private Integer page;
    @ApiModelProperty(value = "每页条数 默认10")
    private Integer limit = 10;
    @ApiModelProperty(value = "总条数")
    private Long total;

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
