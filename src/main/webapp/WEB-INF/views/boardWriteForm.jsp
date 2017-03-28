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
		<form action="./boardWrite.do" method="post" accept-charset="utf-8">
			<table border="1">
				<tr>
					<td>title</td>
					<td><input type="text" name="title" required></td>
				</tr>
				<tr>
					<td>content</td>
					<td><textarea rows="20" cols="40" name="content" required></textarea></td>
				</tr>
			</table>
			<input type="submit" value="write">
		</form>
	</div>
</body>
</html>