package com.sicnu.boot.service.impl;


import com.sicnu.boot.utils.RedisUtils;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.config.SmsProperties;
import com.sicnu.boot.service.ISmsService;
import com.sicnu.boot.sms.SmsCodeUtil;
import com.sicnu.boot.sms.SmsLengthEnum;
import com.sicnu.boot.sms.SmsResponseCodeEnum;
import com.sicnu.boot.sms.SmsUtil;
import com.tencentcloudapi.sms.v20210111.models.SendStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * description:
 * @author :     胡建华
 * Data: 2022-09-15 11:42
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SmsServiceImpl implements ISmsService {

    private final SmsProperties smsProperties;

    private final RedisUtils redisUtils;

    /** 腾讯云短信模板id-短信验证码 */
    @Value("${sms-config.templateIds.code}")
    private String templateIdCode;

    /**
     * description: 发送短信验证码
     *
     * @param phone 手机号
     * @author 胡建华
     * Date: 2020/9/16 10:11
     */
    @Override
    public ServerResponse<String> sendSmsCode(String phone) {
        // redis缓存的键
        final String smsKey = SmsCodeUtil.createSmsCacheKey(smsProperties.getPhonePrefix(), phone, "wxUser_sign");

        //下发手机号码，采用 e.164 标准，+[国家或地区码][手机号]  示例如：+8613711112222， 其中前面有一个+号 ，86为国家码，13711112222为手机号，最多不要超过200个手机号
        String[] phoneNumbers = {"+86" + phone};
        //模板参数: 若无模板参数，则设置为空（第一个参数为随机验证码，第二个参数为有效时间）
        final String smsRandomCode = SmsCodeUtil.createSmsRandomCode(SmsLengthEnum.SMS_LENGTH_4);
        String[] templateParams = {smsRandomCode};

        SendStatus[] sendStatuses = SmsUtil.sendSms(smsProperties, templateIdCode, templateParams, phoneNumbers);
        String resCode = " ";
        if (sendStatuses != null){
            resCode = sendStatuses[0].getCode();
        }
        if (resCode.equals(SmsResponseCodeEnum.OK.getCode())) {
            // 返回ok，缓存
            redisUtils.setCacheObject(smsKey, smsRandomCode, Integer.parseInt(smsProperties.getExpireTime()), TimeUnit.MINUTES);
            return ServerResponse.createBySuccessMessage("发送成功");
        } else {
            if (sendStatuses != null){
                log.error("【短信业务-发送失败】phone:" + phone + "errMsg:" + sendStatuses[0].getMessage());
            }
            //throw new BaseException(ResponseEnum.SMS_NOT_SEND);
            return ServerResponse.createByErrorCodeMessage(ResponseCode.SMS_NOT_SEND.getCode(), "发送失败");
        }

    }

    /**
     * description:验证短信验证码
     *
     * @param phone 手机号
     * @param code  验证码
     * @author 胡建华
     * Date: 2020/9/16 10:11
     */
    @Override
    public ServerResponse<String> verifyCode(String phone, String code) {
        // redis缓存的键
        final String smsKey = SmsCodeUtil.createSmsCacheKey(smsProperties.getPhonePrefix(), phone,
                "wxUser_sign");
        // 如果key存在（存在并且未过期）
        if (redisUtils.hasKey(smsKey)) {
            String cacheCode = redisUtils.getCacheObject(smsKey).toString();
            if (cacheCode.equals(code)) {
                //验证码正确
                redisUtils.deleteObject(smsKey);
                log.info("【短信业务-微信公众号手机认证成功】phone：" + phone);
                return ServerResponse.createBySuccessMessage("手机验证成功");
            } else {
                //验证码不正确
                log.error("【短信业务-微信公众号手机认证失败】验证码错误。phone：" + phone);
                return ServerResponse.createByErrorCodeMessage(ResponseCode.SMS_CODE_ERROR.getCode(), "验证码错误");
            }
        } else {
            log.error("【短信业务-微信公众号手机认证失败】验证码失效。phone：" + phone);
            return ServerResponse.createByErrorCodeMessage(ResponseCode.SMS_CODE_INVALID.getCode(), "验证码失效");
        }
    }

}
