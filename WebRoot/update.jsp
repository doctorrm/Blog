<%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ page language="java" contentType="text/html; charset=utf-8" 
   pageEncoding="utf-8"%> 

<!DOCTYPE HTML >
<html>
<head>
  <jsp:include page="./nav2.jsp"/>
      
	 <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<!-- <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">/* 一定要在中间！ */ -->
 	  <script type="text/javascipt" src="lib/jquery-min.js"></script>
 <!-- 我把jquery-min.js的报错通过右键给取消检查了，如果以后不了可以使用上面的一行，那时借助网络到服务器上去获取jquery --> 	  
	 <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	 								<!-- 配置编辑器 -->
	    <!-- 配置文件 -->
	<script type="text/javascript" src="/Blog/ueditor/ueditor.config.js">		
	</script>
		<!-- 编辑器源码文件 -->
	<script type="text/javascript" src="/Blog/ueditor/ueditor.all.js">		
	</script>
		<!-- 实例化编辑器 -->
	<style type="text/css">			
	</style>
</head>   
<!-- 注意因为这个文件是被servlet（update.java）使用到的 ，
所以在ueditor的路径要加上/Blog，否则找不到路径，也就是不会出现编辑器-->		

<!-- 描述：这是第二个版块'所有文章'点击“修改”链接后从跳转而来的修改博文的编辑区界面，UpdateLogic.java-to-HERE-->
<!-- 功能：后台修改博客内容 -->
 <body>

<%int id=(Integer)request.getAttribute("blog_id");%>
<% session.setAttribute("override_id",id); %>  


  <form action="/Blog/servlet/SaveContentAfterUpdate" method="post">
    <h3>标题：<input type="text" name="title" value="${blog_title}" /></h3>
	  <input type="submit" value="提交" style="height:40"/>
<br>				
				<!-- 下面是编辑器 -->
	<script
		id="container" name="content" value="${blog_content }"
		style="width:1024px;height:400px;" type="text/plain">
	</script>
	<script type="text/javascript">
		var ue = UE.getEditor('container');
	</script> 
	  
	  
  </form>

 
 </body>
</html>
