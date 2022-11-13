package com.sicnu.boot.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description:  解决request.getInputStream()只能读取一次的问题
 *
 * @author :  胡建华
 * Data:    2022/11/13 21:37
 */
@Component
public class RequestReplaceFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if (!(request instanceof MyRequestWrapper)) {
            request = new MyRequestWrapper(request);
        }
        filterChain.doFilter(request, response);
    }
}
