package com.sicnu.boot;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: 启动类
 *  @ EnableEncryptableProperties: 开启加密注解
 *
 * @author 胡建华
 * Date:  2022/9/28 22:46
 */
@SpringBootApplication
@EnableEncryptableProperties
public class ComputerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComputerSystemApplication.class, args);

    }

}
