package com.hf.zuul.Filter;

import com.hf.domain.Common.GetUserIpUtil;
import com.hf.domain.Common.TokenUtil;
import com.hf.zuul.Domain.SysUser;
import com.hf.zuul.Handler.AuthEntryPointHandler;
import com.hf.zuul.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
public class JwtAuthTokenFilter extends OncePerRequestFilter {
    //前置自定义token验证拦截器
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private RedisService redisService;

    public static SysUser AuthenticationUser;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取和验证cookie
        Cookie[] cookies = request.getCookies();
        String authToken = null;
        if (cookies != null && cookies.length>0) {
            Map<String, Object> claims = TokenUtil.parseJWT(TokenUtil.getTokenByCookie(cookies,"FruitsOAToken"));
            String userId = claims.get("userId").toString();
            String userIp = claims.get("userIp").toString();
            //验证token
            if(userId != null && redisService.hasKey(userId)){
                //判断token中的IP地址是否相同
                if (userIp != null && userIp.equals(GetUserIpUtil.getIpAddr(request))) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
                    //验证token是否正确
                    if (userDetails != null) {
                        //用户信息保存在域中
                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        AuthenticationUser = (SysUser) authentication.getPrincipal();
                        //设置权限
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }else{
                new AuthEntryPointHandler().commence(request,response,null);
                System.out.println("身份信息已失效!");
            }
        }
        filterChain.doFilter(request, response);
    }
}
