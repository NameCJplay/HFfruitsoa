package com.hf.zuul.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hf.domain.Domain.User.UserDO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// security 自定义返回对象
public class SysUser extends UserDO implements UserDetails {

    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Integer role = getUserRole();
        if(role==1){grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));}
        else if(role == 2){grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));}
        return grantedAuthorities;
    }
    @Override
    public String getPassword() {
        return getUserPwd();
    }

    @Override
    public String getUsername() {
        return getUserId().toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return getUserStatus()==1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



}
