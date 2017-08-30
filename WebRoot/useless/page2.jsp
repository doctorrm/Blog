<%-- <%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ page language="java" contentType="text/html; charset=utf-8" 
   pageEncoding="utf-8"%> 

<!DOCTYPE html>
<html>
  <head> 
  <script  type="text/javascript" src="jas.js"></script>
	 <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  

<!-- <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">/* 一定要在中间！ */ -->
 	  <script type="text/javascipt" src="lib/jquery-min.js"></script>
 <!-- 我把jquery-min.js的报错通过右键给取消检查了，如果以后不了可以使用上面的一行，那时借助网络到服务器上去获取jquery -->
 	  
	 <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	 
 </head>
  
  <body>
  
  <input type="button" value="添加到最后行" onclick="add(-1,'最后行');">
  <nav class="navbar navbar-default navbar-fixed-top">  
  
<div class="container">

	<div class="row clearfix">
		<div class="col-md-12 column">
			<ul class="nav nav-pills" >
				<li class="active">
					 <a href="/Blog/servlet/HomePage">首页</a>
				</li>
				<li>
					 <a href="/Blog/servlet/ListUser">所有文章</a>
				</li>
				<li >
					 <a href="./about_me.jsp">关于我</a>
				</li>
				<li>
					<a href="./comment.jsp">留言</a>
				</li>		
				<li>
					<a href="./write_blog.jsp">后台写博客</a>
				</li>
			</ul>
		</div>
	</div>
</div>
</nav>
<br><br><br>
<!-- 下面是文章 6-->
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h2 class="bl3og-post-title">
				<a href="./front/6.jsp">博文6</a>
			</h2>
			<p>
				<span>上一个主题是改自weisayheibai，对移动端支持不佳，一直想换成自适应的。最近终于能静下心来学习学习bootstrap。花了两周的时间布局出了自己的第一套主题，虽然绝大多数的样式还是bootstrap默认的，（逃… 主题整体风格还是保持上一版本的黑色调，布局基本没变。 如发现有什么问题，希望能通知我一下，thx~~</span>
			</p>
			<p>
				 <a class="btn" href="./front/6.jsp">查看文章 »</a>
			</p>
		</div>
	</div>
</div>
<!-- 下面是文章7 -->
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h2 class="bl3og-post-title">
				<a href="./front/7.jsp">博文7</a>
			</h2>
			<p>
				<span>上一个主题是改自weisayheibai，对移动端支持不佳，一直想换成自适应的。最近终于能静下心来学习学习bootstrap。花了两周的时间布局出了自己的第一套主题，虽然绝大多数的样式还是bootstrap默认的，（逃… 主题整体风格还是保持上一版本的黑色调，布局基本没变。 如发现有什么问题，希望能通知我一下，thx~~</span>
			</p>
			<p>
				 <a class="btn" href="./front/7.jsp">查看文章 »</a>
			</p>
		</div>
	</div>
</div>

<!-- 下面是文章8 -->
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h2 class="bl3og-post-title">
				<a href="#">博文8</a>
			</h2>
			<p>
				<span>上一个主题是改自weisayheibai，对移动端支持不佳，一直想换成自适应的。最近终于能静下心来学习学习bootstrap。花了两周的时间布局出了自己的第一套主题，虽然绝大多数的样式还是bootstrap默认的，（逃… 主题整体风格还是保持上一版本的黑色调，布局基本没变。 如发现有什么问题，希望能通知我一下，thx~~</span>
			</p>
			<p>
				 <a class="btn" href="#">查看文章 »</a>
			</p>
		</div>
	</div>
</div>

<!-- 下面是文章9 -->
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h2 class="bl3og-post-title">
				<a href="#">博文9</a>
			</h2>
			<p>
				<span>上一个主题是改自weisayheibai，对移动端支持不佳，一直想换成自适应的。最近终于能静下心来学习学习bootstrap。花了两周的时间布局出了自己的第一套主题，虽然绝大多数的样式还是bootstrap默认的，（逃… 主题整体风格还是保持上一版本的黑色调，布局基本没变。 如发现有什么问题，希望能通知我一下，thx~~</span>
			</p>
			<p>
				 <a class="btn" href="#">查看文章 »</a>
			</p>
		</div>
	</div>
</div>
<!-- 下面是文章10 -->
<!-- <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h2 class="bl3og-post-title">
				<a href="#">博文10</a>
			</h2>
			<p>
				<span>上一个主题是改自weisayheibai，对移动端支持不佳，一直想换成自适应的。最近终于能静下心来学习学习bootstrap。花了两周的时间布局出了自己的第一套主题，虽然绝大多数的样式还是bootstrap默认的，（逃… 主题整体风格还是保持上一版本的黑色调，布局基本没变。 如发现有什么问题，希望能通知我一下，thx~~</span>
			</p>
			<p>
				 <a class="btn" href="#">查看文章 »</a>
			</p>
		</div>
	</div>
</div> -->
<!-- 下面是分页 -->
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<ul class="pager" id="s">
				<li >
					 <a href="./index.jsp">上一页</a>
				</li>
				<li>
					 <a href="./index.jsp">1</a>
				</li>
				<li>
					 <a href="./page2.jsp">2</a>
				</li>
				
				<li >
					 <a href="./page2.jsp">下一页</a>
				</li>
			</ul>
		</div>
	</div>
</div>
  </body>
</html>
 --%>