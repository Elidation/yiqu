<%--
  Created by IntelliJ IDEA.
  User: 36353
  Date: 2019-07-03
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>欢迎注册 — 易居住房交易平台</title>

    <%--导入CSS文件--%>
    <link type="text/css" href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" />
    <link type="text/css" href="${pageContext.request.contextPath}/css/buttonStyle.css" rel="stylesheet" />

    <%--导入JS文件--%>
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<%--    <script src="${pageContext.request.contextPath}/js/signup.js"></script>--%>

</head>
<body>
<%--加入头部--%>
<jsp:include page="../pages/basehead.jsp"></jsp:include>

<!--Logo栏和手机号栏-->
<div class="logo-phone">
    <div class="width1190">

        <table align="center" width="100%">
            <tr>
                <td>
                    <h1 class="logo"><a href="${pageContext.request.contextPath}/index.jsp">
                        <img src="${pageContext.request.contextPath}/images/logo.png" width="163" height="59" /></a></h1>
                </td>

                <td align="center">
                    <div class="phones"><strong>000-0000000</strong></div>
                    <div class="clears"></div>
                </td>

            </tr>
        </table>
    </div><!--width1190/-->
</div><!--logo-phone/-->
<!--Logo栏和手机号栏-->


<!--Logo栏和手机号栏-->

<hr width="1280px">

<!--注册-->
<div class="content">
    <div class="width1190">
        <div class="reg-logo">
            <form  method="post" action="${pageContext.request.contextPath}/user/signUp.do" class="zcform">
                <table align="center" cellpadding="100px" cellspacing="10px">
                    <tr>
                        <td align="right">
                        <label class="one" for="phone">手机号码：</label>
                        </td>
                         <td colspan="2">
                             <input id="phone" name="phone" type="text" class="required" value placeholder="该手机号将用来登录和找回密码" />
                         </td>
                 </tr>
                 <tr><td><br></td></tr>
                 <tr>
                     <td>
                         <label class="one"  for="password">登录密码：</label>
                     </td>
                     <td colspan="2">
                         <input id="password" name="password" type="password" class="{required:true,rangelength:[8,20],}" value placeholder="请输入密码" />
                     </td>
                 </tr>
                 <tr><td><br></td></tr>
                 <tr>
                     <td>
                         <label class="one" for="password2">确认密码：</label>
                     </td>
                     <td colspan="2">
                         <input id="password2" name="password2" type="password" class="{required:true,equalTo:'#password'}" value placeholder="请再次输入密码" />
                     </td>
                 </tr>
                 <tr><td><br></td></tr>
                 <tr><td><br></td></tr>
                 <tr>
                     <td colspan="3" align="center">
                         注册即同意<a  href="#">《用户使用协议》</a>&amp;<a href="#">《隐私权条款》</a>
                     </td>
                 </tr>
                 <tr><td><br></td></tr>
                 <tr>
                     <td colspan="3">
                         <input class="submit" id="submit" type="button" value="立即注册"/>
                         <%--<input class="sub-btn" type="button" value="立即注册"/>--%>
                     </td>
                 </tr>
             </table>
         </form>
         <div class="reg-logo-right">
             <h3>如果您已有账号，请</h3>
             <%--FIXME 这里修改为【登录页面】--%>
             <a href="${pageContext.request.contextPath}/pages/login.jsp" class="logo-a" target="_self">立即登录</a>
         </div><!--reg-logo-right/-->
         <div class="clears"></div>
        </div><!--reg-logo/-->
    </div><!--width1190/-->
</div><!--content/-->

<jsp:include page="basefoot.jsp"></jsp:include>
</body>

<script type="text/javascript">
    $(function () {
        $(".submit").on("click",function () {
            var phone = $("input[name=phone]").val();
            var password =$("input[name=password]").val();
            var password2 =$("input[name=password2]").val();

            alert("phone:"+phone+"password:"+password+"password2:"+password2)

            if (phone==""){
                alert("手機號碼不能為空")
                return;
            }

            if (password==""){
                alert("密碼不能為空")
                return;
            }

            if (password2==""){
                alert("確認密碼不能為空")
                return;
            }

            if (password2!=password){
                alert("密碼不一致，請重新輸入")
                return;
            }

            $.ajax({
                url: "${pageContext.request.contextPath}/user/signUp.do",
                type: "POST",
                datatype: "json",
                data:{
                    phone: phone,
                    password: password
                },
                success:function (data) {
                    alert("請求成功")
                    var dataResult=JSON.parse(data).result
                    console.log(dataResult)
                    console.log("data:"+dataResult);
                    console.log("dataType:"+typeof JSON.parse(data).result)
                    if (dataResult == "0") {
                        window.location.href="${pageContext.request.contextPath}/pages/login.jsp";
                    }else if (dataResult == "1") {
                        alert("註冊成功，前往登錄中……")
                        window.location.href="${pageContext.request.contextPath}/pages/login.jsp";
                    }else{
                        alert("請遵照規定進行註冊")
                        alert("規定如下：賬號，密碼，確認密碼不能為空，密碼與確認密碼必須一致，若賬號已被註冊，請重新更換賬號進行註冊！")
                    }
                },
                error:function (data) {
                    alert("請求失敗")
                }
            })
        })
    })
</script>

</html>



