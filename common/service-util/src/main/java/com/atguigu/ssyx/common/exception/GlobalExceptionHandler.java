package com.atguigu.ssyx.common.exception;

import com.atguigu.ssyx.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.atguigu.ssyx.common.exception
 * desc: 全局异常
 * @author lzyy
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail(null);
    }

    /**
     * 自定义异常处理方法
     */
    @ExceptionHandler(SsyxException.class)
    @ResponseBody
    public Result error(SsyxException e) {
        return Result.fail(null);
    }
}
