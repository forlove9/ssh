<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
	 <!-- 包含头部页面 -->
  	 <s:form action="emp_save.action" method="post" theme="simple">
  	 <table border="1" align="center" cellpadding="5" cellspacing="0">
  	 	<tr>
  	 		<td>员工姓名</td>
  	 		<td>
  	 			<s:textfield name="empName" id="empName" value=""></s:textfield>
  	 		</td>
  	 	</tr>
  	 	<tr>
  	 		<td>员工薪水</td>
  	 		<td>
  	 			<s:textfield name="salary" id="salary" value=""></s:textfield>
  	 		</td>
  	 	</tr>
  	 	<tr>
  	 		<td>选择部门</td>
  	 		<td>
  	 			  <s:select
  	 			  	name="deptId" 
  	 			  	headerKey="-1"
  	 			  	headerValue="请选择"
  	 			  	list="#request.listDept"
  	 			  	listKey="id"
  	 			  	listValue="name"
  	 			  	value="-1"
  	 			  ></s:select>
  	 		</td>
  	 	</tr>
  	 	<tr>
  	 		<td colspan="2">
  	 			<s:submit value="添加员工"></s:submit>
  	 		</td>
  	 	</tr>
  	 </table>
  	 </s:form>
  </body>
</html>
