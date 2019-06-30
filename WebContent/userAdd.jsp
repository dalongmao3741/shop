<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <p><span style="color: #fff21b"> ${user.u_name}</span> , 欢迎你！</p>
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
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
  
        <div class="providerAdd">
           <form action="${pageContext.request.contextPath}/userServlet?method=insertUser" method="post">                
                <div>
                    <label>用户名称：</label>
 					<input type="text" name="username"/>
                    <span >请输入用户名称</span>           
                <div>
                    <label>用户密码：</label>
                    <input type="password" name="password"/>
                    <span>密码长度必须大于6位小于20位</span>
                </div>
        
                <div>
                    <label >用户性别：</label>
                    <select name="gender">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                    <span></span>
                </div>
                <div>
                    <label>用户年龄：</label>
                    <input type="text" name="age"/>
                    <span >*</span>
                </div>
                <div>
                    <label >用户电话：</label>
                    <input type="text" name="phone"/>
                    <span >*</span>
                </div>
                <div>
                    <label >用户地址：</label>
                    <input type="text" name="address" />
                </div>
                <div>
                    <label >用户类别：</label>
                    <input type="radio" name="auth" value="部门经理"/>部门经理
                    <input type="radio" name="auth" value="普通用户"/>普通用户
                </div>
                <div class="providerAddBtn">
                    <input type="submit" value="保存"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
               </form>
        </div>       
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>