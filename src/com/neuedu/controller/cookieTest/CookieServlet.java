package com.neuedu.controller.cookieTest;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*//创建cookie
        Cookie cookie = new Cookie("username","username");
        //设置cookie存储时间，默认时间单位“秒”，时间为0时没有cookie，不存储，为负数时，该cookie表示的会话已经结束
        cookie.setMaxAge(60 * 60 * 24 * 7);
        //添加cookie

        resp.addCookie(cookie);*/

        HttpSession session = req.getSession();
        //指定间隔不操作失效
        session.setMaxInactiveInterval(20);
        //直接失效
        session.invalidate();
        System.out.println(session.getId());

    }
}
