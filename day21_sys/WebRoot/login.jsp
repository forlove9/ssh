<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/LoginServlet" method="post" name="frm">
    	<table border="1" align="center">
    		<tr>
    			<td>用户名</td>
    			<td><input type="text" name="username"></td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td><input type="text" name="pwd"></td>
    			</tr>
    		<tr>
    			<td><input type="submit"  value="亲，点我登陆"></td>
    			
    		</tr>
    	</table>
    </form>
  </body>
</html>
