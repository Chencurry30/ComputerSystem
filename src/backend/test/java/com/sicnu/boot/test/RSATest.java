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
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC877CvJ0mIsjn/MdoxABhY47UxEGBG862Vt7l0t5DNQmXKvMzApFGhHcFy1W/4D+JWz1UPrFVsTsJHdLpX2UiN9sXpKD7RxvekBsb99/StmDB2kjpdX7hUehUv8kQzfmUa8NeVku27ESPv72skwsRTie/vkmWCf9aI0wqzWshCIwIDAQAB";
        String data = "123456";
        String encryptedDataOnJava = RSAUtils.encryptedDataOnJava(data, publicKey);
        System.out.println("encryptedDataOnJava = " + encryptedDataOnJava);
    }

}
