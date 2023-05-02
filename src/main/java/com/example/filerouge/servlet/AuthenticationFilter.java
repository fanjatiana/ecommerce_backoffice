//package com.example.filerouge.servlet;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//@WebFilter(urlPatterns = "/auth/*")
//public class AuthenticationFilter extends HttpFilter {
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//
//        String uri = req.getRequestURI();
//
//        HttpSession session = req.getSession(false);
//
//        if (session == null || session.getAttribute("username") == null) {
//            res.sendRedirect(req.getContextPath() + "/login");
//        } else {
//            String userRole = (String) session.getAttribute("role");
//            if (userRole.equals("superadmin")) {
//                // Super admin has access to all pages
//                chain.doFilter(request, response);
//            } else if (userRole.equals("admin")) {
//                // Admin has access to all pages except UserlistServlet and UpdateUserServlet
//                if (uri.contains("userlist") || uri.contains("/update-category")) {
//                    res.sendRedirect(req.getContextPath() + "/error.jsp");
//                } else {
//                    chain.doFilter(request, response);
//                }
//            } else {
//                // Client does not have access to any page
//                res.sendRedirect(req.getContextPath() + "/error.jsp");
//            }
//        }
//    }
//}
