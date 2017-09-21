<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.sql.*,entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<script type="text/javascript" src="../js/jquery-1.4.js">
	
</script>
<script type="text/javascript" src="../js/framework.js">
	
</script>
<link href="../css/import_basic.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" id="skin" />
<!--框架必需end-->
<script type="text/javascript" src="../js/nav/ddaccordion.js">
	
</script>
<script type="text/javascript" src="../js/text/text-overflow.js">
	
</script>  

<script type="text/javascript">  
function getList(){  
 var no=$("#no").val();  
         $.ajax({  
             type: "GET",  
             url: "questJSONAction_execute.action",  
             data: {no:no},  
             dataType: "json",  
             success: function(data){ 
       
             $("#nameMes").html("");  
             $("#nameMes").text(data);  
             }  
             });  
}  
function getList1(){  
 var no="${sessionScope.existUser.no}";  
         $.ajax({  
             type: "GET",  
             url: "questJSONAction_execute1.action",  
             data: {no:no},  
             dataType: "json",  
             success: function(data){ 
       
             $("#nameMes").html("");  
             $("#nameMes").text(data);  
             }  
             });  
}  
function getList2(){  
 var no="${sessionScope.existUser.no}";  
         $.ajax({  
             type: "GET",  
             url: "questJSONAction_jssh.action",  
             data: {no:no},  
             dataType: "json",  
             success: function(data){ 
       
             $("#nameMes").html("");  
             $("#nameMes").text(data);  
             }  
             });  
}  
function getList3(){  
 var no="${sessionScope.existUser.no}";  
         $.ajax({  
             type: "GET",  
             url: "questJSONAction_xssh.action",  
             data: {no:no},  
             dataType: "json",  
             success: function(data){ 
       
             $("#nameMes").html("");  
             $("#nameMes").text(data);  
             }  
             });  
}  
</script>  
<style>
a {
	
}

