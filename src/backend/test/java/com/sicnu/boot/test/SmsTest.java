package com.sicnu.boot.test;

import com.sicnu.boot.service.ISmsService;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;
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

    //加密
    @Test
    public void testEncrypt() {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();

        // 加密的算法（默认的）
        config.setAlgorithm("PBEWithMD5AndDES");
        // 加密的密钥，自己填写
        config.setPassword("sicnu");
        standardPBEStringEncryptor.setConfig(config);
        //密码（未加密）
        String plainText = "jdbc:mysql://localhost:3306/computer_system?serverTimezone=UTC&useAffectedRows=true";
        String encryptedText = standardPBEStringEncryptor.encrypt(plainText);
        System.out.println(encryptedText);
    }

    //解密
    @Test
    public void testDe() {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();

        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPassword("sicnu");
        standardPBEStringEncryptor.setConfig(config);
        //加密后的密码
        String encryptedText = "nQyKcsEIR23N4o1h3MQuYQ==";
        String plainText = standardPBEStringEncryptor.decrypt(encryptedText);
        System.out.println(plainText);
    }

}
