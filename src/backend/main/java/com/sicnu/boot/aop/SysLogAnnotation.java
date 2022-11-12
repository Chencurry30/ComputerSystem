package com.sicnu.boot.aop;

import java.lang.annotation.*;

/**
 * description:  自定义操作日志注解
 *
 * @author :  胡建华
 * Data:    2022/11/11 20:14
 */
@Target(ElementType.METHOD)//注解放置的目标位置即方法级别
@Retention(RetentionPolicy.RUNTIME)//注解在哪个阶段执行
@Documented
public @interface SysLogAnnotation {
    String operModel() default ""; // 操作模块

    String operType() default "";  // 操作类型

    String operDesc() default "";  // 操作说明
}
