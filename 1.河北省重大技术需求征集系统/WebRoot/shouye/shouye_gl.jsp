<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>河北省重大需求征集系统首页</title>
<link href="../css1/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js1/jquery.js"></script>

</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    </ul>
    </div>
    
    <div class="mainindex">
    
    
    <div class="welinfo">
    <% 
	session.getAttribute("existUser");
	%>
    <span><img src="../images/sun.png" alt="天气" /></span>
    <b> ${sessionScope.existUser.name} 你好，欢迎使用河北省重大技术需求征集系统</b>
    </div>
    
    <div class="welinfo">
    <%
    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd hh:mm");
    java.util.Date currentTime = new java.util.Date();//得到当前系统时间
    %>
    <span><img src="../images/time.png" alt="时间" /></span>
    <i>您本次登录的时间：<%=currentTime %></i> 
    </div>
    
    <div class="xline"></div>
    
    <ul class="iconlist">
    
    <li><img src="../images/ico01.png" /><p><a href="#">权限管理</a></p></li>
    <li><img src="../images/ico02.png" /><p><a href="../shgl/shgl_xqgl.jsp">查看需求</a></p></li>
    <li><img src="../images/ico03.png" /><p><a href="#">数据统计</a></p></li>
    <li><img src="../images/ico05.png" /><p><a href="#">帮助文件</a></p></li>
    <li><img src="../images/ico06.png" /><p><a href="#">表单查询</a></p></li> 
            
    </ul>
    
    
    <div class="xline"></div>
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="../images/dp.png" alt="提醒" /></span>
    <b>河北省重大技术需求征集系统使用指南</b>
    </div>
    
    <ul class="infolist">
    <li><span>您可以快速进行密码修改</span><a class="ibtn" href="../xgmm/xgmm.jsp?">修改密码</a></li>
    </ul>
    
    <div class="xline"></div>
    
    <div class="uimakerinfo"><b>其他相关信息</b></div>
    
    <ul class="umlist">
    <li><a href="#">系统介绍</a></li>
    <li><a href="#">帮助文件</a></li>
    <li><a href="#">常见问题解答</a></li>
    </ul>
    
    
    </div>
</body>
</html>