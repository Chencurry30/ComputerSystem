package com.sicnu.boot.service.impl;

import cn.hutool.core.lang.UUID;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.sicnu.boot.config.OssProperties;
import com.sicnu.boot.service.OssService;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * description:  TODO
 *
 * @author :  胡建华
 * Data:    2022/11/19 14:45
 */
@Service
public class OssServiceImpl implements OssService {

    @Resource
    private OssProperties ossProperties;

    @Override
    public ServerResponse<Map<String, String>> policy(String fileName) {
        // 请填写您的AccessKeyId。
        String accessId = ossProperties.getAccessId();
        //// 请填写您的AccessKeyId。
        String accessKey = ossProperties.getAccessKey();
        // 请填写您的 endpoint。
        String endpoint = ossProperties.getEndpoint();
        // 请填写您的 bucketName 。
        String bucket = ossProperties.getBucket();
        // host的格式为 bucketname.endpoint
        String host = "https://" + bucket + "." + endpoint;
        // 用户上传文件时指定的前缀。
        String dir = "user/userImage/";
        //文件名生成
        fileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
        String key = dir + fileName;
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessId, accessKey);
        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            // PostObject请求最大可支持的文件大小为5 GB，即CONTENT_LENGTH_RANGE为5*1024*1024*1024。
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes(StandardCharsets.UTF_8);
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = ossClient.calculatePostSignature(postPolicy);
            Map<String, String> respMap = new LinkedHashMap<>();
            //您的AccessKeyId。
            respMap.put("accessid", accessId);
            //Policy规定了请求表单域的合法性。
            respMap.put("policy", encodedPolicy);
            //根据AccessKey Secret和Policy计算的签名信息，OSS验证该签名信息从而验证该Post请求的合法性。
            respMap.put("signature", postSignature);
            //前缀
            respMap.put("dir", dir);
            // "https://" + bucketname + '.' + endpoint;  (前端请求oss服务路径)
            respMap.put("host", host);
            //dir + fileName (上传Object的名称。)
            respMap.put("key", key);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
            return ServerResponse.createBySuccess("返回成功",respMap);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ossClient.shutdown();
        }
        return ServerResponse.createByErrorCodeMessage(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), "服务器异常");
    }
}
