package com.me.util;

import com.github.pagehelper.Page;

/**
 * @Author: tianchong
 * @Date: 2018/5/16 16:41
 * @Description:
 */
public class ResultUtils {

    public static <T> T getResultData(Result<T> result) {
        if (result == null) {
            return null;
        }
        T data = result.getData();
        if (data == null) {
            return null;
        }
        return data;
    }

    public static <T> Result<T> getSuccess(T data) {
        if (data instanceof Page) {
            Page<T> p = (Page<T>) data;
            com.me.util.Page page = new com.me.util.Page();
            page.setLimit(p.getPageSize());
            page.setPage(p.getPageNum());
            page.setTotal(p.getTotal());
            return new Result<T>(data, null, null, true, page, true);
        }
        return new Result<T>(data, null, null, true, null, false);
    }

    /*public static <T> Result<T> getFault(Integer code,String message) {
        return new Result<T>(code,message);
    }*/

    public static Result<BooleanResult> getBooleanResult(boolean result) {
        int code = result ? 1000 : 500;
        String msg = result ? "操作成功" : "操作失败";
        BooleanResult br = new BooleanResult(result);
        return new Result<BooleanResult>(br, code, msg, result, null, false);
    }

    /*public static Result<BooleanResult> getBooleanResult(boolean result,String msg) {
        int code = result?Result.RESULT_SUCCESS:Result.RESULT_FAULT;
        BooleanResult br = new BooleanResult(result,msg);
        return new Result<BooleanResult>(br,code,msg,null,false);
    }*/

}
