package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.pojo.User;
import com.neuedu.service.IProductService;
import com.neuedu.service.IUserService;
import com.neuedu.service.ProductServiceImpl;
import com.neuedu.service.UserServiceImpl;
import myTools.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImpl();
    IUserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getProducts();
        req.setAttribute("products",products);

        Cookie[] cookies = req.getCookies();
        Map<String,Cookie> map = CookieUtil.getCookie(cookies);
        Cookie coo = map.get("username");
        String username = coo.getValue();
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        if (user == null){
            User user1 = userService.getOne(username);
            session.setAttribute("user",user1);
            req.getRequestDispatcher("WEB-INF/jsp/main.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("WEB-INF/jsp/main.jsp").forward(req,resp);
        }




//        String prosJson = JSONObject.toJSONString(products);
//        resp.getWriter().write(prosJson);


//        req.setAttribute("products",products);
//        req.getRequestDispatcher("WEB-INF/jsp/main.jsp").forward(req,resp);
    }

}
