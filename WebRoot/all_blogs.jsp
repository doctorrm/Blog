<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML >
<html>
 <head>
  <jsp:include page="./nav2.jsp"/>

  <style type="text/css">
	th,td{width: 150px;border: 2px solid gray;text-align: center;}
	body{text-align: center;}
	a{text-decoration: none;}
	table {border-collapse: collapse;}
  </style>

 </head>
<!-- 描述：这是第二个版块'所有文章'，属于后台，可以从任何一个版块跳转而来 -->
<!-- 功能：显示博文的链接和修改、删除功能；这是用于分页的jsp文件,与servlet交互很频繁，所以建议有分页的都要新建一个servlet文件  -->
 <body>

	<%-- 	<%int int_id=(Integer)request.getAttribute("int_id");%>
		<%System.out.println(int_id); %>
		<c:if test="${int_id==1 }">
		<%System.out.println("this is the 1!!!!!!!!"); %>		
		</c:if> --%><!-- 注释的是显示博文前几十个字的功能，因为ueditor的问题，现在格式有点问题。。。 -->

								<!-- 第一部分，没什么 -->

		<h2 align="center">博文信息</h2>
		<table align="center">
			<tr><td>博客标题</td><td>删除</td><td>修改</td></tr>
		</table>
								<!-- 第二部分，显示查到的5行数据 （先获取listss，然后再取里面的字段）-->
		<font size=5>
			<table align="center">
				<c:forEach items="${listss}" var="person">
				<tr>				
					<td class="hidden-480">
					<a href="/Blog/servlet/BlogDetailedContent?toPage=${person.id }&id=2">${person.number}</a>
					</td>
					<td><a href="/Blog/servlet/DeleteBlog?toPage=${person.id }">删除</a></td>
					<td><a href="/Blog/servlet/FetchContentBeforeUpdate?toPage=${person.id }">修改</a></td>
					<!-- id代表博客序号、name代表博客内容、number代表博客标题-->
				</tr>
				</c:forEach>
			</table>
		</font>
<br>
								<!-- 第三部分，首页、末页、上一页、下一页 ，点击链接后也会把pageNos传给servlet，
								话说servlet缺的就是这个,pageNos的范围是【1，recordCount】-->
<ul class="pager">
		<c:if test="${pageNos>0 }">
		<li><a href="/Blog/servlet/ListUser?pageNos=1" >首页</a></li>	
			
			<c:if test="${pageNos>1 }">	
				<li><a href="/Blog/servlet/ListUser?pageNos=${pageNos-1}">上一页</a></li>
			</c:if>
				<c:if test="${pageNos<2 }">
			<li><a href="/Blog/servlet/ListUser?pageNos=1">上一页</a></li>
			</c:if>

		</c:if>
				<!--  -->		<!--  -->		<!--  -->	<!--  -->		
		<c:if test="${pageNos <recordCount+1 }">				
				
			<c:if test="${pageNos<recordCount }">
				<li><a href="/Blog/servlet/ListUser?pageNos=${pageNos+1 }">下一页</a></li>
			</c:if>
			<c:if test="${pageNos>recordCount-1 }">
				<li><a href="/Blog/servlet/ListUser?pageNos=${recordCount }">下一页</a></li>		
			</c:if>
			<li><a href="/Blog/servlet/ListUser?pageNos=${recordCount }">末页</a></li>

		</c:if>
</ul>
		<!-- 第四部分是一个表单，显示总页数和负责跳转，输入指定页数后pageNos,会传给servlet数值 。
		${pageNos}调用的是它自己的name值，用于显示;text表示文本框-->
		<form action="/Blog/servlet/ListUser">
			<h4 align="center">共${recordCount}页  
			<input type="text" value="${pageNos}" name="pageNos" size="1">页
			<input type="submit" value="到达">
			</h4>
		</form>
		
 
 </body>
</html>
