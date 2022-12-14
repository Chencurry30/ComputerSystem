package com.sicnu.boot.vo;

import lombok.Data;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/29 18:17
 */
@Data
public class StsTokenVo {

    private String region;

    private String accessKeyId;

    private String accessKeySecret;

    private String stsToken;

    private String bucket;

    private String expiration;

}
