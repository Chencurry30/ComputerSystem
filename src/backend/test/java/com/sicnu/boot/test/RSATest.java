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

}
