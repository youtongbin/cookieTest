package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import com.neuedu.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig
@WebServlet("/doUpdate")
public class DoUpdateServlet extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        String productName = req.getParameter("productName");
        double price = Double.parseDouble(req.getParameter("price"));

        //图片上传
        Part part = req.getPart("file");
        String str = "C:\\gitHub\\cookieTest\\web\\img\\" + part.getSubmittedFileName();
        String url = str.substring(str.indexOf("img"));
        File file = new File(str);
        InputStream is = part.getInputStream();
        OutputStream os = new FileOutputStream(file);
        byte[] b = new byte[1024];
        int a = is.read(b,0,b.length);
        while(a != -1){
            os.write(b);
            a = is.read(b,0,b.length);
        }

        Product p = new Product(productId,productName,price,url);
        productService.update(p);
        System.out.println("update_id = " + productId);
        resp.sendRedirect("main");
    }
}
