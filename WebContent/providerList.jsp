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
        <script type="text/javascript">
    	function deleteSupp() {
			 var flag = confirm("是否删除?");
			 if(flag){
				 return true;
			 }
			 return false;
			}
			function export1(){
				alert("导出成功")
			}
	</script>
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
            <span>供应商管理页面</span>
        </div>
        <div class="search">
           <form action="${pageContext.request.contextPath}/supplierServlet?method=findByName" method="post">
            <input type="text" placeholder="请输入供应商的名称" name="pname"/>
            <input type="submit" value="查询"/>
           </form>
           <a href="${pageContext.request.contextPath}/supplierServlet?method=exportTable" onclick="export1()">导出</a> 
            <a href="providerAdd.jsp">添加供应商</a>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">供应商编码</th>
                <th width="20%">供应商名称</th>
                <th width="10%">供应商描述</th>
                <th width="10%">联系人</th>
                <th width="10%">电话</th>
                <th width="20%">地址</th>
                <th width="20%">操作</th>
            </tr>
          		<c:forEach items="${supplierList}" var="sup">
	               		 <tr>
	                    <td>
	                       ${sup.s_id }
	                    </td>
	                    <td>
	                       ${sup.s_name}
	                    </td>
	                    <td>
	                       ${sup.s_info }
	                    </td>
	                    <td>
	                       ${sup.s_linkman }
	                    </td>
	                    <td>
	                       ${sup.s_phone }
	                    </td>
	                    <td>
	                       ${sup.s_address }
	                    </td>	                
	                    <td>
                    <a href="${pageContext.request.contextPath}/supplierServlet?method=toUpdate&pid=${sup.s_id}&u_auth=${user.u_auth}"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                    <a href="${pageContext.request.contextPath}/supplierServlet?method=deleteById&pid=${sup.s_id}&u_auth=${user.u_auth}" onclick="return deleteSupp()"><img src="img/schu.png" alt="删除" title="删除"/></a>
               			 </td>                   
	                </tr>
                </c:forEach>
        </table>
    </div>
</section>

<footer class="footer">
</footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>