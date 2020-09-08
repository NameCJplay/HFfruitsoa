package com.hf.zuul.Config;


import com.hf.zuul.Filter.AuthUserPwdFilter;
import com.hf.zuul.Filter.JwtAuthTokenFilter;
import com.hf.zuul.Handler.*;
import com.hf.zuul.Service.Impl.userDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired //自定义登录逻辑
    private userDetailsServiceImpl userDetailsService;
    @Autowired //登录前jwt验证
    private JwtAuthTokenFilter jwtAuthTokenFilter;
    @Autowired //未登录处理器
    private AuthEntryPointHandler authEntryPointHandler;
    @Autowired //登录成功处理器
    private AuthSuccessHandler authSuccessHandler;
    @Autowired //登录失败处理器
    private AuthFailHandler authFailHandler;
    @Autowired //注销处理器
    private AuthLoginOutHandler authLoginOutHandler;
//    @Autowired
//    private AuthErrorHandler authErrorHandler;
    @Value("${hf.CookieName}")
    private String CookieName;
    //自定义UsernamePasswordAuthenticationFilter
    @Bean
    AuthUserPwdFilter authUserPwdFilter() throws Exception {
        AuthUserPwdFilter filter = new AuthUserPwdFilter();
        filter.setAuthenticationSuccessHandler(authSuccessHandler);
        filter.setAuthenticationFailureHandler(authFailHandler);
        //重用WebSecurityConfigurerAdapter配置的AuthenticationManager
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }
    //加密方式
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.cors().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/authService/getAuth").permitAll();
        http.authorizeRequests()
                .antMatchers("/myLogin","/login","/loginHtml","/authService/getAuth",
                        "/webapp/css/**","/webapp/js/**","/webapp/images/**","/webapp/fonts/**",
                        "/Error500"
                ).permitAll()
                .antMatchers("/**").fullyAuthenticated().and()
                .formLogin().loginPage("/loginHtml").loginProcessingUrl("/myLogin")
                .usernameParameter("userValue").passwordParameter("userPwd")
                .successHandler(authSuccessHandler)
                .failureHandler(authFailHandler)
                .and().logout().deleteCookies(CookieName)
                .logoutSuccessHandler(authLoginOutHandler);
//                .and().exceptionHandling().accessDeniedHandler(authErrorHandler);
        http.addFilterAt(authUserPwdFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtAuthTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override //使用自定义登录逻辑
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }



}
