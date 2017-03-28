<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<div id="header">
			<%@ include file="./attach/header.jsp"%>
		</div>
		
		<table border="1">
			<tr>
				<td>no</td>
				<td><c:out value="${b.b_no}"/></td>
			</tr>
			<tr>
				<td>writer</td>
				<td><c:out value="${b.name}"/></td>
			</tr>
			<tr>
				<td>title</td>
				<td><c:out value="${b.title }"/></td>
			</tr>
			<tr>
				<td>content</td>
				<td><c:out value="${b.content}"/></td>
			</tr>
			<c:if test="${not empty f}">
				<tr>
					<td>attached file</td>
					<td>empty</td>
				</tr>
			</c:if>
		</table>
		<c:if test="${user.email == b.email}">
			<a href="./boardModify.do?b_no=${b.b_no}">modify</a>
			<a href="./boardDelete.do?b_no=${b.b_no}">delete</a>
		</c:if>
	</div>
</body>
</html>