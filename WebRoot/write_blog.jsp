<%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ page language="java" contentType="text/html; charset=utf-8" 
   pageEncoding="utf-8"%> 
<!DOCTYPE HTML >
<html>
 <head>
<link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<!-- <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">/* 一定要在中间！ */ -->
<script type="text/javascipt" src="lib/jquery-min.js"></script>
<!-- 我把jquery-min.js的报错通过右键给取消检查了，如果以后不了可以使用上面的一行，那时借助网络到服务器上去获取jquery -->
<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<!-- 配置文件 -->
	<script type="text/javascript" src="ueditor/ueditor.config.js">		
	</script>
		<!-- 编辑器源码文件 -->
	<script type="text/javascript" src="ueditor/ueditor.all.js">		
	</script>
		<!-- 实例化编辑器 -->
	<style type="text/css">			
	</style>

 </head>   
<!-- 描述：这是后台撰写博客的版块，可以由任何一个版块跳转而来，HERE-to-CommitBlog.java-->
<!-- 功能：提供编辑区并提交博客-->
 <body>  
<nav class="navbar navbar-default navbar-fixed-top">  
<div class="container " >
	<div class="row clearfix">
		<div class="col-md-12 column">
			<ul class="nav nav-pills">
				<li >
					 <a href="/Blog/servlet/HomePage">首页</a>
				</li>
				<li>
					 <a href="/Blog/servlet/ListUser">所有文章</a>
				</li>
				<li >
					 <a href="./about_me.jsp">关于我</a>
				</li>
				<li>
					<a href="/Blog/servlet/CommentLogic">留言</a>
				</li>
				<li class="active">
					<a href="/Blog/write_blog.jsp">后台写博客</a>
				</li>		
			</ul>
		</div>
	</div>
</div>
</nav>
  <br><br><br>
  
  					<!-- 用户输入博客标题 -->
  <form action="/Blog/servlet/CommitBlog" method="post">
    
    <h3>标题：<input type="text" name="title" /></h3>
	  <input type="submit" value="提交" style="height:40px ;width:150px"/>
<br>
					<!-- Ueditor编辑器 -->
	 <script
		id="container" name="content" 
		style="width:1024px;height:400px;" type="text/plain">
	</script>
	<script type="text/javascript">
		var ue = UE.getEditor('container');
	</script> 
	
   </form>
 
  </body>
</html>
