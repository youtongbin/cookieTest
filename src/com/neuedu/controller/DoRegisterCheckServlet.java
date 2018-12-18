package com.neuedu.controller;

import com.neuedu.service.IUserService;
import com.neuedu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doRegisterCheck")
public class DoRegisterCheckServlet extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        String password = req.getParameter("password");
        String passwords = req.getParameter("passwords");
        String tele = req.getParameter("tele");

        if (username != ""){
            //获取数据库信息为空时，可以进行注册
            if (userService.getOne(username) == null){

                if (password != "" || passwords != ""){
                    if (password.equals(passwords)){
                        //验证通过
                        System.out.println("username=" + username +" password=" + password +" passwords="+passwords + " tele="+ tele);
                        resp.getWriter().write("0");
                    }else {
                        //密码验证错误
                        resp.getWriter().write("3");
                    }
                }else {
                    //用户名可用
                    resp.getWriter().write("4");
                }
            }else{
                //用户已存在
                resp.getWriter().write("2");
            }
        }else {
            //输入username为空
            resp.getWriter().write("1");
        }

    }
}
