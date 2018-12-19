<%--
  Created by IntelliJ IDEA.
  User: 22321
  Date: 2018/12/17
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>

    <style>
        #message{
            color: red;
        }
    </style>

</head>
<body>
    <div>
        <form id="form">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="username"><br></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password"><br></td>
                    <td id="message"></td>
                </tr>
                <tr>
                    <td><input type="button" id="btn1" value="登录"></td>
                </tr>
            </table>

            <a href="${path}/register">前往注册</a>
        </form>

        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script>
            $(function () {
                $("#btn1").click(function () {
                    var user =  $("#form").serialize();
                    $.ajax({
                        url:"${path}/doLogin",
                        type:"post",
                        data:user,
                        success:function (result) {
                            if (result == "0"){
                                window.location.href="${path}/main";
                            } else if (result == "1"){
                                $("#message").text("密码错误！");
                            } else if (result == "2"){
                                alert("没有此用户，请前往注册！");
                            }else if (result == "3"){
                                alert("用户名不能为空！");
                            }
                        }
                    });
                });

            });

        </script>

    </div>

</body>
</html>
