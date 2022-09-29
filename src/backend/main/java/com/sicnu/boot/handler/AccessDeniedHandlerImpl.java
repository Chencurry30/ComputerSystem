package com.sicnu.boot.handler;

import com.alibaba.fastjson.JSON;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description:  权限不足的异常处理器
 *
 * @author :  胡建华
 * Data:    2022/09/26 18:58
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ServerResponse<String> serverResponse = ServerResponse.createByErrorCodeMessage(ResponseCode.FORBIDDEN.getCode(), "权限不足");

        String json = JSON.toJSONString(serverResponse);
        WebUtils.renderString(response,json);

    }
}
