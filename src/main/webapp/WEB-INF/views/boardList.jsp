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
			<thead>
				<tr>
					<th>no</th>
					<th>title</th>
					<th>writer</th>
					<th>reg_date</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty bList}">
						<tr>
							<th colspan="4"><c:out value="empty" /></th>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="b" items="${bList}">
							<fmt:formatDate value="${b.reg_date}" pattern="yyyy.MM.dd" var="regDate"/>
							<tr>
								<td><c:out value="${b.b_no}"/></td>
								<td><a href="./boardView.do?b_no=${b.b_no}"><c:out value="${b.title}"/></a></td>
								<td><c:out value="${b.name}"/></td>
								<td><c:out value="${regDate}"/></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<a href="./boardWriteForm.do">write</a>
	</div>
</body>
</html>