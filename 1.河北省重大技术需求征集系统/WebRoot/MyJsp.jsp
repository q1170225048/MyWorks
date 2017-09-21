<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
   <script type="text/javascript" src="js/jquery-1.4.js"></script>
   <link href="css1/style.css" rel="stylesheet" type="text/css" />
<link href="css1/select.css" rel="stylesheet" type="text/css" />
<link href="media/css/demo_page.css" rel="stylesheet" type="text/css" />
<link href="media/css/demo_table.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js1/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js1/select-ui.min.js"></script>
<script type="text/javascript" src="js1/jsapi.js"></script>
<script type="text/javascript" src="js1/format+zh_CN,default,corechart.I.js"></script>		
<script type="text/javascript" src="js1/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="js1/jquery.ba-resize.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>

  
    <script class="jsbin" src="media/js/jquery.dataTables.nightly.js"></script>
  <script>
  
    var num=1;
	function addDiv()
	{
		var div=document.getElementById("div0");
		var node=document.getElementById("div1");
		var cnode=node.cloneNode(true);
		cnode.style.display="";
		if(num<=3)
		{
			div.appendChild(cnode);
			num++;
		}
	}
	
	function deleteDiv()
	{
		var div=document.getElementById("div0");
		var childs=div.childNodes;
		if(num>1)
		{ 
			div.removeChild(childs[childs.length-1]);
			num--; 
		}
	}
	
	var num1=1;
	function addDiv1()
	{
		var div=document.getElementById("div2");
		var node=document.getElementById("div3");
		var cnode=node.cloneNode(true);
		cnode.style.display="";
		if(num1<=12)
		{
			div.appendChild(cnode);
			num1++;
		}
	}
	
	function deleteDiv1()
	{
		var div=document.getElementById("div2");
		var childs=div.childNodes;
		if(num1>1)
		{ 
			div.removeChild(childs[childs.length-1]);
			num1--; 
		}
		
	}
	
	function submit()
	{
		document.form1.submit();
	}
  </script>
  <body>
   <div id="div1" style="display:none">
					 	<div Style="height:5px"></div>
					 	<select style="width:66px" name="selecttype01">
					 		<option value="and">并含</option>
					 		<option value="or">或含</option>
					 		<option value="not">不含</option>
					 	</select>
						<select style="width:120px" name="selectindex01">
						   <option value="name">机构名</option>
						   <option value="place">所在地域</option>
						   <option value="attribute">机构属性</option>
						   <option value="adminapartment">归口部门</option>
					 	</select>
					 	<input type="text"  size="20" name="selectvalue01">
					 	<select name="selecttype02">
					 		<option value="and">并含</option>
					 		<option value="or">或含</option>
					 		<option value="not">不含</option>
					 	</select>
					 	<input type="text" size="20" name="selectvalue02">
						 <select name="type01">
						 	<option value="equal">精确</option>
						 	<option value="like">模糊</option>
						 </select>
	</div>
	<div id="div3" style="display:none">
				<div Style="height:5px"></div>
					 	<select style="width:66px" name="selecttype11">
					 		<option value="and">并含</option>
					 		<option value="or">或含</option>
					 		<option value="not">不含</option>
					 	</select>
						<select style="width:120px" name="selectindex11">
						   <option value="xssh">形式审核</option>
						   <option value="bmsh">部门审核</option>
						   <option value="needname">需求名</option>
						   <option value="key">关键字</option>
						   <option value="mainproblem">主要问题</option>
						   <option value="maintechnology">技术关键</option>
						   <option value="plantarget">预期目标</option>
						   <option value="researchtype">科技活动类型</option>
						   <option value="needtype">需求应用行业</option>
						   <option value="needdepartment">需求所属领域</option>
						   <option value="subjecttype">学科分类</option>
					 	</select>
					 	<input type="text" size="20" name="selectvalue11">
					 	<select name="selecttype12">
					 		<option value="and">并含</option>
					 		<option value="or">或含</option>
					 		<option value="not">不含</option>
					 	</select>
					 	<input type="text" name="selectvalue12" size="20">
						 <select name="type11">
						 	<option value="equal">精确</option>
						 	<option value="like">模糊</option>
						 </select>
</div>
	
  	<form name="form1" action="tjcx/test.action" method="post" target="downFrame" id="form1">
  		<div>
  			
				<div id="div0">
					<div>	
						<input type="button" value="+" id="btn1" onclick="addDiv()">
						<input type="button" value="-" id="btn2" onclick="deleteDiv()">
						<select style="width:120px" name="firstindex01">
						   <option value="name">机构名</option>
						   <option value="szdy">所在地域</option>
						   <option value="pro">机构属性</option>
						   <option value="belong">归口部门</option>
					 	</select>
					 	<input type="text"  size="20" name="firstvalue01">
					 	<select name="firsttype01">
					 		<option value="and">并含</option>
					 		<option value="or">或含</option>
					 		<option value="not">不含</option>
					 	</select>
					 	<input type="text" size="20" name="firstvalue02">
					 	<select name="typefirst01">
						 	<option value="equal">精确</option>
						 	<option value="like">模糊</option>
					 	</select>
					 </div>
				</div>
				
				<div id="div2">
					<div Style="height:15px"></div>
						<div>
							<input type="button" value="+" id="btn1" onclick="addDiv1()">
							<input type="button" value="-" id="btn2" onclick="deleteDiv1()">
							<select style="width:120px" name="firstindex11">
							   <option value="techName">需求名</option>
							   <option value="keyword">关键字</option>
							   <option value="techIntroMajorproblem">主要问题</option>
							   <option value="techIntroKeytechnology">技术关键</option>
							   <option value="techIntroTarget">预期目标</option>
							   <option value="actionType">科技活动类型</option>
							   <option value="applicationIndustry">需求应用行业</option>
							   <option value="field">需求所属领域</option>
							   <option value="sujectSpecific">学科分类</option>
						 	</select>
						 	<input type="text"  size="20" name="firstvalue11">
						 	<select name="firsttype11">
						 		<option value="and">并含</option>
					 		<option value="or">或含</option>
					 		<option value="not">不含</option>
						 	</select>
						 	<input type="text" size="20" name="firstvalue12">
						 	<select name="typefirst11">
							 	<option value="equal">精确</option>
							 	<option value="like">模糊</option>
						 	</select>
						 </div>
					</div>
				<div>
					<div style="height:15px"></div>
					<div>
						起始时间:从<input type="text" name="begintime1" size="20">年到<input type="text" name="begintime2" size="20">年
					</div>
				</div>
				<div>
					<div style="height:15px"></div>
					<div>
					              截止时间:从<input type="text" name="finaltime1" size="20">年到<input type="text" name="finaltime2" size="20">年
					              <input name="sub" type="submit" value="检索" class="scbtn"style="float:center;">     <input name="sub" type="submit" value="结果集查找" class="scbtn"style="float:center;">
					</div>
				</div>
				
					
				
  		</div>
  	</form>
  </body>
</html>
