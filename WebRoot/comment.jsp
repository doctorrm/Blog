<%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ page language="java" contentType="text/html; charset=utf-8" 
   pageEncoding="utf-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML>
<html>
  <head> 
	 <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<!-- <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">/* 一定要在中间！ */ -->
 	  <script type="text/javascipt" src="lib/jquery-min.js"></script>
<!-- 我把jquery-min.js的报错通过右键给取消检查了，如果以后不了可以使用上面的一行，那时借助网络到服务器上去获取jquery --> 	  
	 <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>	 
 </head>
  
<!--描述：这是留言版块，可以由任何一个版块跳转而来 -->  
<!--功能：提供用户留言的界面和提交  -->
 <body style="background-color:#E5E5E5">
  <nav class="navbar navbar-default navbar-fixed-top">  
  
<div class="container" s>
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
					 <a href="/Blog/about_me.jsp">关于我</a>
				</li>
				<li class="active">
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

<h1>留言地带，有什么疑问欢迎大家共同探讨！</h1>
   <c:forEach items="${list}" var="list">
	<div  style="background-color:#ffffff;  height:20%;width:50%;margin-left:60px">	
	&nbsp;&nbsp;&nbsp;   <font color="#ff0000">${list.user }</font>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="#ff0000">${list.time }</font>
	<br>
	&nbsp;&nbsp;&nbsp;   <b>${list.content}</b>
	<hr>
	</div>								
   </c:forEach> 

<%request.setAttribute("id", 1); %>

<br><br><br><br>
<form action="/Blog/servlet/CommentLogic"   method="post">
	&nbsp;&nbsp;&nbsp;用户名:<input type="text" name="user" required/>
	<br><br>
	留言内容:<textarea name="content" style="height:300px;width:600px" ></textarea>
	<br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="提交" style="width:80px; height:30px"/>&nbsp;&nbsp;&nbsp;
	<input type="reset"  value="重填" style="width:80px; height:30px"/>
</form>

 
</body>
</html>
