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
            <span>账单管理页面 >> 订单添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="${pageContext.request.contextPath}/accountServlet?method=updateById" method="post">
            <input type="hidden" name="a_id" value="${accountBean.a_id }">
              <div>
                    <label for="billName">商品名称：</label>
                    <input type="text" name="a_name" id="billName" value="${accountBean.a_name}"/>
                    <span >*请输入商品名称</span>
                </div>
                <div>
                    <label for="billNum">商品数量：</label>
                    <input type="text" name="a_nums" id="billNum" required value="${accountBean.a_nums}"/>
                    <span>*请输入大于0的正自然数，小数点后保留2位</span>
                </div>
                <div>
                    <label for="money">总金额：</label>
                    <input type="text" name="a_amount" id="money" required value="${accountBean.a_amount}"/>
                    <span>*请输入大于0的正自然数，小数点后保留2位</span>
                </div>
                    <div>
                    <label for="billCom">商品单位：</label>
                    <input type="text" name="a_unit" id="billCom" required value="${accountBean.a_unit}"/>
                    <span>*请输入商品单位</span>

                </div>
                <div>
                    <label >供应商：</label>
                    <select name="s_name">
                    <c:forEach items="${supplierList}" var="s">
                        <option value="${s.s_name}" name="s_name">${s.s_name}</option>
                     </c:forEach>
                    </select>
                    <span>*请选择供应商</span>
                </div>
                <div>
                    <label >是否付款：</label>
                    未付款
                    <input type="radio" name="a_ispayed" value="0" <c:if test="${accountBean.a_ispayed=='0'}">checked="checked"</c:if>/>
                    已付款
                    <input type="radio" name="a_ispayed" value="1" <c:if test="${accountBean.a_ispayed=='1'}">checked="checked"</c:if>/>
               	
                </div>
                 <div>
                    <label >商品描述：</label>
                    <input type="text" name="a_info" value="${accountBean.a_Info}"/>
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