<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
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
		
		#titleArea {
			position: relative;
			width: 100%;
		}
		
		#topLeft {
			display: inline;
			
			position: absolute;
			top: 16px;
			left: 16px;
		}
		
		#topRight {
			display: inline;
			
			position: absolute;
			top: 16px;
			right: 16px;
		}
		
		#imgCount {
			position: absolute;
			top: 25%;
			left: 50%;
			transform: translate(-50%, -50%);
			font-weight: bold;;
			color: white;
		}
		
		#center {
			position: absolute;
			top: 50%;
			left: 50%;
			transform: translate(-50%, -50%);
		}
		
		#btnPrev {
			position: absolute;
			top: 50%;
			left: 16px;
			transform: translate(0%, -50%);
		}
		
		#btnNext {
			position: absolute;
			top: 50%;
			right: 16px;
			transform: translate(0%, -50%);
		}
		
		#btnCollapseSpand {
			width: 100%;
			height: 30px;
			background-color: silver;
			
			text-align: center; 
			padding-top: 15px;
			
			font-weight: bold;
			color: white;
			
			cursor: pointer;
		}
		
		.textContentsArea {
			padding: 10px;
		}
		
		#btnReserveArea {
			width: 100%;
			height: 30px;
			background-color: green;
			
			text-align: center; 
			padding-top: 15px;
			
			font-weight: bold;
			color: white;
			
			cursor: pointer;
		}
		
		#btnCommentMore {
			width: 100%;
			height: 30px;
			
			text-align: center; 
			padding-top: 15px;
			
			font-weight: bold;
			cursor: pointer;
		}
		
		.tabMenu {
			display: inline-block;
			text-align: center;
			
			margin-top: 10px;
			margin-bottom: 10px;
			
			font-weight: bold;
			font-size: large;
			
			width: 49%;
		}
	</style>
	
</head>
<body>
	<div id="container">
		<div id="areaGnb">
			<div id="areaBtnToMain" style="display: inline-block;">
				<img src="img/mainLog.png" align="middle" style="margin: 5px;"> 예약
			</div>
			<div id="areaBtnReservInfo" style="display: inline-block; float: right; margin: 5px;">
				<spring:message code="label.nologin"/>
			</div>
		</div>
		<div id="titleArea">
			<img src="<c:out value="${productMainImg}"></c:out>" width="100%" height="200px">
			<%-- <div id="topLeft">
				<img src="img/reserv_icon.png" width="60px" height="30px">
			</div>
			
			<div id="topRight" style="font-weight: bold; color: white;">
				<spring:message code="label.nologin"/>
			</div> --%>
			
			<div id="imgCount">
				1 / <c:out value="${imgCount}"></c:out>
			</div>
			<div id="btnPrev">
				<img src="img/btn_prev.png">
			</div>
			<div id="btnNext">
				<img src="img/btn_next.png">
			</div>
			
			<div id="center" style="font-weight: bold; color: white; font-size: xx-large;">
				<c:out value="${title}"></c:out>
			</div>
		</div>
		<div>
			<div class="textContentsArea" id="productContents" style="height: 100px; overflow: hidden;">
				<c:out value="${productContents}"></c:out>
			</div>
			<div id="btnCollapseSpand"><spring:message code="btn.expand"/>▽</div>
		</div>
		<div>
			<div class="textContentsArea" style="font-weight: bold;"><spring:message code="label.event"/></div>
			<hr width="100%" style="margin: 0px">
			<div class="textContentsArea" id="eventContents">
				<c:out value="${eventContents}"></c:out>
			</div>
		</div>
		<div id="btnReserveArea"><spring:message code="btn.reserve"/></div>
		<div id="commentArea">
			<div>
				<div class="textContentsArea"><b><spring:message code="label.comment"/></b></div>
				<div>
					<div class="textContentsArea" style="display: inline-block;">
						<img src="a"> <b><c:out value="${avgScore}"></c:out></b> / 5.0
					</div>
					<div class="textContentsArea" style="float: right;">
						<c:out value="${commentCnt}"></c:out>건 등록
					</div>
					<hr width="100%">
				</div>
			</div>
			<div>
				<div class="textContentsArea"><c:out value="${commentContents}"></c:out></div>
				<div class="textContentsArea"><b><c:out value="${score}"></c:out></b>&nbsp;&nbsp; <c:out value="${userId}"></c:out> &nbsp;&nbsp;<c:out value="${wDate}"></c:out></div>
			</div>
		</div>
		<div id="btnCommentMore">
			<spring:message code="btn.comment.more"/>→
		</div>
		<hr width="100%" style="border: 0; height: 10px; background: #ccc;">
		<div id="reservInfoTabContainer">
			<div class="tabMenu" id="tabArea"><spring:message code="tab.detial"/></div>
			<div class="tabMenu" id="mainArea"><spring:message code="tab.map"/></div>
			<hr width="100%">
			<div class="textContentsArea">
				<c:out value="${reserveDetail}"></c:out>
			</div>
		</div>
	</div>
	
	<script id=hiddenImgs" type="text/hiddenData">
		<c:out value="${hiddenImgs}"></c:out>
	</script>
	
	<script id="label.comment.ctn" type="text/message">
		<spring:message code="label.comment.ctn"/>
	</script>
</body>
</html>