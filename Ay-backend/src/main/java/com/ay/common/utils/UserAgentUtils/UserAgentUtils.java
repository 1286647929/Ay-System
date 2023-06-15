package com.ay.common.utils.UserAgentUtils;

import eu.bitwalker.useragentutils.UserAgent;
import jakarta.servlet.http.HttpServletRequest;


public class UserAgentUtils{
    /**
     * 获取浏览器类型
     * @param request
     * @return
     */
    public static String getBrowser(HttpServletRequest request){
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("user-agent"));
        return userAgent.getBrowser().toString();
    }

    /**
     * 获取Client type
     * @param request
     * @return
     */
    public static String getClientType(HttpServletRequest request){
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("user-agent"));
        return userAgent.getOperatingSystem().getDeviceType().toString();
    }

    /**
     * 获取操作系统
     * @param request
     * @return
     */
    public static String getOs(HttpServletRequest request){
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("user-agent"));
        return userAgent.getOperatingSystem().getName();
    }

}