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
				<td>
					<c:out value="${b.b_no}" />
				</td>
			</tr>
			<tr>
				<td>writer</td>
				<td>
					<c:out value="${b.name}" />
				</td>
			</tr>
			<tr>
				<td>title</td>
				<td>
					<c:out value="${b.title}" />
				</td>
			</tr>
			<tr>
				<td>content</td>
				<td>
					<c:out value="${b.content}" />
				</td>
			</tr>
			<c:if test="${not empty f}">
				<tr>
					<td>attached file</td>
					<td>empty</td>
				</tr>
			</c:if>
		</table>
		<c:if test="${user.email == b.email}">
			<a href="./boardModifyForm.do?b_no=${b.b_no}">modify</a>
			<a href="./boardDelete.do?b_no=${b.b_no}">delete</a>
		</c:if>

		<br>
		<div id="addReply">
			<form action="" name="addForm">
				<input type="text" name="replyContent" id="replyContent"><input type="button" value="comment" id="replyBtn">
			</form>
		</div>
		<div id="replyList">
			<table border="1">
				<thead>
					<tr>
						<th>writer</th>
						<th>comment</th>
						<th>reg_date</th>
						<th>mod/del</th>
					</tr>
				</thead>
				<tbody id="replyBody">
				</tbody>
			</table>

		</div>
	</div>
	<!-- JQuery Version 3.1.0 CDN -->
	<script src="http://code.jquery.com/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$replyBody = $("#replyBody");
			$.ajax({
				url : "reply_list_ajax.do",
				type : "post",
				datatype : 'json',
				data : {
					"b_no" : "${b.b_no}"
				},
				success : function(responseData) {
					var data = JSON.parse(responseData);
					if (!data) {
						return false;
					}
					var html = '';
					for (var i = 0; i < data.length; i++) {
						html += "<tr>";
						html += "<td>";
						html += data[i].name;
						html += "</td>";
						html += "<td>";
						html += data[i].content;
						html += "</td>";
						html += "<td>";
						html += data[i].reg_date;
						html += "</td>";
						html += "<td>";
						if (data[i].email === "${user.email}") {
							html += "<button type='button' class='replyModBtn' value='"+data[i].b_no+"'>mod</button>"
							html += "<a href='list.do'>del</a>"
						}
						html += "</td>";
						html += "</tr>";
					}
					$replyBody.html(html);
				}
			});
			
			$("#replyBtn").bind("click", function() {
				$.ajax({
					url : "reply_write_ajax.do",
					type : "post",
					datatype : 'json',
					data : {
						"email" : "${user.email}",
						"content" : $("#replyContent").val(),
						"b_no" : "${b.b_no}"
					},
					success : function(responseData) {
						var data = JSON.parse(responseData);
						if (!data) {
							return false;
						}
						var html = '';
						for (var i = 0; i < data.length; i++) {
							html += "<tr>";
							html += "<td>";
							html += data[i].name;
							html += "</td>";
							html += "<td>";
							html += data[i].content;
							html += "</td>";
							html += "<td>";
							html += data[i].reg_date;
							html += "</td>";
							html += "<td>";
							if (data[i].email === "${user.email}") {
								html += "<button type='button' class='replyModBtn' value='"+data[i].b_no+"'>mod</button>"
								html += "<a href='list.do'>del</a>"
							}
							html += "</td>";
							html += "</tr>";
						}
						$replyBody.html(html);
					}
				});
			});
		});
	</script>
</body>
</html>