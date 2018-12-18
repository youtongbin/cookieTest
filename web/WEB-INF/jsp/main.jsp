<%@ page import="java.util.List" %>
<%@ page import="com.neuedu.pojo.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 22321
  Date: 2018/12/17
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>

    <style>
        table{
            border: 1px solid #ccc;
            border-collapse: collapse;
        }
        table thead tr th,table tbody tr td{
            border: 1px solid #cccccc;
            padding: 5px 10px;
            text-align: center;
        }
        table tbody tr:nth-child(odd){
            background-color: beige;
        }
        table tbody tr td img{
            width: 20px;
            height: 20px;
        }

    </style>

</head>
<body>
    <div>
        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
        %>

        <table>
            <thead>
                <tr>
                    <th>商品编号</th>
                    <th>商品名称</th>
                    <th>商品价格</th>
                    <th>图片</th>
                    <th>删除</th>
                    <th>修改</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${products}" var="p">
                    <tr>
                        <td>${p.productId}</td>
                        <td>${p.productName}</td>
                        <td>${p.price}</td>
                        <td><img src="${p.url}" alt="图片"></td>
                        <td><a href="delete?product_id=${p.productId}">删除</a></td>
                        <td><a href="update?product_id=${p.productId}">修改</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="add">添加</a>



        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript">
            // S(function () {
            //     $.ajax({
            //         url:"main",
            //         type:"get",
            //         dataType:"json",
            //         success:function (data) {
            //             console.log(data);
            //         }
            //     });
            // });


        </script>

    </div>
</body>
</html>
