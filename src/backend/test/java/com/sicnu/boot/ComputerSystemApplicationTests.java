package com.sicnu.boot;

import com.sicnu.boot.vo.UserDetail;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComputerSystemApplicationTests {

    @Test
    void contextLoads() {
        UserDetail userDetail = new UserDetail();
        System.out.println(userDetail);
    }

}
