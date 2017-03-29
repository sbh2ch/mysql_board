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
			<form action="" name="modForm">
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
			</form>
		</div>
	</div>
	<!-- JQuery Version 3.1.0 CDN -->
	<script src="http://code.jquery.com/jquery-3.2.1.js" type="text/javascript"></script>
	<script type="text/javascript">
		var selectNum;
		var replyListUp = function() {
			var $replyBody = $("#replyBody");

			$.ajax({
				url : "reply_list_ajax.do",
				type : "post",
				datatype : 'json',
				data : {
					"b_no" : "${b.b_no}",
				},
				success : function(data) {
					console.log('success');
					$replyBody.html(data);
					bindModBtn();
					$(".replyModCls > button").bind("click", bindModSubmitBtn);
				},
				error : function(request, status, error) {
					alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
				}
			});
		}

		var bindModBtn = function() {
			$(".replyModBtn").bind("click", function() {
				selectNum = $(this).val();
				$(".replyModCls").css("display", "none");
				$("#replyModInput" + selectNum).css("display", "block");
			});
		}

		var bindModSubmitBtn = function() {
			console.log('clicked = >', $("#replyModInput" + selectNum).children().first().val());
			$.ajax({
				url : "reply_mod_ajax.do",
				type : "post",
				datatype : 'json',
				data : {
					"email" : "${user.email}",
					"content" : $("#replyModInput" + selectNum).children().first().val(),
					"r_no" : selectNum
				},
				success : function(data) {
					replyListUp();
				}
			});
		}

		var replyWrite = function() {
			$.ajax({
				url : "reply_write_ajax.do",
				type : "post",
				datatype : 'json',
				data : {
					"email" : "${user.email}",
					"content" : $("#replyContent").val(),
					"b_no" : "${b.b_no}"
				},
				success : function(data) {
					replyListUp();
				}
			});
		}

		$(document).ready(function() {
			$("#replyBtn").bind("click", replyWrite);
			replyListUp();
		});
	</script>
</body>
</html>