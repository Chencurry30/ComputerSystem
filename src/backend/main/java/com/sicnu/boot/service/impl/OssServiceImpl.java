package com.sicnu.boot.service.impl;

import cn.hutool.core.lang.UUID;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.sicnu.boot.config.OssProperties;
import com.sicnu.boot.service.OssService;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.StsTokenVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/19 14:45
 */
@Service
public class OssServiceImpl implements OssService {

    @Resource
    private OssProperties ossProperties;

    @Override
    public ServerResponse<Map<String, String>> getUserPolicy(String fileName) {
        // 请填写您的AccessKeyId。
        String accessId = ossProperties.getAccessId();
        //// 请填写您的AccessKeyId。
        String accessKey = ossProperties.getAccessKey();
        // 请填写您的 endpoint。
        String endpoint = ossProperties.getEndpoint();
        // 请填写您的 bucketName 。
        String bucket = ossProperties.getBucket();
        // host的格式为 bucketName.endpoint
        String host = "https://" + bucket + "." + endpoint;
        // 用户上传文件时指定的前缀。
        String dir = "user/userImage/";
        return getMapServerResponse(fileName, accessId, accessKey, endpoint, host, dir);
    }

    @Override
    public ServerResponse<Map<String, String>> getQuestionPolicy(String fileName, String dir) {
        String accessId = ossProperties.getAccessId();
        String accessKey = ossProperties.getAccessKey();
        String endpoint = ossProperties.getEndpoint();
        String bucket = ossProperties.getBucket();
        String host = "https://" + bucket + "." + endpoint;
        String dirs = "question/" + dir +  "/";
        return getMapServerResponse(fileName, accessId, accessKey, endpoint, host, dirs);
    }

    @Override
    public ServerResponse<Map<String, String>> getVideoPolicy(String fileName) {
        String accessId = ossProperties.getAccessId();
        String accessKey = ossProperties.getAccessKey();
        String endpoint = ossProperties.getEndpoint();
        String bucket = ossProperties.getBucket();
        String host = "https://" + bucket + "." + endpoint;
        String dir = "video/videoImg/";
        return getMapServerResponse(fileName, accessId, accessKey, endpoint, host, dir);
    }

    @Override
    public ServerResponse<Map<String, String>> getDynamicPolicy(String fileName) {
        String accessId = ossProperties.getAccessId();
        String accessKey = ossProperties.getAccessKey();
        String endpoint = ossProperties.getEndpoint();
        String bucket = ossProperties.getBucket();
        String host = "https://" + bucket + "." + endpoint;
        String dir = "dynamic/image/";
        return getMapServerResponse(fileName, accessId, accessKey, endpoint, host, dir);
    }

    @Override
    public ServerResponse<StsTokenVo> getStsToken() {
        //构建一个阿里云客户端，用于发起请求。
        //设置调用者（RAM用户或RAM角色）的AccessKey ID和AccessKey Secret。
        DefaultProfile profile = DefaultProfile.getProfile("cn-chengdu", ossProperties.getAccessId(), ossProperties.getAccessKey());
        IAcsClient client = new DefaultAcsClient(profile);

        //构造请求，设置参数。
        AssumeRoleRequest request = new AssumeRoleRequest();
        request.setRoleArn("acs:ram::1482268519483610:role/uploader");
        request.setRoleSessionName("uploader");
        //发起请求，并得到响应。
        try {
            AssumeRoleResponse response = client.getAcsResponse(request);
            StsTokenVo stsTokenVo = new StsTokenVo();
            stsTokenVo.setStsToken(response.getCredentials().getSecurityToken());
            stsTokenVo.setAccessKeyId(response.getCredentials().getAccessKeyId());
            stsTokenVo.setAccessKeySecret(response.getCredentials().getAccessKeySecret());
            stsTokenVo.setExpiration(response.getCredentials().getExpiration());
            stsTokenVo.setRegion("oss-cn-chengdu");
            stsTokenVo.setBucket(ossProperties.getBucket());
            return ServerResponse.createBySuccess("获取成功",stsTokenVo);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return ServerResponse.createBySuccessMessage("获取失败");
    }

    /**
     * description: 生成代理
     *
     * @param fileName:
     * @param accessId:
     * @param accessKey:
     * @param endpoint:
     * @param host:
     * @param dirs:
     * @return ServerResponse<Map<String,String>>
     * @author 胡建华
     * Date:  2022/11/24 15:47
     */
    private ServerResponse<Map<String, String>> getMapServerResponse(String fileName, String accessId, String accessKey, String endpoint, String host, String dirs) {
        fileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
        String key = dirs + fileName;
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessId, accessKey);
        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            // PostObject请求最大可支持的文件大小为5 GB，即CONTENT_LENGTH_RANGE为5*1024*1024*1024。
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dirs);

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
            respMap.put("dir", dirs);
            // "https://" + bucketname + '.' + endpoint;  (前端请求oss服务路径)
            respMap.put("host", host);
            //dir + fileName (上传Object的名称。)
            respMap.put("key", key);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
            return ServerResponse.createBySuccess("返回成功", respMap);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ossClient.shutdown();
        }
        return ServerResponse.createByErrorCodeMessage(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), "服务器异常");
    }
}
