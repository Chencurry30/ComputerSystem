package com.sicnu.boot.handler;

import com.alibaba.fastjson.JSON;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description:  TODO
 *
 * @author :  胡建华
 * Data:    2022/09/26 19:15
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ServerResponse serverResponse = ServerResponse.createByErrorCodeMessage(HttpStatus.UNAUTHORIZED.value(), "认证失败请重新登录");
        String json = JSON.toJSONString(serverResponse);
        WebUtils.renderString(response,json);
    }
}
