package com.hf.domain.Common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.Cookie;
import java.util.Date;
import java.util.Map;

public class TokenUtil {
    /**
     * 签名用的密钥
     */
    private static final String SIGNING_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCQIqfq7+iYGtbWbsvUDiXIKS7DFoeUlsF5ngXyJTI3RjHjQv9oqJ+geVRqNOc1tVYdwj8sUWrBcTvqr8cRFwBPkrwh9p9/ZD87xUDxlN32LocWGNhXymyVcizBH/TSaB3aStNmvkw2xrsUcNatUTbFzQB2bA9uFR99Ho/AnOF1OwIDAQAB";

     public static final String FruitsOAToken = "FruitsOAToken";
    /**
     * 用户登录成功后生成Jwt
     * 使用Hs256算法
     * @param exp jwt过期天数
     * @param claims 保存在Payload（有效载荷）中的内容
     * @return token字符串
     */
    public static String createJWT(int exp, Map<String, Object> claims){
        //指定签名的时候使用的签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //创建一个JwtBuilder，设置jwt的body
        JwtBuilder builder = Jwts.builder()
                //保存在Payload（有效载荷）中的内容
                .setClaims(claims)
                //iat: jwt的签发时间
                .setIssuedAt(now)
                //设置过期时间
                .setExpiration(DateUtil.getDate(now,exp))
                //设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm, SIGNING_KEY);

        return builder.compact();
    }

    /**
     * 解析token，获取到Payload（有效载荷）中的内容，包括验证签名，判断是否过期
     *
     * @param token
     * @return
     */
    public static Map<String, Object> parseJWT(String token) {
        //得到DefaultJwtParser
        Claims claims = Jwts.parser()
                //设置签名的秘钥
                .setSigningKey(SIGNING_KEY)
                //设置需要解析的token
                .parseClaimsJws(token).getBody();
        return claims;
    }


    //从cookie中获取token
    public static String getTokenByCookie(Cookie[] cookies,String tokenName) {
        if (cookies != null && cookies.length>0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(tokenName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }



}
