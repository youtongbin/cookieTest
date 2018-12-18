package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/doLogin")
public class DoLoginServlet extends HttpServlet {
    private IUserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == ""){
            //输入空
            resp.getWriter().write("3");
        }else {
            User user = userService.getOne(username);

            if(user != null){
                if (password.equals(user.getPassword())){
                    System.out.println(user);

                    //账号密码匹配，存储cookie信息
                    Cookie coo = new Cookie("username",username);
                    Cookie coop = new Cookie("password",password);
                    coo.setMaxAge(60 * 60 * 24 * 7);
                    coop.setMaxAge(60 * 60 * 24 * 7);
                    resp.addCookie(coo);
                    resp.addCookie(coop);
                    HttpSession session = req.getSession();
                    session.setAttribute("user",user);


                    resp.getWriter().write("0");
                }else {
                    resp.getWriter().write("1");
                }
            }else {
                resp.getWriter().write("2");
            }
        }


    }
}
