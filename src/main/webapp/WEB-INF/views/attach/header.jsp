<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:choose>
	<c:when test="${empty user}">
		<form action="./login.do" method="post" accept-charset="utf-8">
			<input type="email" name="email" required> <input type="password" name="password" required> <input type="submit" value="Log in">
		</form>
	</c:when>
	<c:otherwise>
			Welcome, <c:out value="${user.name}"/>! <a href="./logout.do">Log out</a>
		<a href="./list.do">go to board</a>
	</c:otherwise>
</c:choose>
<hr>
