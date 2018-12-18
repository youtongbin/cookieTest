<%--
  Created by IntelliJ IDEA.
  User: 22321
  Date: 2018/12/13
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
    <form action="doAdd" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>商品名：</td>
                <td><input type="text" name="productName"><br></td>
            </tr>
            <tr>
                <td>商品单价：</td>
                <td><input type="text" name="price"><br></td>
            </tr>
            <tr>
                <td>商品图片：</td>
                <td><input type="file" name="file"><br></td>
            </tr>
        </table>

        <input type="submit" value="添加">
    </form>

</body>
</html>
