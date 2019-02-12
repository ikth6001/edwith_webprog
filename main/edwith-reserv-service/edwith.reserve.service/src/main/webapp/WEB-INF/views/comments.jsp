<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><spring:message code="title.site"/></title>
	
	<style type="text/css">
		#container {
			height: 100%;
			width: 600px;
			margin-left: auto;
			margin-right: auto;
			border: solid 1px gray;
		}
		
		.textContentsArea {
			padding: 10px;
		}
	</style>
	
</head>
<body>
	<div id="container">
		<div id="commentArea">
			<div>
				<div class="textContentsArea"><b><spring:message code="label.comment"/></b></div>
				<div>
					<div class="textContentsArea" style="display: inline-block;">
						<img src="<c:out value="${scoreImg}"></c:out>" width="100px" height="30px"> <b><c:out value="${avgScore}"></c:out></b> / 5.0
					</div>
					<div class="textContentsArea" style="float: right;">
						<c:out value="${commentCnt}"></c:out>건 등록
					</div>
					<hr width="100%">
				</div>
			</div>
			<div>
				<c:forEach var="comment" items="${comments}">
					<div class="textContentsArea"><c:out value="${comment.comment}" escapeXml="false"></c:out></div>
					<div class="textContentsArea"><b><c:out value="${comment.score}"></c:out></b>&nbsp;&nbsp; <c:out value="${comment.reservationEmail}"></c:out> &nbsp;&nbsp; <c:out value="${comment.createDate}"></c:out></div>
					<hr width="100%">
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>