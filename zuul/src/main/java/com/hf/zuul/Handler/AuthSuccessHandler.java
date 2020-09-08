package com.hf.zuul.Handler;

import com.alibaba.fastjson.JSON;
import com.hf.domain.Common.GetUserIpUtil;
import com.hf.domain.Common.ResponseUtil;
import com.hf.domain.Common.TokenUtil;
import com.hf.zuul.Domain.SysUser;
import com.hf.zuul.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//登录成功处理器
@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private RedisService redisService;

    @Value("${hf.CookieName}")
    private String CookieName;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SysUser sysUser = (SysUser)authentication.getPrincipal();
        Map<String,Object> claims = new HashMap<String,Object>();
        ResponseUtil responseUtil = new ResponseUtil();
        //token保存用户id和客户端ip 防抓包和泄露
        claims.put("userId",sysUser.getUserId());
        claims.put("userIp", GetUserIpUtil.getIpAddr(request));
        claims.put("Authentication", SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0]);
        //有效天数
        Integer exp = 1;
        String jwtToken = TokenUtil.createJWT(exp, claims);
        String userName = sysUser.getUserName();
        request.getSession().setAttribute("userName",userName);
        //存入redis(时间单位为秒)
        redisService.set(sysUser.getUserId().toString(),jwtToken,60*60*24*exp);
        //返回
        responseUtil.setJwtToken(jwtToken);
        responseUtil.setStatus("200");
        responseUtil.setMsg("登录成功！");
        System.out.println("登录成功！");
        //设置返回cookie 与 格式	Access-Control-Allow-Origin: http://manage.leyou.com
        //	Access-Control-Allow-Credentials: true
        //	Content-Type: text/html; charset=utf-8
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.addCookie(new Cookie(CookieName,jwtToken));
        response.addCookie(new Cookie("userName",userName));
        response.getWriter().write(JSON.toJSONString(responseUtil));

    }
}
