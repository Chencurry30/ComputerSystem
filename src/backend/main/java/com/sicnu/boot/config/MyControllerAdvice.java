package com.sicnu.boot.config;


import com.sicnu.boot.utils.ServerResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * description:  全局异常处理器
 *
 * @author :  胡建华
 * Data:    2022/09/17 17:16
 */
@RestControllerAdvice
public class MyControllerAdvice {
    //拦截所有异常
    //可以定制
//    @ExceptionHandler(RuntimeException.class)

    @ExceptionHandler(Exception.class)
    public ServerResponse<String> handleException(Exception e){
        e.printStackTrace();
        //TODO 项目完成之后可以将返回信息修改了，这里不修改便于改错
        return ServerResponse.createByErrorMessage(e.getMessage());
    }
}
