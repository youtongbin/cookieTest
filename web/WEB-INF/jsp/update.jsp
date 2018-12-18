<%@ page import="com.neuedu.pojo.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 22321
  Date: 2018/12/13
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="doUpdate" method="post" enctype="multipart/form-data">
    <input type="text" hidden="hidden" name="productId" value="${product.productId}">
    <table>
        <tr>
            <td>商品名：</td>
            <td><input type="text" name="productName" value="${product.productName}"><br></td>
        </tr>
        <tr>
            <td>商品单价：</td>
            <td><input type="text" name="price" value="${product.price}"><br></td>
        </tr>
        <tr>
            <td>商品图片：</td>
            <td><input type="file" name="file"><br></td>
        </tr>
    </table>
    <input type="submit" value="修改">
</form>
</body>
</html>