.categoryitems span {
	width: 160px;
}
</style>
<script>
	//打开内页时出现进度条
	$(function() {
		$(".categoryitems a[target*=frmright]").click(function() {
		})
	})
	function ccc() {
		doAjax("../Removeabc", null, function(rstText) {
			var result = eval('(' + rstText + ')');
			if (result.status == 'OK') {
				alert("查询成功");
				return true;
			} else {
				alert("查询失败");
				return false;
			}
		});
	}

	function getXMLHttpResquest() {
		var request;
		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				request = new ActiveXObject("Msxml2.XMLHTTP");
			}
		}
		return request;
	}

	function doAjax(url, params, callBack) {
		var req = getXMLHttpResquest();
		if (req != null) {
			req.onreadystatechange = function() {
				if (req.readyState == 4) {
					if (200 == req.status) {
						callBack(req.responseText);

					} else if (404 == req.status) {
						alert('404-HTTP请求路径错误！');
					} else if (500 == req.status) {
						alert('500-HTTP请求路径错误！');
					}

				}

			};
			req.open("POST", url, true);
			req.setRequestHeader("Content-Type","application/x-www-form-urlencoded;;charset=utf-8");
			req.send(params);
		}
	}
	$(function() {
		var power;
		var html = "";
		$.ajax({
					url : "../PowerServlet",
					type : "post",
					dataType : "json",
					success : function(data) {
						$.each(data,function(i, item) {
											power = item.power;
											/* alert(item.xqzj_qx);
											alert(item.xqgl_qx);
											alert(item.yhxx_qx);
											alert(item.yhxg_qx);
											alert(item.xssh_qx);
											alert(item.bmsh_qx);
											alert(item.tjcx_qx); */
											if (power == 1) {
												html += "<li><a href='../templete/yygl.jsp' target='frmright'><span class='text_slice'>用户管理</span></a></li>"
														+ "<li><a onclick='ccc()' href='../templete/jsgl.jsp' target='frmright'><span class='text_slice'>角色管理</span></a></li>"
														+ "<li><a href='../templete/qxgl1.jsp' target='frmright'><span class='text_slice'>权限管理</span></a></li>"
														
														+ "<li><a onclick='ccc()' href='../templete/mywj.jsp' target='frmright'><span class='text_slice'>需求管理</span></a></li>"
														+ "<li><a onclick='ccc()' href='../templete/xssh.jsp' target='frmright'><span class='text_slice'>形式审核</span></a></li>"
														+ "<li><a onclick='ccc()' href='../templete/bmsh.jsp' target='frmright'><span class='text_slice'>部门审核</span></a></li>"
														+ "<li><a onclick='ccc()' href='../templete/tongji.jsp' target='frmright'><span class='text_slice'>统计查询</span></a></li>"
														+ "<li><a href='../yonghu/mmxg.jsp' target='frmright'><span class='text_slice'>修改密码</span></a></li>"
														+ "<li><a href='../templete/xtjs.html' target='frmright'><span class='text_slice'>系统介绍</span></a></li>"
														+ "<li><a href='../templete/bzwj.html' target='frmright'><span class='text_slice'>帮助文件</span></a></li>"
														+ "<li><a href='../templete/cjwtjd.html' target='frmright'><span class='text_slice'>常见问题解答</span></a></li>";
														//$("#category").html(html);	
											}
											else{
											if (item.xqzj_qx == 0) {
													html += "<li><a href='../templete/table.jsp' target='frmright'><span class='text_slice'>需求征集</span></a></li>";
											}
											if (item.xqgl_qx == 0) {
													html += "<li><a onclick='ccc()' href='../templete/mywj.jsp' target='frmright'><span class='text_slice'>需求管理</span></a></li>";
											}
											if (item.yhxx_qx == 0) {
													html += "<li><a href='../yonghu/yhxx.jsp' target='frmright'><span class='text_slice'>用户信息</span></a></li>";
											}
											if (item.yhxg_qx == 0) {
													html += "<li><a href='../yonghu/mmxg.jsp' target='frmright'><span class='text_slice'>修改密码</span></a></li>";
											}
											if (item.xssh_qx == 0) {
													html += "<li><a onclick='ccc()' href='../templete/xssh.jsp' target='frmright'><span class='text_slice'>形式审核</span></a></li>";
											}
											if (item.bmsh_qx == 0) {
													html += "<li><a onclick='ccc()' href='../templete/bmsh.jsp' target='frmright'><span class='text_slice'>部门审核</span></a></li>";
											}
											if (item.tjcx_qx == 0) {
													html += "<li><a onclick='ccc()' href='../templete/tongji.jsp' target='frmright'><span class='text_slice'>统计查询</span></a></li>";
											}
											html += "<li><a href='../templete/xtjs.html' target='frmright'><span class='text_slice'>系统介绍</span></a></li>";
											html += "<li><a href='../templete/bzwj.html' target='frmright'><span class='text_slice'>帮助文件</span></a></li>";
											html += "<li><a href='../templete/cjwtjd.html' target='frmright'><span class='text_slice'>常见问题解答</span></a></li>";
											
											}
											$("#category").html(html);

										});
					}
				});

	})
