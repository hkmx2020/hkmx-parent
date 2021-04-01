package com.hkmx.common.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @author maoxwa
 * @version 1.0
 * @date 2021/3/23 9:38
 */
@WebFilter(urlPatterns = "/*", filterName = "myFilter")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        final Map<String, String[]> parameterMap = request.getParameterMap();

        RequestWrapper requestWrapper = new RequestWrapper(request);

        String body = requestWrapper.getBody();
        body = StringUtils.replace(body, "\n", "");
        body = StringUtils.replace(body, "\t", "");
        body = StringUtils.replace(body, "\r", "");
        System.out.println(body);

        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
