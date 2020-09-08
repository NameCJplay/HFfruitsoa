package com.hf.zuul.Service.Impl;


import com.hf.domain.Domain.User.UserDO;
import com.hf.zuul.Domain.SysUser;
import com.hf.zuul.Service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class userDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userValue = username;
        UserDO userDO = userService.getbyvalue(userValue);
        if(StringUtils.isEmpty(userValue)){throw new UsernameNotFoundException("该用户不存在");}
        else if(userDO == null){throw new BadCredentialsException("账号或密码错误");
        }else if(userDO.getUserStatus()!=1){throw new LockedException("该用户被锁定，请联系管理员"); }
        SysUser sysuser =  new SysUser();
        BeanUtils.copyProperties(userDO,sysuser);
        return sysuser;
    }


}
