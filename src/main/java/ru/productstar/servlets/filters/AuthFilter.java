package ru.productstar.servlets.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(description = "Verify authorized",
        urlPatterns = { "/expenses/add", "/summary", "/details", "/incomes/add" })
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        var session = request.getSession(false);
        if (session == null) {
            throw new ServletException("Not authorized! Вы не авторизованы!");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
