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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDEhsuR2/TwOGffxVSvLOGtPMi3+f98LoV8dmVElxbWfGic0SkRhixQtgQp4EtEVyP2ZgPruy8b4j6BPXde0PstAiftVMHiJ8yhIA0phL3zp473KkUMyNtBXqa3bIhFyx0cXh0vQdnk8txNF85LsJbvq9RGSpY19lqds84Z1jtfcwIDAQAB";
        String data = "123456";
        String encryptedDataOnJava = RSAUtils.encryptedDataOnJava(data, publicKey);
        System.out.println("encryptedDataOnJava = " + encryptedDataOnJava);
    }

}
