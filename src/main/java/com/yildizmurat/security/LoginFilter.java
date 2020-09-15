package com.yildizmurat.security;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(filterName = "LoginFilter")
@Component
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        String driverId=(String)request.getSession().getAttribute("driverId");
        String ownerId=(String)request.getSession().getAttribute("ownerId");

        if(request.getRequestURI().contains("driverLogin") || request.getRequestURI().contains("ownerLogin"))
        {
            chain.doFilter(req, resp);
            return;
        }
        if(request.getRequestURI().contains("driverPage") || request.getRequestURI().contains("driverSettings")){
            if(driverId!=null ){
                chain.doFilter(req, resp);
                return;
            }
            else{
                response.sendRedirect("driverLogin");
            }
        }

        if(request.getRequestURI().contains("ownerPage") || request.getRequestURI().contains("ownerSettings")){
            if(ownerId!=null ){
                chain.doFilter(req, resp);
                return;
            }
            else{
                response.sendRedirect("ownerLogin");
            }
        }


        chain.doFilter(req, resp);


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
