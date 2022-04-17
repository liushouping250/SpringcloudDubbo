package com.dubbo.demo.util.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description:
 * @author: Mr.monster.liu
 * @create: 2021-08-25 17:32
 **/
@Component
@Slf4j
public class FeignAuthRequestInterceptor implements Filter {

    private Map<String,String> getHeaders(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String,String> headerMap = new LinkedHashMap<>();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String values = request.getHeader(name);
                headerMap.put(name,values);
            }
        }
        return headerMap;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Map<String, String> headers = getHeaders();
        for (String header: headers.keySet()) {
            log.info(header+"===="+headers.get(header));
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
