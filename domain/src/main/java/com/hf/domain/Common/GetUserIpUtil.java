package com.hf.domain.Common;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class GetUserIpUtil {

    private static final String[] PROXYS = {"x-forwarded-for", "Proxy-Client-IP", "WL-Proxy-Client-IP", "X-Real-IP", "HTTP_CLIENT_IP"};

    /**
     * 获取客户端ip
     */
    public static String getIpAddr(HttpServletRequest request) {

            String Xip = request.getHeader("X-Real-IP");
            String XFor = request.getHeader("X-Forwarded-For");
            if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
                //多次反向代理后会有多个ip值，第一个ip才是真实ip
                int index = XFor.indexOf(",");
                if(index != -1){
                    return XFor.substring(0,index);
                }else{
                    return XFor;
                }
            }
            XFor = Xip;
            if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
                return XFor;
            }
            if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
                XFor = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
                XFor = request.getHeader("WL-Proxy-Client-IP");
            }
            if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
                XFor = request.getHeader("HTTP_CLIENT_IP");
            }
            if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
                XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
                XFor = request.getRemoteAddr();
            }
            return XFor;
        }

}
