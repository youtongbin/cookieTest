<%--
  Created by IntelliJ IDEA.
  User: 22321
  Date: 2018/12/19
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/Path.jsp"%>
<html>
<head>
    <title>搜索商品</title>

    <style type="text/css">
        table{
            border: 1px solid #cccccc;
            border-collapse: collapse;
        }
        th,td{
            padding: 5px 10px;
            text-align: center;
            border: 1px solid #cccccc;
        }
        tbody tr:nth-child(odd){
            background-color: beige;
        }

    </style>

</head>
<body>
    <form method="post">
        <input type="text" name="key">
        <input type="submit" value="搜索"><br><br>
        <table>
            <thead>
                <tr>
                    <th>商品编号</th>
                    <th>商品名称</th>
                    <th>商品价格</th>
                    <th>图片</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="p">
                    <tr>
                        <td>${p.productId}</td>
                        <td>${p.productName}</td>
                        <td>${p.price}</td>
                        <td><img src="${p.url}" alt="图片" width="20" height="20"></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
</body>
</html>
