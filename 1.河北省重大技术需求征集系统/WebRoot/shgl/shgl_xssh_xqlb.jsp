<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>形式审核需求列表</title>
<link href="../css1/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js1/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>

</head>
<body>

    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>形式审核</li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="../images/t01.png" /></span>添加</li>
        <li class="click"><span><img src="../images/t02.png" /></span>修改</li>
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="../images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
            <th>序列</th>
            <th>机构编码</th>
	        <th>机构名称</th>
	        <th>需求编号</th>
	        <th>需求名称</th>
	        <th>关键字</th>
	        <th>拟投资金额</th>
	        <th>审核状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
		    <%
		    int x=1;
		    %>
		    <s:iterator value="#session.listC" status="status">  
    	<tr>  
    	<td><%=x++ %></td>
        <td><s:property value="name"/></td>  
        <td><s:property value="techName"/></td>    
        <td><s:property value="keyword"/></td>  
        <td><s:property value="moneyInvestment"/></td>  
        <td><s:property value="solution"/></td>  
        <td><s:property value="actionType"/></td>  
        <td><s:property value="state"/></td>  
        <td><a href='../shgl/shgl_xssh_xqbd.jsp'>审核</a></td>
   	 	</tr>  
		</s:iterator>
	    </tr> 
               
        </tbody>
    </table>
    
    <div class="pagin">
    	<div class="message">共<i class="blue"><%=x-1%></i>条记录</div>
    </div>
    
    </div>
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>
</html>