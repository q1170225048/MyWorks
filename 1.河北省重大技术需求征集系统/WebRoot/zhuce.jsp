<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<style type="text/css">
html,body,div,li,form,input,th,td{margin:0;padding:0;font-family:楷体; font-size:100%;}
ul,ol,li{ list-style:none;}
a:link, a:visited{ color:#FF00FF; text-decoration:none;}
a:hover{ color:#12b7f5;}

table {
	border-collapse: collapse;
	border: none;
	margin: 0px auto;
	width: 500px;
}

th, td {
	border: Groove #000000 0px;
	height: 20px;
	margin-bottom: 12px; line-height: 25px;  opacity: 0.6;
}

div {
	text-align: center;
}
</style>
<script src="js/jquery-1.4.js"></script>   
<script type="text/javascript">  
function checkUserName(){  
var no=$("#no").val();  
         $.ajax({  
             type: "GET",  
             url: "userJSONAction_checkUserName.action",  
             data: {no:no},  
             dataType: "json",  
             success: function(data){ 
             alert(data); 
             $("#nameMes").html("");  
             $("#nameMes").text(data);  
             }  
             });  
}  
</script>  
</head>
<body>
	<form action="regist.action" method="post">
	<center>
	<br>
	<h1>用户信息注册</h1>
	<table>
		<tr>
			<th width="20%" align="right"><font color="red">*</font>机构编码:</th>
			<td colspan =3><input id="no" name="no" style="width:99%;height:90%" onblur="checkUserName()"></td>
		</tr>
		<tr>
			<th width="20%" align="right"><font color="red">*</font>密码:</th>
			<td colspan =3><input name="pwd" style="width:99%;height:90%"></td>
		</tr>
		<tr>
			<th width="20%" align="right"><font color="red">*</font>机构名称:</th>
			<td colspan =3><input name="name" style="width:99%;height:90%"></td>
		</tr>
		<tr>
			<th width="20%" align="right"><font color="red">*</font>通讯地址:</th>
			<td width="60%" colspan=3><input name="address" style="width:99%;height:90%"></td>
		</tr>
		<tr>
			<th width="20%" align="right">单位网址:</th>
			<td colspan=3><input name="url" style="width:99%;height:90%"></td>
		</tr>
		<tr>
			<th width="20%" align="right"><font color="red">*</font>电子邮箱:</th>
			<td colspan=3><input name="email" style="width:99%;height:90%"></td>
		</tr>
		<tr>
			<th align="right"><font color="red">*</font>法人代表:</th>
			<td colspan=3><input name="fr" style="width:99%;height:90%"></td>
		</tr>
		<tr>
			<th align="right">邮政编码:</th>
			<td colspan=3><input name="pcode" style="width:99%;height:90%"></td>
		</tr>
		<tr>
			<th align="right"><font color="red">*</font>联系人:</th>
			<td colspan=3><input name="contact" style="width:99%;height:90%"></td>
		<tr>
			<th align="right"><font color="red">*</font>电话:</th>
			<td colspan=3><input name="phone" style="width:99%;height:90%"></td>
		</tr>
		<tr>
			<th align="right">传真:</th>
			<td colspan=3><input name="cz" style="width:99%;height:90%"></td>
		</tr>
		<tr>
			<th align="right">归口管理部门:</th>
			<td colspan=3><input name="belong" style="width:99%;height:90%"></td>
		</tr>
		<tr>
			<th align="right" colspan =4><font color="red">*</font>为必填项</th>
		</tr>
		<tr>
				<th colspan="2"><input type="submit" name="submit" value="注册">
				          <input type="reset" value="重置"></th>
		</tr>
	</table>
	
	</center>
	</form>
</body>
</html>