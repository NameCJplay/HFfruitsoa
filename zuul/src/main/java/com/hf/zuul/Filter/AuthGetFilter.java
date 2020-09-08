package com.hf.zuul.Filter;

import com.alibaba.fastjson.JSON;
import com.hf.zuul.Domain.SysUser;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.http.HttpServletRequestWrapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthGetFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext rc = RequestContext.getCurrentContext();
        if(rc.getRequest().getRequestURI().equals("/authService/getAuth")){
            SysUser sysUser = JwtAuthTokenFilter.AuthenticationUser;
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("userValue",sysUser.getUserId());
            map.put("passWord",sysUser.getPassword());
            map.put("Authorities",sysUser.getAuthorities().toArray()[0].toString());
            rc.setSendZuulResponse(false);
            rc.getResponse().setContentType("application/json");
            rc.setResponseBody(JSON.toJSONString(map));
        }
        return null;
    }
}
