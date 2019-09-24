<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'list.jsp' starting page</title>

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
    <h1>欢迎您,${sessionScope.loginInfo.username}</h1>
    <table>
    	<tr>
  			<td>序号</td>
  			<td>编号</td>
  			<td>员工名称</td>
  		</tr>
  		<tr>
  		<c:if test="${not empty requestScope.listEmp }"></c:if>
  			<c:forEach var="emp" items="listEmp" varStatus="vs">
  				<td>${vs.count }</td>
		  			<td>${emp.empId }</td>
		  			<td>${emp.empName }</td>
  			</c:forEach>
  		</tr>
    </table>
  </body>
</html>
