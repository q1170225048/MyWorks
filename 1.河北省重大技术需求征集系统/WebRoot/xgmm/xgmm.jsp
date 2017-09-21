<%@ page import="java.sql.*,entity.*" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改密码</title>
<style type="text/css">
html,body,div,li,form,input,th,td{margin:0;padding:0;font-family:楷体; font-size:100%;}
table {
	border-collapse: collapse;
	border: none;
	margin:50px auto;
	width: 400px;
}
th, td {
	border: Groove #4FF 3px;
	height: 20px;
}
div {
	text-align: center;
}
</style>
<script>
	function a()
	{
		var a = document.getElementById("p1").value;
		var b = document.getElementById("p2").value;
		if(a!=b)
		{
			alert("旧密码错误！");
			document.getElementById("p2").focus();
		}
	}
	function b()
	{
		var a = document.getElementById("p3").value;
		var b = document.getElementById("p4").value;
		if(a!=b)
		{
			alert("确认密码不一致！");
			document.getElementById("p4").focus();
		}
	}
</script>
<script type="text/javascript" >
 var msg="${requestScope.tipMessage}";  
if(msg!=""){
alert(msg);
}

</script>
</head>
<body>
	<%
		Info a=(Info)session.getAttribute("existUser");
	 %>
	<form action="passChange.action" method="post">
		<table >
			
			<tr>
				<th width="30%">旧密码：</th>
				
				<td width="70%">
				<input type="hidden" id="p1"value="<%=a.getPwd()%>">
				<input name="old"id="p2" type="password" onblur="a();">
				</td>
			</tr>
			<tr>
				<th>新密码：</th>
				<td><input name="pwd" id="p3" type="password"></td>
			</tr>
			<tr>
				<th>确认密码：</th>
				<td><input name="con" id="p4" type="password" onblur="b();"
					></td>
			</tr>
			<tr>
				<th colspan="2"><input type="hidden" name="no" value="<%=a.getNo()%>">
					<input type="submit" value="修改" name="submit"> <input type="reset"
					value="重置"></th>
			</tr>
		</table>
	</form>
</body>
</html>