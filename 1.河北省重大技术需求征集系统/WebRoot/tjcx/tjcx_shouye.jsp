<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*"%>
	<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>统计查询首页</title>
<link href="../css1/style.css" rel="stylesheet" type="text/css" />
<link href="../css1/select.css" rel="stylesheet" type="text/css" />
<link href="../media/css/demo_page.css" rel="stylesheet" type="text/css" />
<link href="../media/css/demo_table.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="../js1/jquery.js"></script>
<script type="text/javascript" src="../js1/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../js1/select-ui.min.js"></script>
<script type="text/javascript" src="../js1/jsapi.js"></script>
<link href="../css/import_basic.css" rel="stylesheet" type="text/css"/>
        <link href="../skins/sky/import_skin.css" rel="stylesheet" type="text/css" id="skin"/>
<script type="text/javascript" src="../js1/format+zh_CN,default,corechart.I.js"></script>		
<script type="text/javascript" src="../js1/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="../js1/jquery.ba-resize.min.js"></script>
<script type="text/javascript" src="../editor/kindeditor.js"></script>

  
    <script class="jsbin" src="../media/js/jquery.dataTables.nightly.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  <script>
$(document).ready(function() {
	oTable = $('#example').dataTable({
		"bJQueryUI": true,
		"sPaginationType": "full_numbers"
	});
} );
</script>
<script type="text/javascript">

$(document).ready(function() {
    $("#t2").click(function(){ $("#t1").removeClass();$("#t3").removeClass();
    	$("#t2").addClass("selected");$("#tab1").hide();$("#tab3").hide();$("#tab2").show();});
    $("#t1").click(function(){ $("#t2").removeClass();$("#t3").removeClass();
    	$("#t1").addClass("selected");$("#tab2").hide();$("#tab3").hide();$("#tab1").show();});
    $("#t3").click(function(){ $("#t1").removeClass();$("#t2").removeClass();
    	$("#t3").addClass("selected");$("#tab1").hide();$("#tab2").hide();$("#tab3").show();});
	
});

