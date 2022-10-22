package com.sicnu.boot.test;

import com.sicnu.boot.utils.RSAUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/18 21:31
 */
@SpringBootTest
public class RSATest {
    @Test
    void test() throws Exception {
        Map<String, Object> map = RSAUtils.genKeyPair();
        String publicKey = RSAUtils.getPublicKey(map);
        System.out.println("publicKey = " + publicKey);
        String privateKey = RSAUtils.getPrivateKey(map);
        System.out.println("privateKey = " + privateKey);
        String date = RSAUtils.encryptedDataOnJava("Hello", publicKey);
        String decryptDataOnJava = RSAUtils.decryptDataOnJava(date, privateKey);
        System.out.println("decryptDataOnJava = " + decryptDataOnJava);
    }

    @Test
    void test1(){
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjDkvnyONn2a03/UBZ9fz4l6xzL6SxX7jpP5A2UhbeYm+mBDoK+RaZ6H/toAYpDOvpd7vGjA4yi7NmRNflYm1PSL78mIVJikg6LK9T8ehaj5BwIe+U5MCW3tdvg6GqPWWpPzNpROUppddjc4Sf52urnJlA8qOu0TIcxTN10Hl9iwIDAQAB";
        String data = "123456";
        String encryptedDataOnJava = RSAUtils.encryptedDataOnJava(data, publicKey);
        System.out.println("encryptedDataOnJava = " + encryptedDataOnJava);
    }

}
