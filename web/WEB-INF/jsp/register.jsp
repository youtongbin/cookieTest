<%--
  Created by IntelliJ IDEA.
  User: 22321
  Date: 2018/12/17
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/Path.jsp"%>
<html>
<head>

    <style>
        #message1,#message2{
            color: red;
        }
    </style>

    <title>注册</title>
</head>
<body>
    <form>
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username" id="username" class="check" placeholder="输入用户名"></td>
                <td id="message1"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password" id="password" placeholder="输入密码"></td>
            </tr>
            <tr>
                <td>确认密码：</td>
                <td><input type="password" name="passwords" id="passwords" class="check" placeholder="再次输入密码"></td>
                <td id="message2"></td>
            </tr>
            <tr>
                <td>手机号码：</td>
                <td><input type="text" name="tele" id="tele" class="check"><br></td>
            </tr>
        </table>

        <input type="button" value="注册" id="btn1" disabled="disabled">
    </form>

    <script type="text/javascript" src="${path}/js/jquery-3.3.1.min.js"></script>
    <script>
        $(function (){
            var username;
            var password;
            var passwords;
            var tele;
            $(".check").blur(function () {
                username = $("#username").val();
                password = $("#password").val();
                passwords = $("#passwords").val();
                tele = $("#tele").val();

                $.ajax({
                    url:"${path}/doRegisterCheck",
                    type:"post",
                    data:{"username":username,"password":password,"passwords":passwords,"tele":tele},
                    success:function(result){
                        if (result == "0"){
                            $("#message1").text("√");
                            $("#message2").text("√");
                            $("#btn1").removeAttr("disabled");
                        }else if (result == "1"){
                            $("#message1").text("用户名不能为空");
                            $("#message2").text("");
                        }else if(result == "2"){
                            $("#message1").text("用户名已存在");
                            $("#message2").text("");
                        }else if (result == "3"){
                            $("#message1").text("");
                            $("#message2").text("密码为空或验证错误");
                        }else if (result == "4"){
                            $("#message1").text("√");
                        }
                    }//回调函数,成功时的结果
                });
            });

            $("#btn1").click(function () {
                $.ajax({
                    url:"${path}/doRegister",
                    type:"post",
                    data:{"username":username,"password":password,"passwords":passwords,"tele":tele},
                    success:function (result) {
                        if (result == "1"){
                            alert("注册成功");
                            window.location.href="${path}/login";
                        }
                    }
                });
            });


        });
    </script>

</body>
</html>
