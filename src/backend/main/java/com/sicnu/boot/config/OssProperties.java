package com.sicnu.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * description:  Oss对象存储服务，配置
 *
 * @author :  胡建华
 * Data:    2022/11/19 14:51
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "oss-config")
public class OssProperties {
    /**
     * description:Oss的AccessKeyId
     */
    private String accessId;

    /**
     * description:Oss的AccessKeySecret
     */
    private String accessKey;

    /**
     * description: 你的Oss的域名前缀
     */
    private String endpoint;

    /**
     * description: Oss的bucket name
     */
    private String bucket;

    /**
     * description: Oss的完整域名
     */
    private String host;

    /**
     * description: 上传的文件路径
     */
    private String dir;

    /**
     * description: 过期时间
     */
    private String expire;
}
