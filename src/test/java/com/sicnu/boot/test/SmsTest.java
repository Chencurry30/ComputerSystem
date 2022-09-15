package com.sicnu.boot.test;

import com.sicnu.boot.service.ISmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description:
 * @author :     胡建华
 * Data: 2022-09-15 15:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SmsTest {

    @Autowired
    private ISmsService smsService;

    @Test
    public void testSendCode() {
        smsService.sendSmsCode("13541169382");
    }

}
