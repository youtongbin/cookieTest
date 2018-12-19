package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import com.neuedu.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = productService.getProducts();
        req.setAttribute("list",list);

        req.getRequestDispatcher("WEB-INF/jsp/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = null;
//        req.setCharacterEncoding("utf-8");
        String key = req.getParameter("key");
        System.out.println(key);

        if (key.matches("[ ]*")){
            list = productService.getProducts();
        }else {
            list = productService.getFuzzyQuery(key);
        }
        req.setAttribute("list",list);
        req.getRequestDispatcher("WEB-INF/jsp/list.jsp").forward(req,resp);
    }
}
