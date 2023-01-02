package com.sicnu.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * description:  多线程配置类，配置线程池
 * @ EnableAsync ：启用异步任务
 *
 * @author :  胡建华
 * Data:    2022/12/13 18:00
 */
@Configuration
@EnableAsync
public class ThreadConfig {
    @Bean("myExecutor")
    public ThreadPoolTaskExecutor myExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(8);
        //配置最大线程数
        executor.setMaxPoolSize(30);
        //配置队列大小
        executor.setQueueCapacity(1000);
        //线程的名称前缀
        executor.setThreadNamePrefix("Executor-");
        //线程活跃时间（秒） ：setKeepAliveSeconds(60)
        //等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }

    @Bean("myExecutor1")
    public ThreadPoolTaskExecutor myExecutor1(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(4);
        //配置最大线程数
        executor.setMaxPoolSize(4);
        //配置队列大小
        executor.setQueueCapacity(1000);
        //线程的名称前缀
        executor.setThreadNamePrefix("Executor-");
        //线程活跃时间（秒） ：setKeepAliveSeconds(60)
        //等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
