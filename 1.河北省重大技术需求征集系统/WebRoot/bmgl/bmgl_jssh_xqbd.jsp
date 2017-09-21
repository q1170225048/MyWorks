<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>技术需求审核</title>
<style type="text/css">
html,body,div,li,form,input,th,td{font-family:楷体; font-size:100%;}
ul,ol,li{ list-style:none;}

table {
	border-collapse: collapse;
	border: none;
	margin: 0px auto;
	width: 100%;
}

th, td {
	border: Groove #000000 1px;
	height: 20px;
	margin-bottom: 12px; line-height: 25px;  opacity: 1.0;
}

div{
	text-align: center;
}
</style>
</head>
<body>
    
	
	<center>
	<h1>技术需求审核</h1>
	</center>
	<form action="bmgl_jssh_panduan.jsp" method="post">
	<table>
		<tr>
			<th width="15%">机构名称</th>
			<td width="40%" align="center"><%="${sessionScope.existUser.name}"%></td>
			<th width="15%">机构编码</th>
			<td width="30%" align="center"><%="${sessionScope.existUser.no}"%></td>
		</tr>
		
		<tr>
		    <th width="15%">技术需求名称</th>
			<td width="40%" align="center"><%="${sessionScope.existUser.name}"%></td>
			<th width="15%">需求编码</th>
			<td width="30%" align="center"><%="${sessionScope.existUser.name}"%></td>
		</tr>

		<tr>
		    <th colspan=4>技术需求概述</th>
		</tr>
		
		<tr>
		    <th width="15%">主要问题</th>
			<td width="85%" colspan=3><%="${sessionScope.existUser.name}"%></td>
		</tr>
		
		<tr>
		    <th width="15%">技术关键</th>
			<td width="85%" colspan=3><%="${sessionScope.existUser.name}"%></td>
		</tr>
		
		<tr>
		    <th width="15%">预期目标</th>
			<td width="85%" colspan=3><%="${sessionScope.existUser.name}"%></td>
		</tr>
	</table>
	<table>
		<tr>
		    <th width="15%">开始年限</th>
			<td width="35%" align="center"><%="${sessionScope.existUser.name}"%></td>
			<th width="15%">结束年限</th>
			<td width="35%" align="center"><%="${sessionScope.existUser.name}"%></td>
		</tr>
		
		<tr>
		    <th width="15%">关键字</th>
			<td width="35%" align="center"><%="${sessionScope.existUser.name}"%></td>
		    <th width="15%">拟投资金额</th>
			<td width="35%" align="center"><%="${sessionScope.existUser.name}"%>万元</td>
		</tr>
		
		<tr>
		    <th width="15%">技术需求解决方式</th>
			<td width="35%" align="center"><%="${sessionScope.existUser.name}"%></td>
		    <th width="15%">合作意向单位</th>
			<td width="35%" align="center"><%="${sessionScope.existUser.name}"%></td>
		</tr>
		
		<tr>
		    <th width="15%">科技活动类型</th>
			<td width="85%" colspan=3><%="${sessionScope.existUser.name}"%></td>
		</tr>
		
		<tr>
		    <th width="15%">学科分类</th>
			<td width="85%" colspan=3><%="${sessionScope.existUser.name}"%></td>
		</tr>
		
		<tr>
		    <th width="15%">需求技术领域</th>
			<td width="85%" colspan=3><%="${sessionScope.existUser.name}"%></td>
		</tr>
		
		<tr>
		    <th width="15%">应用行业</th>
			<td width="85%" colspan=3><%="${sessionScope.existUser.name}"%></td>
		</tr>	
	</table><br><br>
	    <center>
	        <input type="hidden" name="no" value="<%="${sessionScope.existUser.no}"%>">
	        <input type="hidden" name="tech" value="<%="${sessionScope.existUser.name}"%>">
	        <input type="submit" name="submit" value="同意" style="width:80px;height:30px;margin-right:30px;">
	        <input type="submit" name="submit" value="不同意" style="width:80px;height:30px">
	    </center>
    </form>
</body>
</html>