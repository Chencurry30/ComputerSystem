package com.sicnu.boot;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * description: 启动类
 *  @ EnableEncryptableProperties: 开启加密注解
 *  @ EnableScheduling : 开启定时任务
 *
 * @author 胡建华
 * Date:  2022/9/28 22:46
 */
@SpringBootApplication
@EnableEncryptableProperties
@EnableScheduling
public class ComputerSystemApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ComputerSystemApplication.class, args);
    }

    /**
     * description: 开启定时任务
     *
     * @param application:
     * @return SpringApplicationBuilder
     * @author 胡建华
     * Date:  2022/12/13 10:44
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ComputerSystemApplication.class);
    }

}
