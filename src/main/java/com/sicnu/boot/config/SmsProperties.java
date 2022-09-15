package com.sicnu.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * description:  腾讯云短信服务，配置
 *
 * @author :     胡建华
 * Data: 2022-09-15 11:09
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sms-config")
public class SmsProperties {

    /** 腾讯云账户密钥对secretId（在访问管理中配置） */
    private String secretId;

    /** 腾讯云账户密钥对secretKey（在访问管理中配置） */
    private String secretKey;

    /** 短信应用appId */
    private String appId;

    /** 短信应用appKey */
    private String appKey;

    /** 签名 */
    private String smsSign;

    /** 过期时间 */
    private String expireTime;

    /** redis存储前缀 */
    private String phonePrefix;

}
