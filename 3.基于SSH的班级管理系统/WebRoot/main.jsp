<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <base href="<%=basePath%>">
    
    <title>主页面</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- UIcss路径信息 -->
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="./css/layui.css"  media="all">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <!-- 头标题 -->
      <ul class="layui-nav" lay-filter="">
          <li class="layui-nav-item"><a href="">班级管理平台</a></li>
      </ul>
 
      <ul class="layui-nav layui-nav-tree layui-nav-side" lay-filter="demo">
          <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;">班级管理</a>
              <dl class="layui-nav-child">
                  <dd><a href="javascript:;">班级查询</a></dd>
                  <dd><a href="javascript:;">新建班级</a></dd>
                  <dd><a href="javascript:;">班级修改</a></dd>
                  <dd><a href="javascript:;">班级移除</a></dd>
                  <dd><a href="">跳转项</a></dd>
              </dl>
          </li>
          <li class="layui-nav-item">
          <a href="javascript:;">学生管理</a>
              <dl class="layui-nav-child">
                  <dd><a href="javascript:;">学生查询</a></dd>
                  <dd><a href="javascript:;">添加学生</a></dd>
                  <dd><a href="javascript:;">信息修改</a></dd>
                  <dd><a href="javascript:;">学生</a></dd>
              </dl>
          </li>
          <li class="layui-nav-item">
          <a href="javascript:;">课程管理</a>
              <dl class="layui-nav-child">
                  <dd><a href="">移动模块</a></dd>
                  <dd><a href="">后台模版</a></dd>
                  <dd><a href="">电商平台</a></dd>
              </dl>
          </li>
          <li class="layui-nav-item"><a href="">成绩录入</a></li>
          <li class="layui-nav-item"><a href="">学生课程信息</a></li>
          <li class="layui-nav-item"><a href="">课程统计</a></li>
      </ul>

<script src="./layui.js" charset="utf-8"></script>
<script>
layui.use('element', function(){
  var element = layui.element(); //导航的hover效果、二级菜单等功能，需要依赖element模块
  
  //监听导航点击
  element.on('nav(demo)', function(elem){
    //console.log(elem)
    layer.msg(elem.text());
  });
});
</script>

      
  </body>
</html>
