<%--
  Created by IntelliJ IDEA.
  User: 36353
  Date: 2019-07-04
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>个人中心</title>
    <%--导入CSS文件--%>
    <link type="text/css" href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet"/>
    <%--<link rel="stylesheet" type="text/css" href="../css/city-select.css">--%>

    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>

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
                    <h1 class="logo"><a href="../index.jsp"><img src="../images/logo.png" width="163" height="59"/></a>
                    </h1>
                </td>
                <td align="center">
                    <div class="phones"><strong>000-00000000</strong></div>
                    <div class="clears"></div>
                </td>

            </tr>
        </table>
    </div><!--width1190/-->
</div><!--logo-phone/-->
<!--Logo栏和手机号栏-->

<hr width="1190px">
<br>

<%--个人信息--%>

<!--个人信息-->


<div class="content">
    <div class="width1080">
        <%--左侧导航栏--%>
            <div class="vip-left">
                <div class="vipNav">
                    <h3 class="vipTitle">账户中心</h3>
                    <dl>
                        <dt class="vipIcon3">账户设置</dt>
                        <dd>
                            <a href="${pageContext.request.contextPath}/pages/personal.jsp" class="vipNavCur">我的资料</a>
                            <a href="${pageContext.request.contextPath}/pages/verify.jsp">实名认证</a>
                            <a href="${pageContext.request.contextPath}/pages/psdsetting.jsp">账户密码设置</a>
                        </dd>
                        <dt class="vipIcon1">我的易居</dt>
                        <dd>
                            <a href="${pageContext.request.contextPath}/user/favorite.do">我的收藏房源</a>
                        </dd>
                    </dl>
                </div><!--vipNav/-->
            </div><!--vip-left/-->


        <div class="vip-right">
            <h3 class="vipright-title">编辑资料</h3>
            <table class="grinfo">
                <tbody>

                <tr>
                    <th><span class="red">*</span>手机号码：</th>
                    <td width="600px">
                        <input class="inp inw" type="text" id="phone" name="phone" value="${user.phone}" maxlength="14"
                               disabled="disabled">
                    </td>
                </tr>
                <tr>
                    <th><span class="red">*</span>真实姓名：</th>
                    <td>
                        <input class="inp inw" type="text" id="name" name="truename"
                               value="${user.truename}"
                               maxlength="14">
                    </td>
                </tr>
                <tr>
                    <th><span class="red">*</span>昵　　称：</th>
                    <td>
                        <input class="inp inw" type="text" id="title" name="nickname"
                               value="${user.nickname}"
                               maxlength="14">
                    </td>
                </tr>
                <tr>
                    <th height="40px"><span class="red">*</span>性　　别：</th>
                    <td height="40px">
                        <input type="radio" value="0" id="rbSex1"
                               name="sex" >
                        <label for="rbSex1">男　　　　　　　　</label>
                        <input type="radio" value="1" id="rbSex2"
                               name="sex" >
                        <label for="rbSex2">女</label>
                        <span id="Sex_Tip"></span>
                    </td>
                </tr>
                <tr>
                    <th><span class="red">*</span>城　　市：</th>
                    <td>
                        <input class="inp inw" type="text" name="city" id="city"
                               value="${user.city}">
                    </td>
                </tr>
                <tr>
                    <th>&nbsp;</th>
                    <td colspan="2">
                        <label class="butt" id="butt">
                            <input type="button" class="member_mod_buttom" id="member_mod_buttom"
                                   name="member_mod_buttom" onclick="a()" value="保存修改"/>
                            <a>　　</a>
                            <input type="button" class="member_mod_buttom2"
                                   onclick="location.href='${pageContext.request.contextPath}/pages/personal.jsp'" name="" value="取消修改"/>
                        </label>
                    </td>
                </tr>
                </tbody>
            </table>
        </div><!--vip-right/-->
        <div class="clearfix"></div>
    </div><!--width1190/-->
</div><!--content/-->
<!--End  个人信息填写栏>-->

<div>
    <br>
    <br>
    <br>
    <br>
</div>

<script src="${pageContext.request.contextPath}/js/city/jquery1.8.1.js" type="text/javascript"></script>
<%--<script type="text/javascript" src="../js/city/citydata.min.js"></script>--%>
<%--<script type="text/javascript" src="../js/city/citySelect-1.0.3.js"></script>--%>
<script type="text/javascript">
    var gender=${user.gender};
    console.log(gender);
    if (gender==0){
        $("#rbSex1").attr("checked","checked");
    }else if (gender==1){
        $("#rbSex2").attr("checked","checked");
    }else{
        console.log("数据库出错")
    }

    function a(){
        var truename=$("input[name=truename]").val();
        var nickname=$("input[name=nickname]").val();
        var city=$("input[name=city]").val();
        var phone=$("input[name=phone]").val();
        var sex=$("input:radio[id=rbSex1]:checked").val();
        if (sex!=null){
            var gender= "0";
        }else{
            var gender= "1";
        }
        location.href="${pageContext.request.contextPath}/user/updUserInfo.do?phone="+phone+"&truename="+truename+"&nickname="+nickname+"&gender="+gender+"&city="+city;
    }
</script>


<!--这是页脚-->
<jsp:include page="../pages/basefoot.jsp"></jsp:include>


</body>
</html>
