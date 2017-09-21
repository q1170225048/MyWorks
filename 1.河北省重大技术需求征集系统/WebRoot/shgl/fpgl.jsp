<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
/*按钮美化*/
.demo_con{
width: 960px;
margin:40px auto 0;
}
.button{
width: 70px;
line-height: 21px;
text-align: center;
font-weight: bold;
color: #fff;
text-shadow:1px 1px 1px #333;
border-radius: 5px;
margin:0 20px 20px 0;
position: relative;
overflow: hidden;
}
.button:nth-child(6n){
margin-right: 0;
}
.button.blue{
border:1px solid #1e7db9;
box-shadow: 0 1px 2px #8fcaee inset,0 -1px 0 #497897 inset,0 -2px 3px #8fcaee inset;
background: -webkit-linear-gradient(top,#42a4e0,#2e88c0);
background: -moz-linear-gradient(top,#42a4e0,#2e88c0);
background: linear-gradient(top,#42a4e0,#2e88c0);
}
</style>
<title>分配管理部门</title>
</head>
<body>
<center>
<form method="post" action="fpgl_panduan.jsp">
  <p><strong>分配管理部门</strong> </p>
  <table width="279" border="0">
    <tbody>
    
      <tr>
        <td width="96">机构编码：</td>
        <td width="173"><input name="no" id="jgbm" value="" readOnly="true"></td>
      </tr>
      <tr>
        <td>需求编码：</td>
        <td><input name="tech" id="xqbm" value="" readOnly="true"></td>
      </tr>
      <tr>
        <td>管理部门：</td>
        <td><select name="xzglbm" id="xzglbm"  required>
            
            <option value=''></option>
           
            </select>
      </tr>
    </tbody>
</table>
  <p><div class="demo_con">
    <input type="hidden" name="no" id="no" value="">
	<input type="hidden" name="tech" value="">
    <input type="Submit"  class="button blue" name="submit" value="确认">
    <input type="Submit"  class="button blue" name="submit" value="返回">
    </div>	
  </p>
</form>
</center>

</body>
</html>