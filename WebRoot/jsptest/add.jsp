<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>


  <head>
    <title>MyBatis整合Spring3.0.5</title>
  </head>
  <body>
		<!-- 这里写入当前页面的jsp代码 -->
		<h3>add account</h3>
		<form name="accountModel" method="post" action="${pageContext.request.contextPath}/account/addSubmit.do">
			<table>
				<tr>
					<td>
						username:
					</td>
					<td>
						<input type="text" name="username" />
					</td>
				</tr>
				<tr>
					<td>
						password:
					</td>
					<td>
						<input type="password" name="password" />
					</td>
				</tr>
				<tr>
					<td>
						email:
					</td>
					<td>
						<input type="text" name="email" />
					</td>
				</tr>
				<tr>
					<td>
						address:
					</td>
					<td>
						<input type="text" name="address" />
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="submit" value="Save" />
					</td>
				</tr>
			</table>
		</form> 
  </body>
</html>
