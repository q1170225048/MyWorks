<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'speedFind.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.js"></script>
	<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/framework.js"></script> --%>
	
	

	<!-- <link rel="stylesheet" type="text/css" id="skin"/> -->
	<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/nav/ddaccordion.js"></script> --%>
	<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/text/text-overflow.js"></script> --%>
  </head>
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
  <body>
  <br>
	 <div id="scrollContent" >
			<div class="arrowlistmenu">
		     	<ul>
		     		<li>
		     			<span name="jcyj" style="cursor:pointer">基础研究</span>
		     			<ul name="jcyj1"></ul>
		     		</li>
		     		<li>
		     			<span name="fjcyj" style="cursor:pointer">非基础研究</span>
		     			<ul name="fjcyj1"></ul>
		     		</li>
		     	</ul>	
	    </div>
	   </div>
	     <form name="actionForm" action="tjcx/test.action" method="post" target='frmright' >
	   	 <input type="hidden" name="selectvalue" id="selectvalue">
	   	 <input type="hidden" name="sub" id="sub">
	   	 <input type="hidden" name="name" id="name">
	   </form>
  </body>
</html>
