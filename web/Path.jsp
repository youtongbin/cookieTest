<%--
  Created by IntelliJ IDEA.
  User: 22321
  Date: 2018/12/19
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //获取协议
    request.getScheme();
    //获取域名
    request.getServerName();
    //获取端口
    request.getServerPort();
    //获取项目名
    request.getContextPath();
    //获取请求
    request.getServletPath();

    System.out.println(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath());
    String path = "";
    if (request.getServerPort() == 80){
        path = request.getScheme() + "://" + request.getServerName() + request.getContextPath();
    }else {
        path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
    pageContext.setAttribute("path",path);


%>