</script>
<script type="text/javascript">
  		/* $(document).ready(function(){
    	reloadPro();               
    	function reloadPro(){
    		$.ajax({
    			url:"threelevel/subject.xml",
    			type:"post",
    			dataType:'xml',
    			success:function getProvince(msg){
    			  $(msg).find("province").each(function(){
    				  var ul="<ul name='ul1' id='"+$(this).attr('provinceID')+"'><span>"+$(this).attr('province')+"</span></ul>";
    				  $("div[name='target']").append(ul);
    			  });
    			}
    		}); */
    		
    		/* $("span[name='ul1']").Click(function(){
    		var $province=$(this).attr("province");
    			$.ajax({
    				url:"threelevel/subject.xml",
    				type:"post",
    				dataType:"xml",
    				success:function(msg){
    				 $province=$(msg).find("province[province="+$province+"]");
    				 $province.find("City").each(function(){
    				 var ul2="<li><ul><span>"+$(this).attr('City')+"</span></ul></li>";
    				 ul=ul+ul2;
    				 });
    				}
    			});
    		}); */
    		   /* $("select[name='subject2']").change(function(){
    			var $cityId=$(this).attr("value");
    			$.ajax({
    				url:"../threelevel/subject.xml",
    				type:"post",
    				dataType:"xml",
    				success:function(msg){
    				 $("select[name='subject3']").empty();
    				 $city=$(msg).find("City[CityID="+$cityId+"]");
    				 $city.find("Piecearea").each(function(){
    				 var $option="<option value='"+$(this).attr("PieceareaID")+"'>"+$(this).attr('Piecearea')+"</option>";
    				 $("select[name='subject3']").append($option);
    				 });
    				}
    			});
    		}); */ 
    	/* $("ul[name='ul1']").click(function(){
  		alert("1");
    	var $proID=$(this).attr("id");
    	$.ajax({
    				url:"threelevel/subject.xml",
    				type:"post",
    				dataType:"xml",
    				success:function(msg){
    				 $province=$(msg).find("province[provinceID="+$proID+"]");
    				 $province.find("City").each(function(){
    				 var li="<li><ul><span>"+$(this).attr('City')+"</span></ul></li>";
    				 $("ul[name='ul1']").append(li);
    				 });
    				}
    			});
    		});*/ 
   /*  	} 
    }); */
   /*  $(document).click(function(e){
    alert("1");
	  		var id = $(e.target).attr("id");
	  		var name= $(e.target).attr("name");
	  		alert(name);
	  		if(name=="jcyj")
	  		{
	  			var $proID=id;
		    	$.ajax({
		    				url:"threelevel/subject.xml",
		    				type:"post",
		    				dataType:"xml",
		    				success:function(msg){
		    				 $province=$(msg).find("province[provinceID="+$proID+"]");
		    				 $province.find("City").each(function(){
		    				 var li="<li><ul><span>"+$(this).attr('City')+"</span></ul></li>";
		    				 $("ul[name='ul1']").append(li);
		    				 });
		    			}
		    		});
		    			
		    	}); 
	  		}
	  	});  */
    $(function(){
    	$(document).click(function(e){
    		var id = $(e.target).attr("id");
    		var name = $(e.target).attr("name");
    		if(name=="jcyj")
			{
				if($("ul[name='jcyj1']").children("li").length!=0)
				{
					$("ul[name='jcyj1']").empty();
				}
				else
				{
					$.ajax({
	    			url:"threelevel/subject.xml",
	    			type:"post",
	    			dataType:'xml',
	    			success:function getProvince(msg){
	    			$("ul[name='jcyj1']").empty();
	    			$("ul[name='fjcyj1']").empty();
	    			$(msg).find("province").each(function(){
	    				  var li="<li>&nbsp;<span name='jcyj1' id='"+$(this).attr('provinceID')+"' style='color:cc0000;cursor:pointer'>"+$(this).attr('province')+"</span><ul name='"+$(this).attr('provinceID')+"' id='jcyj2'></ul></li>";
	    				  $("ul[name='jcyj1']").append(li);
	    			 	 });
	    				}
	    			});
				}	
			}
			if(name=="jcyj1")
			{
				if($("ul[name='"+id+"']").children("li").length!=0)
				{
					$("ul[name='"+id+"']").empty();
				}
				else
				{
					var $proID=id;
		    		$.ajax({
		    				url:"threelevel/subject.xml",
		    				type:"post",
		    				dataType:"xml",
		    				success:function(msg){
		    				 $("ul[id='jcyj2']").empty();
		    				 $province=$(msg).find("province[provinceID="+$proID+"]");
		    				 $province.find("City").each(function(){
		    				 var li="<li>&nbsp;&nbsp<span name='jcyj2' id='"+$(this).attr('CityID')+"' style='color:3366cc;cursor:pointer'>"+$(this).attr('City')+"</span><ul name='"+$(this).attr('CityID')+"' id='jcyj3'></ul></li>";
		    				 $("ul[name='"+id+"']").append(li);
		    				});
		    			}
		    		});	
				}		
			}
			if(name=="jcyj2")
			{
				if($("ul[name='"+id+"']").children("li").length!=0)
				{
					$("ul[name='"+id+"']").empty();
				}
				else
				{
					var $cityID=id;
		    		$.ajax({
		    				url:"threelevel/subject.xml",
		    				type:"post",
		    				dataType:"xml",
		    				success:function(msg){
		    				 $("ul[id='jcyj3']").empty();
		    				 $city=$(msg).find("City[CityID="+$cityID+"]");
		    				 $city.find("Piecearea").each(function(){
		    				 var li="<li>&nbsp;&nbsp;&nbsp<span name='3' id='"+$(this).attr('PieceareaID')+"' style='color:642100;cursor:pointer'>"+$(this).attr('Piecearea')+"</span></li>";
		    				 $("ul[name='"+id+"']").append(li);
		    				});
		    			}
		    		});	
				}		
			}
			if(name=="fjcyj")
			{
				if($("ul[name='fjcyj1']").children("li").length!=0)
				{
					$("ul[name='fjcyj1']").empty();
				}
				else
				{
					$.ajax({
	    			url:"threelevel/ecnomic.xml",
	    			type:"post",
	    			dataType:'xml',
	    			success:function getProvince(msg){
	    			$("ul[name='fjcyj1']").empty();
	    			$("ul[name='jcyj1']").empty();
	    			  $(msg).find("province").each(function(){
	    				  var li="<li>&nbsp;<span name='fjcyj1' id='"+$(this).attr('provinceID')+"' style='color:cc0000;cursor:pointer'>"+$(this).attr('province')+"</span><ul name='"+$(this).attr('provinceID')+"' id='fjcyj2'></ul></li>";
	    				  $("ul[name='fjcyj1']").append(li);
	    			 	 });
	    				}
	    			});
				}			
			}
			if(name=="fjcyj1")
			{	
				if($("ul[name='"+id+"']").children("li").length!=0)
				{
					$("ul[name='"+id+"']").empty();
				}
				else
				{
					var $proID=id;
		    		$.ajax({
		    				url:"threelevel/ecnomic.xml",
		    				type:"post",
		    				dataType:"xml",
		    				success:function(msg){
		    				 $("ul[id='fjcyj2']").empty();
		    				 $province=$(msg).find("province[provinceID="+$proID+"]");
		    				 $province.find("City").each(function(){
		    				 var li="<li>&nbsp;&nbsp;<span name='fjcyj2' id='"+$(this).attr('CityID')+"' style='color:3366cc;cursor:pointer'>"+$(this).attr('City')+"</span><ul name='"+$(this).attr('CityID')+"' id='fjcyj3'></ul></li>";
		    				 $("ul[name='"+id+"']").append(li);
		    				 });
		    			}
		    		});
				}		
			}
			if(name=="fjcyj2")
			{
				if($("ul[name='"+id+"']").children("li").length!=0)
				{
					$("ul[name='"+id+"']").empty();
				}
				else
				{
					var $cityID=id;
		    		$.ajax({
		    				url:"threelevel/ecnomic.xml",
		    				type:"post",
		    				dataType:"xml",
		    				success:function(msg){
		    				 $("ul[id='fjcyj3']").empty();
		    				 $city=$(msg).find("City[CityID="+$cityID+"]");
		    				 $city.find("Piecearea").each(function(){
		    				 var li="<li>&nbsp;&nbsp;&nbsp;<span name='3' id='"+$(this).attr('PieceareaID')+"' style='color:642100;cursor:pointer'>"+$(this).attr('Piecearea')+"</span></li>";
		    				 $("ul[name='"+id+"']").append(li);
		    			});
		    			}
		    		});	
				}
			}
			if(id!=undefined&&name!=""&&id!="")
			{
				document.getElementById("selectvalue").value=id;
				/* alert(document.getElementById("selectvalue").value); */
				document.getElementById("sub").value="快速检索";
				/* alert(document.getElementById("sub").value); */
				document.getElementById("name").value=name;
				document.actionForm.submit();
			}
    	});
   	 });
    
  	</script>
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

