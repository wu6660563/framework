<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  
  	<form action="${pageContext.request.contextPath}/app/api.do" method="post">
  		osType:<input name="osType" type="text" value="1"/><br/>
  		apiId:<input name="apiId" type="text" value="10000"/><br/>
  		version:<input name="version" type="text" value="10000"/><br/>
  	
  		phone:<input name="phone" type="text"/><br/>
  		email:<input name="email" type="text"/><br/>
  		user_name:<input name="user_name" type="text"/><br/>
  		content:<input name="content" type="text"/><br/>
  		customer_id:<input name="customer_id" type="text"/><br/>
  		netflow_type:<input name="netflow_type" type="text"/><br/>
  		version_number:<input name="version_number" type="text"/><br/>
  	</form>
  </body>
</html>
