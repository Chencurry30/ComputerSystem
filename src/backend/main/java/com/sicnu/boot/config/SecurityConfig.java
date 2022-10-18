package com.sicnu.boot.config;

import com.sicnu.boot.filter.JwtAuthenticationTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;

/**
 * description:  配置安全相关的
 *
 * @author :  胡建华
 * Data:    2022/09/18 22:00
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Resource
    private AccessDeniedHandler accessDeniedHandler;

    @Resource
    private AuthenticationSuccessHandler successHandler;

    @Resource
    private AuthenticationFailureHandler failureHandler;

    @Resource
    private LogoutSuccessHandler logoutSuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                // 允许跨域
                .cors()
                .and()

                // 配置路径是否需要认证
                .authorizeRequests()
                // 对于登录接口 允许匿名访问
                .antMatchers("/users/login", "/users/register", "/users/sms","/users/forget/**","/users/public").permitAll()
                // 配置权限
                .antMatchers("/hello2").hasAuthority("/hello2")
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()
                .and()

                //添加过滤器
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                //配置异常处理器
                .exceptionHandling()
                //配置认证失败处理器
                .authenticationEntryPoint(authenticationEntryPoint)
                //配置授权失败处理器
                .accessDeniedHandler(accessDeniedHandler)
                .and()

                //TODO 认证处理器为成功
                .formLogin()
                // 配置认证成功处理器
                .successHandler(successHandler)
                // 配置认证失败处理器
                .failureHandler(failureHandler)
                .and()

                .logout()
                //配置注销成功处理器
                .logoutSuccessHandler(logoutSuccessHandler)

                .and()
                .build();

    }

    /**
     * description: 配置密码加密的bean
     *
     * @return PasswordEncoder
     * @author 胡建华
     * Date:  2022/9/26 22:46
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 获取AuthenticationManager（认证管理器），登录时认证使用
     *
     * @param authenticationConfiguration ：
     * @return AuthenticationManager
     * @throws Exception ：
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
