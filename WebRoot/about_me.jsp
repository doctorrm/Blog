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
 </head>
 
<!--描述：这是'关于我'版块，可以由任何一个版块跳转而来  -->
<!--功能： 介绍自己，未开发 -->  
 <body>
 
  <nav class="navbar navbar-default navbar-fixed-top">   
  <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<ul class="nav nav-pills">
				<li >
					 <a href="/Blog/servlet/HomePage">首页</a>
				</li>
				<li>
					 <a href="/Blog/servlet/ListUser">所有文章</a>
				</li>
				<li class="active">
					 <a href="/Blog/about_me.jsp">关于我</a>
				</li>
				<li>
					<a href="/Blog/servlet/CommentLogic">留言</a>
				</li>		
				<li>
					<a href="/Blog/write_blog.jsp">后台写博客</a>
				</li>	
			</ul>
		</div>
	</div>
  </div>
  </nav>
<br><br><br>
	
	<h1>大家好，这是我第一次做的个人博客，从2017/3/4开始着手。</h1>
	<p>有什么问题欢迎大家留言，我会尽快第一时间回复！</p>
	

 
  </body>
</html>
