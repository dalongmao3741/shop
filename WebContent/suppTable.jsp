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
                <span>报表管理页面</span>
            </div>
            <div class="search">
               <a href="table.jsp">商品分组查询</a>
               <a href="suppTable.jsp">供应商分组查询</a>
            </div>
            
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="20%">供应商编号</th>
                    <th width="20%">供应商名称</th>
                    <th width="20%">总交易金额</th>   
                    <th width="20%">商品种类</th>
                    <th width="20%">总商品数量</th>
                   
                </tr>
                <c:forEach items="${list}" var="list">
	                <tr>
	                    <td>
	                       ${list.s_id}
	                    </td>
	                    <td>
	                       ${list.s_name}
	                    </td>
	                    <td>
	                       ${list.price}
	                    </td>
	                    <td>
	                       ${list.a_unit}
	                    </td>
	                    <td>
	                       ${list.a_nums}
	                    </td>
	                    </c:forEach>                               	                    
	                </tr>
            </table>
        </div>
    </section>
    <footer class="footer">
    </footer>
<script src="js/time.js"></script>

</body>
</html>