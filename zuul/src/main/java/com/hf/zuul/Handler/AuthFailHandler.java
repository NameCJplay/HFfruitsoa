package com.hf.zuul.Handler;

import com.alibaba.fastjson.JSON;
import com.hf.domain.Common.ResponseUtil;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//登录失败处理器
@Component
public class AuthFailHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        // 这些对于操作的处理类可以根据不同异常进行不同处理
        if (exception instanceof UsernameNotFoundException){
            System.out.println("【登录失败】"+exception.getMessage());
            response.getWriter().write(JSON.toJSONString(new ResponseUtil("500","用户不存在！")));
        }
        if (exception instanceof LockedException){
            System.out.println("【登录失败】"+exception.getMessage());
            response.getWriter().write(JSON.toJSONString(new ResponseUtil("500","该用户被锁定,请联系管理员！")));
        }
        if (exception instanceof BadCredentialsException){
            System.out.println("【登录失败】"+exception.getMessage());
            response.getWriter().write(JSON.toJSONString(new ResponseUtil("500","账号或密码错误！")));
        }
    }
}
