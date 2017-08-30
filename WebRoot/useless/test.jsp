<%@ taglib prefix="s" uri="/struts-tags" %>
 <%@ page language="java" contentType="text/html; charset=utf-8" 
   pageEncoding="utf-8"%> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html><!-- 这样就能使用h5 -->
<html>
  <head> 
	 <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  

<!-- <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">/* 一定要在中间！ */ -->
 	  <script type="text/javascipt" src="lib/jquery-min.js"></script>
 <!-- 我把jquery-min.js的报错通过右键给取消检查了，如果以后不了可以使用上面的一行，那时借助网络到服务器上去获取jquery -->
 	  
	 <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	 <style type="text/css">

	 
	 </style>

 </head>
  
  <body>
		 <form action="demo_form.php" method="post">
		  <input type="text" name="fname" required>
		  <input type="submit" value="提交">
		</form>
  </body>
</html>
