<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>二维码</title>
    <script src="js/jquery.min.js"></script>
    <script>
    	$(function(){
    		$("input[type=submit]").click(function(e){
    			e.preventDefault();
    			$("#qrcode_div").append("<img id='qrImg' />");
    			$("#qrImg").attr("src", "qrcode?website="+$("input[type=text][name=website]").val());
    		});
    	});
    </script>
  </head>
  
  <body>
    <form>
    	网址<input type="text" name="website" value="http://"/>
    	<input type="submit" value="生成二维码" />
    	<div id="qrcode_div"></div>
    </form>
  </body>
</html>
