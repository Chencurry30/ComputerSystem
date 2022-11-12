package com.sicnu.boot.aop;

import com.sicnu.boot.mapper.LogMapper;
import com.sicnu.boot.pojo.Log;
import com.sicnu.boot.pojo.User;
import com.sicnu.boot.utils.HttpUtils;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
/**
 * description:  操作日志切面处理类
 *
 * @author :  胡建华
 * Data:    2022/11/11 20:18
 */
@Aspect
@Component
@Slf4j
public class SysLogAspect {
    @Resource
    private LogMapper logDao;

    /**
     * 设置操作日志切入点   在注解的位置切入代码
     */
    @Pointcut("@annotation(com.sicnu.boot.aop.SysLogAnnotation)")
    public void pointCut() {
    }

    /**
     * 记录操作日志
     * @param joinPoint 方法的执行点
     * @param result  方法返回值
     */
    @AfterReturning(returning = "result", value = "pointCut()")
    public void saveOperLog(JoinPoint joinPoint, Object result) {
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        assert requestAttributes != null;
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        try {
            Log sysLog = getLog(joinPoint, request);
            //返回值信息
            ServerResponse dataResult = (ServerResponse)result;
            //需要先判断返回值是不是ServerResponse，如果不是會拋異常，需要控制层的接口返回数据格式统一
            //如果嫌返回格式统一太麻烦建议日志保存时去掉操作结果
            //獲取方法返回值中的msg，如果上面的類型錯誤就拿不到msg就會拋異常
            sysLog.setResult(dataResult.getMessage());
            log.info("成功描述,成功方法:{},方法描述:{},成功结果:{}",
                    sysLog.getMethod(),sysLog.getDescription(),sysLog.getResult());
            logDao.insertLog(sysLog);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("日誌記錄異常，請檢查返回值是否是ServerResponse類型");
        }
    }

    @AfterThrowing(throwing = "exception",value = "pointCut()")
    public void throwLog(JoinPoint joinPoint,Exception exception){
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        assert requestAttributes != null;
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        try {
            Log sysLog = getLog(joinPoint, request);
            //需要先判断返回值是不是ServerResponse，如果不是會拋異常，需要控制层的接口返回数据格式统一
            //如果嫌返回格式统一太麻烦建议日志保存时去掉操作结果
            //獲取方法返回值中的msg，如果上面的類型錯誤就拿不到msg就會拋異常
            sysLog.setResult(exception.getMessage());
            log.error("发生错误，错误方法:{},方法描述:{},错误原因:{}"
                    ,sysLog.getMethod(),sysLog.getDescription(),sysLog.getResult());
            logDao.insertLog(sysLog);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("日誌記錄異常，請檢查返回值是否是ServerResponse類型");
        }
    }

    private Log getLog(JoinPoint joinPoint, HttpServletRequest request) {
        Log log = new Log();
        // 从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        //获取操作
        SysLogAnnotation annotation = method.getAnnotation(SysLogAnnotation.class);
        if (annotation != null) {
            log.setModel(annotation.operModel());
            log.setType(annotation.operType());
            log.setDescription(annotation.operDesc());
        }

        // 获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 获取请求的方法名
        String methodName = method.getName();
        methodName = className + "." + methodName;
        // 类名.请求方法
        log.setMethod(methodName);
        //操作时间
        log.setCreateDate(LocalDateTime.now());
        //操作用户 --登录时有把用户的信息保存在session中，可以直接取出
        //获取SecurityContextHolder中的用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof LoginUser){
            LoginUser loginUser = (LoginUser) authentication.getPrincipal();
            User user = loginUser.getUser();
            log.setUsername(user.getUsername());
        }
        else {
            log.setUsername(null);
        }
        //操作IP IPUtils工具类网上大把的，比如工具类集锦的hutool.jar
        log.setIp(HttpUtils.getIpAddr(request));
        // 请求URI
        log.setUrl(request.getRequestURI());
        return log;
    }

    /**
     * 转换request 请求参数
     *
     * @param paramMap request获取的参数数组
     */
    public Map<String, String> converMap(Map<String, String[]> paramMap) {
        Map<String, String> rtnMap = new HashMap<>(10);
        for (String key : paramMap.keySet()) {
            rtnMap.put(key, paramMap.get(key)[0]);
        }
        return rtnMap;
    }

    /**
     * 转换异常信息为字符串
     *
     * @param exceptionName    异常名称
     * @param exceptionMessage 异常信息
     * @param elements         堆栈信息
     */
    public String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        StringBuilder strbuff = new StringBuilder();
        for (StackTraceElement stet : elements) {
            strbuff.append(stet).append("\n");
        }
        return exceptionName + ":" + exceptionMessage + "\n\t" + strbuff;
    }
}
