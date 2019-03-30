<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> <!-- Templating 때문에 EL 표기법 사용 안 함 > 취소. EL을 사용 안하면 JSTL이 동작 안함;; -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

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
		
		#areaGnb {
			background-color: #F1F6F2;
			font-weight: bold;
		}
		
		.textContentsArea {
			padding: 10px;
		}
	</style>
	
</head>
<body>
	<div id="container">
		<div id="areaGnb">
			<div id="areaBtnToMain" style="display: inline-block;  cursor: pointer;" onclick="onClickToMain()">
				<img src="img/mainLog.png" align="middle" style="margin: 5px;"> 예약
			</div>
			<div id="areaBtnReservInfo" style="display: inline-block; float: right; margin: 5px;">
				<div style="display: inline-block;">
					<a href= "/edwith.reserve.service/reservationList"><c:out value="${userName}"/></a>
					<a href= "<c:out value="${loginReqUrl}"/>"><c:out value="${logInOut}"/></a> 
				</div>
			</div>
		</div>
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
	
	<script type="text/javascript">
		function onClickToMain() {
			var btnToMain= document.getElementById('areaBtnToMain');
			btnToMain.addEventListener('click', function() {
				window.location.href= '/edwith.reserve.service';
			});
		}
	</script>
</body>
</html>