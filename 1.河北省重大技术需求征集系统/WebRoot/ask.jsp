<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*,entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>问卷调查</title>
<style type="text/css">
html,body,div,li,form,input,th,td{margin:0;padding:0;font-family:楷体; font-size:100%; }
ul,ol,li{ list-style:none;}
a:link, a:visited{ color:#FF00FF; text-decoration:none;}
a:hover{ color:#12b7f5;}

table {
	border-collapse: collapse;
	border: none;
	margin: 60px auto;
	width: 800px;
}

th, td {
	border: Groove #000000 2px;
	height: 20px;
	margin-bottom: 12px; line-height: 25px;  opacity: 1.0;
}

div ,td{
	text-align: left;
}
</style>
<script type="text/javascript" src="js/jquery-1.4.js"> </script>
<script type="text/javascript" src="js/CreateDemand.js"></script>
<script type="text/javascript" >
 var msg="${requestScope.tipS}";  
if(msg != ""){
	alert(msg);
}

</script>
<Script language="javascript">
var XMLHttpReq;
var upper;
var lower;
var completeDiv;
var inputField;
var completeTable;
var completeBody;

function getUI()
{
	var n = document.getElementById("form1").S_Typ;
	var S_type;
	for(var i=0;i<n.length;i++)
	{
		if(n.item(i).checked)
		{
			S_type = n.item(i).value;
			break;
		}
		else
		{
			continue;
		}
	}
	var servics = document.getElementById("servics");
	var sub = document.getElementById("sub");
	if(S_type == ("基础研究"))
	{
		servics.style.display="none";
		sub.style.display="block";
	}
	else
	{
		sub.style.display="none";
		servics.style.display="block";
	}
}

//创建XMLHttpRequest对象
function createXMLHttpRequest(){
	if(window.XMLHttpRequest){//Mozilla浏览器
		XMLHttpReq = new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		try{
			XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			try{
				XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){}
		}
	}
}

//刷新列表框函数
function refreshList(upperId,lowerId,tier,action){
	upper = document.getElementById(upperId).value;
	lower = document.getElementById(lowerId);
	if(upper ==""){
		clearList();
		return;
	}
	var url ="ask?upper="+upper+"&tier="+tier+"&action="+action;
	createXMLHttpRequest();
	XMLHttpReq.open("GET",url,true);
	XMLHttpReq.send(null);//发送请求
	
	XMLHttpReq.onreadystatechange =processListResponse;//指定响应函数
	
}

//处理返回信息
function processListResponse(){
	if(XMLHttpReq.readyState == 4){//判断对象状态
		if(XMLHttpReq.status == 200){//信息已经成功返回，开始处理信息
			updateList();
		}else{
			window.alert("您所请求的页面有异常。");
		}
	}
}

//更新列表框中列表项函数
function updateList(){
	clearList();
	//clearList("thirdSubjects");
	
	var results = XMLHttpReq.responseXML.getElementsByTagName("name");
	var values = XMLHttpReq.responseXML.getElementsByTagName("value");
	var option = null;
	
	option = document.createElement("option");
	option.appendChild(document.createTextNode('请选择'));
	option.value="default";
	lower.appendChild(option);
	for(var i=0;i<results.length;i++){
		option = document.createElement("option");
		option.appendChild(document.createTextNode(results[i].firstChild.nodeValue));
		option.value = values[i].firstChild.data;
		lower.appendChild(option);
	}
}
//请除列表框中原有选项的函数
function clearList(){
	while(lower.childNodes.length>0){
		lower.removeChild(lower.childNodes[0]);
	}
}

//发送匹配请求函数
function findName(inputArea,popupArea,messageTable,messageBody){
	inputField = document.getElementById(inputArea);
	completeTable = document.getElementById(popupArea);
	completeBody = document.getElementById(messageTable);
	completeDiv = document.getElementById(messageTable);
	
	if(inputField.value.length>0){
    	createXMLHttpRequest();
	    var url = "ask?action=match&names="+inputField.value;
	    //编码
	    url = encodeURI(url);
	    url = encodeURI(url);
	    XMLHttpReq.open("GET",url,true);
	    XMLHttpReq.send(null);//发送请求
	    XMLHttpReq.onreadystatechange = processMatchResponse;//响应指定函数
	    
	}
    else{
    	clearNames();
    }
}

//处理返回信息匹配函数
function processMatchResponse(){
	if(XMLHttpReq.readyState == 4){//判断对象状态
		if(XMLHttpReq.status == 200){//信息已经成功返回，开始处理信息
		
			setNames(XMLHttpReq.responseXML.getElementsByTagName("res"));
		}
    	else{
    		window.alert("您所请求的页面有异常。");
    	}
    }
}

//生成与输入内容匹配行
function setNames(names){
	clearNames();
	var size = names.length;
	setOffsets();
	
	var row,cell,txtNode;
	for(var i=0;i<5;i++)
	{
		var nextNode = names[i].firstChild.data;
		row = document.createElement("tr");
		cell = document.createElement("td");
		
		cell.onmouseout = function(){this.className='mouseOver';};
		cell.onmouseover = function(){this.className='mouseOut';};
		cell.setAttribute("bgcolor","#FFFAFA");
		cell.setAttribute("border","0");
		cell.onclick = function() {completeField(this);};
		
		txtNode = document.createTextNode(nextNode);
		cell.appendChild(txtNode);
		row.appendChild(cell);
		completeBody.appendChild(row);
		
	}
}

//设置显示位置
function setOffsets(){
	completeDiv.style.width = inputField.offsetWidth+"px";
	var left = calculateOffset(inputField,"offsetLeft");
	var top = calculateOffset(inputField,"offsetTop")+inputField.offsetHeight;
	completeDiv.style.border = "black 1px solid";
	completeDiv.style.left = left +"px";
	completeDiv.style.top = top+"px";
}

//计算显示位置
function calculateOffset(field,attr){
	var offset = 0;
	while(field){
		offset +=field[attr];
		field = field.offsetParent;
	}
	return offset;
}

//填写输入框
function completeField(cell){
	inputField.value = cell.firstChild.nodeValue;
	clearNames();
}

//清除自动完成行
function clearNames(){
	var ind = completeBody.childNodes.length;
	for(var i = ind - 1;i>=0;i--){
		completeBody.removeChild(completeBody.childNodes[i]);
	}
	completeDiv.style.border = "none";
}

   var whichText;
    function selectStation(obj) {
   var objSelStation = obj;
        if (obj.selectedIndex != -1) {
            var stationName = obj.options[obj.selectedIndex].text;
            whichText.value = stationName;
        }
        showDivStation(this, false,'selStation')//鼠标单击某一选项选定后关闭下拉框
    }
  //邮箱验证
    function verifyAddress()    
    {    
     var email = document.getElementById('email').value;    
     var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;    
     flag = pattern.test(email);    
     if(flag)    
     {    
    	 document.getElementById("mes").innerHTML="<font color='red'></font>";
       	 return true;    
     }    
     else    
     {    
      document.getElementById("mes").innerHTML="<font color='red'>邮箱格式有误!</font>";
      document.getElementById("email").focus();
      return false;    
     }    
    }
  
  //起始年限大于终止年限
  function bigfirstT()
  {
	  var END = document.getElementById('time_end').value;
	  var START=document.getElementById('time_start').value;
	  if(END<START)
		  {
		    document.getElementById('time_start').value="2016";
		    document.getElementById('time_end').value="2017";
		  	alert("起始年限大于终止年限！");
		  }
  }
  //文本域计数及限制字数
    function textCounter(field, countfield, maxlimit) {
    // 函数，3个参数，表单名字，表单域元素名，限制字符；
    if (field.value.length > maxlimit)
    //如果元素区字符数大于最大字符数，按照最大字符数截断；
    {
    	field.value = field.value.substring(0, maxlimit);
    	alert("最多可输入500个字！");
    }
    else
    //在记数区文本框内显示剩余的字符数；
    countfield.value = maxlimit - field.value.length;
    }
  //关键字只能按照顺序输入
  function secondOn()
  {
	  var keyword = document.getElementById('keyword1').value;
	  if(keyword!="")
	  {
		  document.getElementById('keyword2').disabled=false;
		  document.getElementById('keyword2').focus();
	  }
	  else
	  {
		  document.getElementById('keyword2').value="";
		  document.getElementById('keyword2').disabled=true;
		  document.getElementById('keyword3').value="";
		  document.getElementById('keyword3').disabled=true;
		  document.getElementById('keyword4').value="";
		  document.getElementById('keyword4').disabled=true;
		  document.getElementById('keyword5').value="";
		  document.getElementById('keyword5').disabled=true;
	  }
  }
  function thirdOn()
  {
	  var keyword = document.getElementById('keyword2').value;
	  if(keyword!="")
	  {
		  document.getElementById('keyword3').disabled=false;
		  document.getElementById('keyword3').focus();
	  }
	  else
	  {
		  document.getElementById('keyword3').value="";
		  document.getElementById('keyword3').disabled=true;
		  document.getElementById('keyword4').value="";
		  document.getElementById('keyword4').disabled=true;
		  document.getElementById('keyword5').value="";
		  document.getElementById('keyword5').disabled=true;
	  }
  }
  function fourthOn()
  {
	  var keyword = document.getElementById('keyword3').value;
	  if(keyword!="")
	  {
		  document.getElementById('keyword4').disabled=false;
		  document.getElementById('keyword4').focus();
	  }
	  else
	  {
		  document.getElementById('keyword4').value="";
		  document.getElementById('keyword4').disabled=true;
		  document.getElementById('keyword5').value="";
		  document.getElementById('keyword5').disabled=true;
	  }
  }
  function fifthOn()
  {
	  var keyword = document.getElementById('keyword4').value;
	  if(keyword!="")
	  {
		  document.getElementById('keyword5').disabled=false;
		  document.getElementById('keyword5').focus();
	  }
	  else
	  {
		  document.getElementById('keyword5').value="";
		  document.getElementById('keyword5').disabled=true; 
	  }
  }
  //对基础研究类型和非基础部门隐藏
  function NoBasic()
  {
	  e=event.srcElement;
	  if(e.type=="radio"&& e.name=="yanjiuLX")
	  {
		if(e.value=="基础研究")
			{
				document.getElementById("Nobasic1").style.display = 'none';
				document.getElementById("Nobasic2").style.display = 'none';
				document.getElementById("basic").style.display = '';
			}
		else
			{
				document.getElementById("Nobasic1").style.display = '';
				document.getElementById("Nobasic2").style.display = '';
				document.getElementById("basic").style.display = 'none';
			}
	  }

  }
</Script>


</head>
<body>
	<%
		Info a=(Info)session.getAttribute("existUser");
	 %>
	<center>
	<h1>需求征集</h1>
	<form action="add" method="post" id="form1" >
	<table>
	<!-- 类型、事件、tab顺序、name、id、大小、错误提示   type="text" tabindex="2" name="email" id="dzyx"-->
		<tr>
			<th width="20%" ><font color="red">*</font>机构全称</th>
			<td width="30%"><input type="text" tabindex="1" name="name"  style="width:99%;height:30px" value="<%=a.getName()%>" required></td>
			<th width="15%">归口管理部门</th>
			<td width="35%"><input type="text" tabindex="2" name="belong" id="belong" style="width:99%;height:30px" value="<%=a.getBelong()%>"></td>
		</tr>
		<tr>
			<th width="20%"><font color="red">*</font>通讯地址</th>
			<td width="20%"><input type="text" tabindex="3" name="address" id="address" style="width:99%;height:30px" value="<%=a.getAddress()%>" required></td>
			
			<th width="20%"><font color="red">*</font>所在地域</th>
			<td width="20%">
            <select tabindex="4" name="szdy" id="szdy" style="width:100%;height:100%" required>
           
            <option value='<%="1" %>'><%="1" %></option>
          
            </select>
			</td>
		</tr>
		<tr>
			<th>网    址</th>
			<td><input type="text" tabindex="5" name="url" id="url" style="width:99%;height:30px" value="<%=a.getUrl()%>"></td>
			<th><font color="red">*</font>电子信箱</th>
			<td><input type="text" onblur="verifyAddress()" tabindex="6" name="email" id="email" style="width:99%;height:30px" value="<%=a.getEmail()%>" required></td>
		</tr>
		<tr>
			<th><font color="red">*</font>法人代表</th>
			<td><input type="text" tabindex="7" name="fr" id="fr" style="width:99%;height:30px" value="<%=a.getFr()%>" required></td>
			<th>邮政编码</th>
			<td><input type="text" tabindex="8" name="pcode" id="pcode" style="width:99%;height:30px" value="<%=a.getPcode()%>"></td>
		</tr>
		<tr>
			<th rowspan=1 colspan=1><font color="red">*</font>联系人</th>
			<td rowspan=1 colspan=1><input type="text" tabindex="9" name="contact" id="contact" style="width:99%;height:30px"  value="<%=a.getContact()%>" required></td>
			<th rowspan=2 colspan="1"><font color="red">*</font>电话</th>
			<td rowspan=1 colspan="1">1.固定<input type="text" tabindex="10" name="phone" id="phone" style="width:78%;height:30px" value="<%=a.getPhone()%>" required></td>
			
		</tr>
		<tr>
			<th rowspan=1 colspan="1">传真</th>
			<td rowspan=1 colspan="1"><input type="text" tabindex="12" name="cz" id="cz" style="width:99%;height:30px" value="<%=a.getCz()%>"></td>
			<td rowspan=1 colspan="1">2.手机<input type="text" tabindex="11" name="mphone" id="mphone" style="width:78%;height:30px" pattern="1[0-9]{10}" title="请输入正确格式的手机号" value="<%=a.getMphone()%>" required></td>
		</tr>
		<tr>
			<th><font color="red">*</font>机构属性</th>
			<td colspan=3><input type="radio" tabindex="13" name="pro" id="pro1" value="企业" <%if("".equals("企业"))out.print("checked"); %>> 企业
			<input type="radio" name="pro" id="pro2" value="高等院校" <%if("".equals("高等院校"))out.print("checked"); %>>高等院校
			<input type="radio" name="pro" id="pro3" value="研究机构" <%if("".equals("研究机构"))out.print("checked"); %>>研究机构
			<input type="radio" name="pro" id="pro4" value="其他" <%if("".equals("其他"))out.print("checked"); %>>其他
			</td>
		    
		</tr>
		<tr>
			<th rowspan=2 colspan=1 ><font color="red">*</font>机构简介</th>
			<td rowspan=1 colspan=3 ><textarea rows="5" name="intro" id="intro" maxlength="501" title="您已超过字数限制（500）" onKeyDown="textCounter(intro,remLen,500);" onKeyUp="textCounter(intro,remLen,500);" placeholder="主要包括基础情况、现有研究基础等，限500字以内" style="width:99%;height:150px" required><%=a.getIntro()%></textarea></td>
		</tr>
		<tr>
		    <td rowspan=1 colspan=4>您还可以输入:<input name="remLen" type="text" value="500" size="5" readonly>个字符</td>
		</tr>
		<tr>
			<th><font color="red">*</font>技术需求名称</th>
			<td ><input name="techName" id="tech_name" style="width:99%;height:30px" required></td>
			<th><font color="red">*</font>需求时限</th>
			<td >
			<select name="timeStart" id="time_start" tabindex="14" style="width:80px;height:30px" >
			<%
			    int start=2100;
			    for(int i=0;i<=82;i++)
			    {
			    	start--;
			%>
			<option value='<%=start%>' selected><%=start%></option>
			<% 
			    }
			%>
            
            </select>
			年至
			<select name="timeEnd" id="time_end" tabindex="15" style="width:80px;height:30px" onblur="bigfirstT()" >
            <%
			    int end=2100;
			    for(int i=0;i<=81;i++)
			    {
			    	end--;
			%>
			<option value='<%=end%>' selected><%=end%></option>
			<% 
			    }
			%>
            </select>
			年
			</td>
		</tr>
		<tr>
			<th><font color="red">*</font>技术需求概述</th>
			<td colspan=6>
			<textarea rows="5" name="techIntroMajorproblem" id="tech_intro_majorproblem" placeholder="1、主要问题（需要解决的重大技术问题，限500字以内）" onKeyDown="textCounter(tech_intro_majorproblem,state1,500);" onKeyUp="textCounter(tech_intro_majorproblem,state1,500);" style="width:99%;height:150px" required></textarea>
			<input name="state1" type="text" value="500" style="border-style:none;text-align:right" size="2" readonly>/500</label>
            <textarea rows="5" name="techIntroKeytechnology" id="tech_intro_keytechnology" placeholder="2、技术关键（所需的关键技术、主要指标，限500字以内）" onKeyDown="textCounter(tech_intro_keytechnology,state2,500);" onKeyUp="textCounter(tech_intro_keytechnology,state2,500);" style="width:99%;height:150px" required></textarea>
            <input name="state2" type="text" value="500" style="border-style:none;text-align:right" size="2" readonly>/500</label>
            <textarea rows="5" name="techIntroTarget" id="tech_intro_target" placeholder="3、预期目标（技术创新性、经济社会效益，限500字以内）" onKeyDown="textCounter(tech_intro_target,state3,500);" onKeyUp="textCounter(tech_intro_target,state3,500);" style="width:99%;height:150px" required></textarea>
            <input name="state3" type="text" value="500" style="border-style:none;text-align:right" size="2" readonly>/500</label>
            </td>
		</tr>
		<tr>
			<th><font color="red">*</font>关键字(1-5个)</th>
			<td colspan=3>
			1、<input type="text" name="keyword" id="keyword1" size="10" maxlength="5" onblur="secondOn()" required>
			2、<input type="text" name="keyword" id="keyword2" size="10" maxlength="5" onblur="thirdOn()" disabled>
			3、<input type="text" name="keyword" id="keyword3" size="10" maxlength="5" onblur="fourthOn()" disabled>
			4、<input type="text" name="keyword" id="keyword4" size="10" maxlength="5" onblur="fifthOn()" disabled>
			5、<input type="text" name="keyword" id="keyword5" size="10" maxlength="5" disabled>
			</td>
		</tr>
		<tr>
		    <th>拟投资总金额</th>
		    <td colspan=3><input name="moneyInvestment" id="money_investment" style="width:40%;height:99%">万元</td>
		</tr>
		<tr>
			<th rowspan=2><font color="red">*</font>技术需求解决方式</th>
			<td colspan=3><input type="radio"name="solution" id="o1"value="独立研发"  onclick="setDisabled1();">独立研发
			<input type="radio"name="solution" id="o2" value="委托研发" onclick="setDisabled1();">委托研发
			<input type="radio"name="solution" id="o3" value="合作研发" onclick="setDisabled1();">合作研发
			<input type="radio"name="solution" id="o4" value="其他" onclick="setDisabled1();">其他
			
			</td>
		</tr>
		<tr>
		    <th>合作意向单位</th>
			<td colspan=3><input name="nameJoinUnit" id="name_join_unit" style="width:99%;height:99%"></td>
		</tr>
		<tr>
			<th><font color="red">*</font>科技活动类型</th>
			<td colspan=3><input type="radio" name="actionType" id="t1"value="基础研究" >基础研究
			<input type="radio"name="actionType" id="t2" value="应用研究">应用研究
			<input type="radio"name="actionType" id="t3" value="试验发展">试验发展
			<input type="radio"name="actionType" id="t4" value="研究发展与成果应用">研究发展与成果应用
			<input type="radio"name="actionType" id="t5" value="技术推广与科技服务">技术推广与科技服务
			<input type="radio"name="actionType" id="t6" value="生产性活动">生产性活动
			</td>
		</tr>
		<tr>
			<th>学科分类</th>
			<td colspan="3">
            <select name="firstSubjects" id="firstSubjects" onchange="refreshList('firstSubjects','secondSubjects','1','subject')">
                <option value=" ">请选择</option>
				<%
				
				%>
				<option value="<%= ""%>"><%="" %></option>
				<%
					
				%>
            </select>
            <select name="secondSubjects" id="secondSubjects" onchange="refreshList('secondSubjects','thirdSubjects','2','subject');">
                <option value=" ">请选择</option>
            </select>
            <select name="thirdSubjects" id="thirdSubjects">
                <option value=" ">请选择</option>
            </select>
        </td>
		</tr>
		<tr>
			<th>需求技术所属领域(非基础必填)</th>
			<td colspan=3><input name="field"id="f1" type="checkbox"value="电子信息">电子信息
			<input name="field" type="checkbox"id="f2"value="光机电一体化">光机电一体化
			<input name="field" type="checkbox"id="f3"value="生物技术与制药">生物技术与制药
			<input name="field" type="checkbox"id="f4"value="新材料及应用">新材料及应用
			<input name="field" type="checkbox"id="f5"value="现代农业">现代农业
			<input name="field" type="checkbox"id="f6"value="新能源与高效节能">新能源与高效节能
			<input name="field" type="checkbox"id="f7"value="资源与环境">资源与环境
			<input name="field" type="checkbox"id="f8"value="高技术服务业">高技术服务业
			<input name="field" type="checkbox"id="f9"value="海洋">海洋
			<input name="field" type="checkbox"id="f10"value="社会公共事业">社会公共事业
			<input name="field" type="checkbox"id="f11"value="医疗卫生">医疗卫生
			<input name="field" type="checkbox"id="f12"value="其他技术（注明）">其他技术（注明）
			</td>
		</tr>
		<tr>
			<th>需求技术应用行业(非基础填写)</th>
			<td colspan="4">
        	<select name="firstIndustry" id="firstIndustry" onchange="refreshList('firstIndustry','secondIndustry','1','industry');">
                <option value=" ">请选择</option>
				<%
				
				%>
				<option value="<%="" %>"><%= "" %></option>
				<%
					
				%>
            </select>
            <select name="secondIndustry" id="secondIndustry" onchange="refreshList('secondIndustry','thirdIndustry','2','industry');">
                <option value=" ">请选择</option>
            </select>
            <select name="thirdIndustry" id="thirdIndustry">
                <option value=" ">请选择</option>
            </select>
        </td>
		</tr>
		<tr>
			<th align="right" colspan =4>带<font color="red">*</font>项为必填项</th>
		</tr>
				
	</table>
	<input type="hidden" name="no" value="<%=a.getNo() %>">
	<input type="hidden" name="techNo" value="<%="1"  %>">
	<input type="hidden" name="state" value="<%="1"  %>">
	<input type="submit" name="submit" value="保存并提交" style="width:80px;height:30px;margin-right:30px;"> 
	<input type="reset"  name="reset" value="重置" style="width:80px;height:30px;">
	</form>
	</center>
</body>
</html>