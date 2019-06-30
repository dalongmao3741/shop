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
            <span>供应商管理页面 >> 供应商修改页</span>
        </div>
        <div class="providerAdd">
            <form action="${pageContext.request.contextPath}/supplierServlet?method=updateById" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
				<input type="hidden" name="s_id" value="${supplier.s_id}">
                <div>
                    <label for="providerName">供应商名称：</label>
                    <input type="text" name="s_name" id="providerName" value="${supplier.s_name }"/>
                </div>
                <div>
                    <label for="people">供应商描述：</label>
                    <input type="text" name="s_info" id="people" value="${supplier.s_info }"/>

                </div>
                <div>
                    <label for="phone">联系人：</label>
                    <input type="text" name="s_linkman" id="phone" value="${supplier.s_linkman }"/>
                </div>
                <div>
                    <label for="address">联系电话：</label>
                    <input type="text" name="s_phone" id="address" value="${supplier.s_phone }"/>
                    <span></span>
                </div>
                          <div>
                    <label for="fax">联系地址：</label>
                    <input type="text" name="s_address" id="fax" value="${supplier.s_address }"/>
                    <span></span>
                </div>
                 <div>
                    <label for="describe">传真：</label>
                    <input type="text" name="s_faxes" id="describe" value="${supplier.s_faxes }"/>
                </div>  
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="providerList.html">返回</a>-->
                    <input type="submit" value="保存" />
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