</script>
<body leftFrame="true">
	<div id="scrollContent">
		<div class="arrowlistmenu">
			<div class="menuheader expandable">系统菜单</div>
			<ul class="categoryitems" id="category">
			    <script>
			    <% 
         			Qx qx=(Qx)session.getAttribute("qx");
				%>
				
				
				var power =<%=qx.getPower()%>;
				var qx1=<%=qx.getTbqx()%>;
				var qx2=<%=qx.getXqgl()%>;
				var qx3=<%=qx.getYhxx()%>;
				var qx4=<%=qx.getXgmm()%>;
				var qx5=<%=qx.getXsshqx()%>;
				var qx6=<%=qx.getJssh()%>;
				var qx7=<%=qx.getTjcx()%>;
			
			var html = "";
			
			if (power == 1) {
				var m ;
				
				html += "<li><a href='../shouye/shouye_gl.jsp?no="+m+"' target='frmright'><span class='text_slice'>网站首页</span></a></li>"
					    +"<li><a href='../shgl/shgl_yhgl.jsp' target='frmright' ><span class='text_slice'>用户管理</span></a></li>"
						+ "<li><a href='../jsqx/jsgl.jsp' target='frmright'><span class='text_slice'>角色管理</span></a></li>"
						+ "<li><a href='../qxgl.jsp' target='frmright'><span class='text_slice'>权限管理</span></a></li>"
						+ "<li><a href='../MyJsp.jsp' target='frmright'><span class='text_slice'>综合查询</span></a></li>"
						
						+ "<li><a href='../shgl/shgl_xqgl.jsp' target='frmright' onclick='getList()'><span class='text_slice'>需求管理</span></a></li>"
						+ "<li><a href='../shgl/shgl_xssh_xqlb.jsp' target='frmright' onclick='getList3()'><span class='text_slice'>形式审核</span></a></li>"
						+ "<li><a href='../bmgl/bmgl_jssh_xqlb.jsp?no="+m+"' target='frmright' onclick='getList2()'><span class='text_slice'>部门审核</span></a></li>"
						+ "<li><a href='../tjcx/tjcx_shouye.jsp' target='frmright'><span class='text_slice'>统计查询</span></a></li>"
						+ "<li><a href='../xgmm/xgmm.jsp?no="+m+"' target='frmright'><span class='text_slice'>修改密码</span></a></li>"
						
						//$("#category").html(html);	
			}
			else{
				var m;
				    html += "<li><a href='../shouye/shouye_gl.jsp?no="+m+"' target='frmright'><span class='text_slice'>网站首页</span></a></li>"
			if (qx1 == 1) {
				var m;
					html += "<li><a href='../ask.jsp?no="+m+"' target='frmright'><span class='text_slice'>需求征集</span></a></li>";
			}
			if (qx2 == 1) {
				var m;
					html += "<li><a href='../yonghu/xqgl.jsp?no=' target='frmright' onclick='getList1()'><span class='text_slice'>需求管理</span></a></li>";
			}
			if (qx3 == 1) {
				var m;
					html += "<li><a href='../yonghu/yhxx.jsp?no="+m+"' target='frmright'><span class='text_slice'>用户信息</span></a></li>";
			}
			if (qx4 == 1) {
				var m;
					html += "<li><a href='../xgmm/xgmm.jsp?no="+m+"' target='frmright'><span class='text_slice'>修改密码</span></a></li>";
			}
			if (qx5 == 1) {
				var m;
					html += "<li><a href='../shgl/shgl_xssh_xqlb.jsp' target='frmright' onclick='getList3()'><span class='text_slice'>形式审核</span></a></li>";
			}
			if (qx6 == 1) {
				var m;
					html += "<li><a href='../bmgl/bmgl_jssh_xqlb.jsp?no="+m+"' target='frmright' onclick='getList2()'><span class='text_slice'>部门审核</span></a></li>";
			}
			if (qx7 == 1) {
				var m;
					html += "<li><a href='../tjcx/tjcx_shouye.jsp' target='frmright'><span class='text_slice'>统计查询</span></a></li>";
			}
			
			
			}
			document.write(html);
			</script>
				<!-- <li><a><span>第二级1</span></a>
					<ul>
						<li><a><span>第三极1</span></a>
							<ul>
								<li><a href="javascript:;"><span>第四级1</span></a></li>
								<li><a href="javascript:;"><span>第四级2</span></a></li>
							</ul></li>
						<li><a href="javascript:;"><span>第三极2</span></a></li>
						<li><a href="javascript:;"><span>第三极3</span></a></li>
					</ul>
				</li> -->
			</ul>
</body>
</html>
