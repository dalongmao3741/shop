<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span style="color: #fff21b">${user.u_name}</span> , 欢迎你！</p>
        <a href="login.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                 <li ><a href="${pageContext.request.contextPath}/accountServlet?method=list">账单管理</a></li>
                <li><a href="${pageContext.request.contextPath}/supplierServlet?method=list">供应商管理</a></li>
                <li><a href="${pageContext.request.contextPath}/userServlet?method=list">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/tableServlet?method=listBySupp">报表管理</a></li>
                <li><a href="${pageContext.request.contextPath}/userServlet?method=logout">退出系统</a></li>           
                 </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>用户编号：</strong><span>${sessionScope.userBean.u_id }</span></p>
            <p><strong>用户名称：</strong><span>${sessionScope.userBean.u_name }</span></p>
            <p><strong>用户性别：</strong><span>${sessionScope.userBean.u_gender }</span></p>
            <p><strong>用户年龄：</strong><span>${sessionScope.userBean.u_age }</span></p>
            <p><strong>用户电话：</strong><span>${sessionScope.userBean.u_phone }</span></p>
            <p><strong>用户地址：</strong><span>${sessionScope.userBean.u_address }</span></p>
            <p><strong>用户类别：</strong><span>${sessionScope.userBean.u_auth }</span></p>

            <a href="userList.jsp">返回</a>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>