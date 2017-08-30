<%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ page language="java" contentType="text/html; charset=utf-8" 
   pageEncoding="utf-8"%> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html><!-- 这样就能使用h5 -->
<html>
  <head> 
<jsp:include  page="./nav1.jsp"></jsp:include>

	 <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<!-- <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">/* 一定要在中间！ */ -->
 	  <script type="text/javascipt" src="lib/jquery-min.js"></script>
 	<!-- 我把jquery-min.js的报错通过右键给取消检查了，如果以后不了可以使用上面的一行，那时借助网络到服务器上去获取jquery -->	  
	 <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 </head>
 
<!-- 注释不能放开头！否则效果会出不来 -->
<!-- 描述：这个是‘首页’界面，可以从任何一个版块跳转而来，每页5篇，还有分页，HomePage.java-to-HERE -->
<!-- 功能：因为在这之前刚刚经过HomePage.java的处理，在这就可以显示博文信息了--> 

 <body style="background-color:#E5E5E5">

					<!-- 显示查到的5行数据 （先获取listss，然后再取里面的字段）-->
  <div style="float:left;width:60%;margin-left:60px;margin-top:20px;height:500px">
	<c:forEach items="${listss}" var="person">
	 <div  style="background-color:#ffffff;height:20%">
	  <font  size=5;>
		&nbsp;&nbsp;&nbsp;<a href="/Blog/servlet/BlogDetailedContent?toPage=${person.id }&id=1">${person.number}</a><br>		
		
			<%-- <p>
			<c:set var="msg" value="${person.name}"/>
			&nbsp;&nbsp;&nbsp;${fn:substring(msg,0,250)}...
			</p> --%><!-- （a,b]，a最小为0,此处为取1-250共250个博客字符显示在首页 -->
		
		&nbsp;&nbsp;&nbsp;<a href="/Blog/servlet/BlogDetailedContent?toPage=${person.id }&id=1">查看文章»</a>
				<!-- id代表博客序号、name代表博客内容、number代表博客标题-->		
	  </font>
	 </div>		
	<br style="height:2%">							
	</c:forEach> 
  </div>
<!-- 上面整个是左侧的div，注意要包围里面的循环div -->

<!-- 这个是右侧的div -->
	<div style="height:500px;width:23%;float:right;margin-right:60px;margin-top:20px">
	
	<div style="background-color:#000000;height:45%;margin-top:10px;text-align:center"><font color="#ffffff" size=4>
		<a style="color:#ffffff"><b>我的信息</b></a>
	</font></div>
	<br>
	<div style="background-color:#ddffff;height:45%;text-align:center"><font size=4>
		<a style="color:#000000"><b>推荐博文</b></a>
	</font></div>
	
	</div>

<!--  --><!--  --><!--  --><!--  --><!--  --><!--  --><!--  --><!--  --><!--  --><!--  -->


		<!-- 首页、末页、上一页、下一页 ，点击链接后也会把pageNos传给servlet，
								话说servlet缺的就是这个,pageNos的范围是【1，recordCount】-->
  <div id="bottom" style="float:left;margin-left:56px;height:60px;width:280px;margin-top:80px" >
   <ul class="pager">
		<c:if test="${pageNos>0 }">
		<li><a href="/Blog/servlet/HomePage?pageNos=1" >首页</a></li>	
		
			<c:if test="${pageNos>1 }">	
				<li><a href="/Blog/servlet/HomePage?pageNos=${pageNos-1}">上一页</a></li>
			</c:if>
				<c:if test="${pageNos<2 }">
			<li><a href="/Blog/servlet/HomePage?pageNos=1">上一页</a></li>
			</c:if>

		</c:if>
		
		
		<c:if test="${pageNos <recordCount+1 }">				
				
			<c:if test="${pageNos<recordCount }">
				<li><a href="/Blog/servlet/HomePage?pageNos=${pageNos+1 }">下一页</a></li>
			</c:if>
			<c:if test="${pageNos>recordCount-1 }">
				<li><a href="/Blog/servlet/HomePage?pageNos=${recordCount }">下一页</a></li>		
			</c:if>
			<li><a href="/Blog/servlet/HomePage?pageNos=${recordCount }">末页</a></li>

		</c:if>
   </ul>
 </div> 
	<!-- style中的clear:both;很重要，是换行div的命令 -->
  	<!-- 一个表单，显示总页数和负责跳转，输入指定页数后pageNos,会传给servlet数值 。
		${pageNos}调用的是它自己的name值，用于显示;text表示文本框-->
		
<div style="float:left;margin-left:10px;height:50px;margin-top:95px">
		<form action="/Blog/servlet/HomePage">
			<h4 align="center">
				共${recordCount}页  
				<input type="text" value="${pageNos}" name="pageNos" size="1">页
				<input type="submit" value="到达">
			</h4>
		</form>
</div>


 </body>
</html>
