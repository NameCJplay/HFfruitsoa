package com.hf.user.Aspect;

import com.hf.domain.Annatation.MyAuthorize;
import com.hf.domain.Common.TokenUtil;
import com.hf.domain.Exception.ForbiddenException;
import com.hf.user.Service.AuthService;
import feign.FeignException;
import netscape.security.ForbiddenTargetException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class MyAuthorizeAspect {

    @Autowired
    private AuthService authService;

    public static Authentication authentication = null;

    @Before("@annotation(com.hf.domain.Annatation.MyAuthorize)")
    public void PreAuth(JoinPoint joinPoint) throws Exception {
        boolean boo = false;
        MyAuthorize myAuthorize = ((MethodSignature)joinPoint.getSignature()).getMethod().getAnnotation(MyAuthorize.class);

        Map<String, Object> map = authService.getAuth();
        if(map != null){
            if(authentication!= null && map.get("userValue") == authentication.getPrincipal()){
                for (String str:myAuthorize.Role()) {
                    String Authorities = authentication.getAuthorities().toArray()[0].toString();
                    if(str.equals(Authorities)){
                        boo = true;
                        break;
                    }
                }
            }else{
                List<GrantedAuthority> authorities = new ArrayList<>();
                String Authorities = map.get("Authorities").toString();
                if(Authorities != null){
                    for (String str:myAuthorize.Role()) {
                        if(str.equals(Authorities)){
                            boo = true;
                            authorities.add(new SimpleGrantedAuthority(Authorities));
                            authentication = new UsernamePasswordAuthenticationToken(map.get("userValue"),map.get("passWord"), authorities);
                            SecurityContextHolder.getContext().setAuthentication(authentication);
                            break;
                        }
                    }
                }
            }
        }
        if(!boo)throw new AccessDeniedException("权限不足！");
    }

}
