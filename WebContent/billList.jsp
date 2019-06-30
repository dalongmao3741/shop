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
  	function deleteBill() {
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
                <span>账单管理页面</span>
            </div>
            <div class="search">
                <form action="${pageContext.request.contextPath}/accountServlet?method=findByName" method="post">
	                <input type="text" placeholder="请输入商品的名称" name="a_name"/>
	                <span>是否付款：</span>
	                <select name="a_ispayed">
	                    <option value="">--请选择--</option>
	                    <option value="1">已付款</option>
	                    <option value="0">未付款</option>
	                </select>
	                <input type="submit" value="查询"/>
                </form>
                <a href="${pageContext.request.contextPath}/accountServlet?method=exportTable" onclick="export1()">导出</a> 
                <a href="billAdd.jsp">添加订单</a>
            </div>
            
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">账单编码</th>
                    <th width="10%">商品名称</th>
                    <th width="10%">商品数量</th>   
                    <th width="10%">账单金额</th>
                    <th width="10%">是否付款</th>
                    <th width="10%">供应商</th>
                    <th width="10%">商品描述</th>
                    <th width="10%">创建时间</th>
                    <th width="10%">操作</th>
                </tr>
                <c:forEach items="${accountList}" var="account">
	                <tr>
	                    <td>
	                       ${account.a_id}
	                    </td>
	                    <td>
	                       ${account.a_name}
	                    </td>
	                    <td>
	                       ${account.a_nums}
	                    </td>
	                    <td>
	                       ${account.a_amount}
	                    </td>
	                    <td>
	                       ${account.a_ispayed}
	                    </td>
	                    <td>
	                       ${account.s_name}
	                    </td>
	                    <td>
	                       ${account.a_Info}
	                    </td>
	                    <td>
	                    	${account.a_Date}                   
	                    </td>                    
	                    <td>
                    <a href="${pageContext.request.contextPath}/accountServlet?method=toUpdate&a_id=${account.a_id}&u_auth=${user.u_auth}"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                    <a href="${pageContext.request.contextPath}/accountServlet?method=deleteById&a_id=${account.a_id}&u_auth=${user.u_auth}" onclick="return deleteBill()"><img src="img/schu.png" alt="删除" title="删除"/></a>
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