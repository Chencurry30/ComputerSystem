package com.sicnu.boot.config;


import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Collectors;

/**
 * description:  全局异常处理器
 *
 * @author :  胡建华
 * Data:    2022/09/17 17:16
 */
@RestControllerAdvice
@Slf4j
public class MyControllerAdvice {
    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    public ServerResponse<String> handleValidatedException(Exception e) {
        e.printStackTrace();
        String collect = "";
        e.printStackTrace();
        if (e instanceof MethodArgumentNotValidException) {
            // BeanValidation exception
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            collect = ex.getBindingResult().getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining("; "));
        } else if (e instanceof ConstraintViolationException) {
            // BeanValidation GET simple param
            ConstraintViolationException ex = (ConstraintViolationException) e;
            collect = ex.getConstraintViolations().stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("; "));

        } else if (e instanceof BindException) {
            // BeanValidation GET object param
            BindException ex = (BindException) e;
            collect = ex.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining("; "));
        }

        return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), collect);
    }

    /**
     * 处理AccessDeniedException无权限异常
     * @param e :
     * @return :
     */
    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseBody
    public ServerResponse<String> exceptionHandler(AccessDeniedException e){
        log.error("不允许访问！原因是:" + e.getMessage());
        return ServerResponse.createByErrorCodeMessage(ResponseCode.FORBIDDEN.getCode(), "权限不足");
    }

    /**
     * description: 拦截所有异常
     *     可以定制
     *
     * @param e:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/10/22 22:54
     */
    @ExceptionHandler(Exception.class)
    public ServerResponse<String> handleException(Exception e){
        e.printStackTrace();
        return ServerResponse.createByErrorMessage("服务器异常");
    }
}
