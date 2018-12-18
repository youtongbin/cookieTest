package com.neuedu.controller;

import myTools.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/exit")
public class ExitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Map<String,Cookie> map = CookieUtil.getCookie(cookies);
        Cookie cookie = new Cookie("username","");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        req.getSession().invalidate();
        resp.sendRedirect("login");
    }
}