<script type="text/javascript">
		gvChartInit();
		jQuery(document).ready(function(){

		jQuery('#myTable5').gvChart({
				chartType: 'PieChart',
				gvSettings: {
					vAxis: {title: 'No of players'},
					hAxis: {title: 'Month'},
					width: 1015,
					height: 253
					}
			});
		});
		</script>

</head>
<body>

    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
        <li>统计查询</li>
        </ul>
    </div>
    
    <div class="formbody">
        <div id="usual1" class="usual"> 
        
            <div class="itab">
  	            <ul> 
                <li><a id="t1" href="#tab1" class="selected">需求信息</a></li>
                <li><a id="t3" href="#tab3">数据表</a></li>
                <li><a id="t2" href="#tab2">数据统计</a></li>
                
  	            </ul>
            </div> 
    
            <div id="tab1" class="tabson">
            <table height="100%" width="100%" cellpadding="0" cellspacing="0" class="table_border0">
                <tr>
                    <!--左侧区域start-->
                    <td id="hideCon" class="ver01 ali01" height="40%" width="10%">
                        <div id="lbox">
                            <div id="lbox_topcenter">
                                <div id="lbox_topleft">
                                    <div id="lbox_topright">
                                        <div class="lbox_title">
                                            分类浏览选择:
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="lbox_middlecenter">
                                <div id="lbox_middleleft">
                                    <div id="lbox_middleright">
                                        <div id="bs_left">
                                            <IFRAME scrolling="yes" height="100%" width="100%" frameBorder=0 id=frmleft name=frmleft src=<%="../speedFind.jsp" %> allowTransparency="true">
                                            </IFRAME>
                                        </div>
                                        <!--更改左侧栏的宽度需要修改id="bs_left"的样式-->
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                    </td>
                    <!--左侧区域end-->
                    <!--中间栏区域start-->
          
                    <!--中间栏区域end-->
                    <!--右侧区域start-->
                    <td class="ali01 ver01" width="100%" height="100%">
                        <div id="rbox">
                            <div >
                                <div >
                                    <div >
                                        <div class="rbox_title">
                                            输入检索条件
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div >
                                <div >
                                    <div>
                                        <div id="bs_right">
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
	
  	<form name="form1" action="test.action" method="post" target='frmright' id="form1">
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
                                           
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="rbox_bottomcenter">
                                <div id="rbox_bottomleft">
                                    <div id="rbox_bottomright">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                    <!--右侧区域end-->
                </tr>
            </table>
                  <table class="tablelist">
        
    	        <thead>
    	        <tr>
                    <th>机构编码</th>
                    <th>机构名称</th>
                    <th>需求编码</th>
                    <th>需求名称</th>
                    <th>需求概要</th>
                </tr>
                </thead>
            
                <tbody>
                <s:iterator value="taList" id="id" status="status" var="tas">
                                        <tr class="odd gradeX">
                                            <th><s:property value="No"/></th>
			                                <th><s:property value="Name"/></th>		
			                                <th><s:property value="techNo"/></th>
			                                <th><s:property value="techName"/></th>
			                                <th><s:property value="keyword"/></th>
		                                </tr>
                                        </s:iterator>
               </tbody>
            </table>
                
               
                
            </div>
            
    
            <div id="tab2" class="tabson" style="display:none">
                <div class="mainbox">
                    <div class="mainleft">
                    <div class="leftinfo">
                    <div class="listtitle"><a href="#" class="more1">更多</a>数据统计</div>
        
                    <div class="maintj">  
                    <table id="myTable5">
				    <caption>扇形分部:</caption>
				    <thead>
				   
				    
					    <tr>
						    <th></th>
						    <th>基础研究</th>
						    <th>应用研究</th>
						    <th>试验发展</th>
						    <th>研究发展与成果应用</th>
						    <th>技术推广与科技服务</th>
						    <th>生产性活动</th>
					    </tr>
				    </thead>
					<tbody>
					    <tr>
						    <th><%=20 %></th>
						    <td><%=5 %></td>
						    <td><%=3 %></td>
						    <td><%=2 %></td>
						    <td><%=7 %></td>
						    <td><%=2%></td>
						    <td><%=1 %></td>
					    </tr>
				    </tbody>
			        </table>  
                    </div>
    
                    </div>
                
                    </div>
                </div>
        <br><br>
        
    
    </div>
    <div id="tab3" class="tabson" style="display:none">
    	<div id="dt_example">
    	<div id="container">

      <table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
        <thead>
          <tr>
                    <th>机构编码</th>
                    <th>机构名称</th>
                    <th>需求编码</th>
                    <th>需求名称</th>
                    <th>需求概述</th>
          </tr>
        </thead>
        <tbody>
        				<s:iterator value="taList" id="id" status="status">
                                        <tr class="odd gradeX">
                                            <th><s:property value="No"/></th>
			                                <th><s:property value="Name"/></th>		
			                                <th><s:property value="techNo"/></th>
			                                <th><s:property value="techName"/></th>
			                                <th><s:property value="keyword"/></th>
		                                </tr>
                                        </s:iterator>
           </tbody>
      
      </table>
		</div>
    </div>
    </div>
    
    
  </div>
</div>
	
   
    
    
</body>
</html>