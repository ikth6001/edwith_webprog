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
			
			cursor: pointer;
		}
		
		#btnNext {
			position: absolute;
			top: 50%;
			right: 16px;
			transform: translate(0%, -50%);
			
			cursor: pointer;
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
			
			cursor: pointer;
			
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
			<img id="titleImage" src="" width="100%" height="200px">
			
			<div id="imgCount" style="background-color: gray;">
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
			<div class="textContentsArea" id="productContents" style="height: 70px; overflow: hidden;">
				<c:out value="${productContents}" escapeXml="false"></c:out>
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
						<img src="<c:out value="${scoreImg}"></c:out>" width="100px" height="30px"> <b><c:out value="${avgScore}"></c:out></b> / 5.0
					</div>
					<div class="textContentsArea" style="float: right;">
						<c:out value="${commentCnt}"></c:out>건 등록
					</div>
					<hr width="100%">
				</div>
			</div>
			<div>
				<div class="textContentsArea"><c:out value="${commentContents}" escapeXml="false"></c:out></div>
				<div class="textContentsArea"><b><c:out value="${score}"></c:out></b>&nbsp;&nbsp; <c:out value="${userMail}"></c:out> &nbsp;&nbsp;<c:out value="${wDate}"></c:out></div>
			</div>
		</div>
		<div id="btnCommentMore">
			<spring:message code="btn.comment.more"/>→
		</div>
		<hr width="100%" style="border: 0; height: 10px; background: #ccc;">
		<div id="reservInfoTabContainer">
			<div class="tabMenu" id="detailArea"><spring:message code="tab.detial"/></div>
			<div class="tabMenu" id="mapArea"><spring:message code="tab.map"/></div>
			<hr width="100%">
			<div class="textContentsArea" id="mainArea"></div>
		</div>
		
		<div id="displayInfoId" style="display: none;">
			<c:out value="${displayInfoId }"></c:out>
		</div>
	</div>
	
	<script id="detailMainTemplate" type="text/template">
		[주의]
		예약에 주의할 사항 및 공지사항이 있습니다.<br>
		아래 사항을 꼭 읽어 보시기 바랍니다.
		<br><br>
		<img src="{{notice_img}}" width="400px" height="600px">
	</script>
	
	<script id="mapMainTemplate" type="text/template">
		<img src="img_map/1_map_1.png">

		<H1>{{place_name}}</H1>
		{{place_address}}<br>
		{{phone_number}}<br>
	</script>
	
	<script id="label.comment.ctn" type="text/message">
		<spring:message code="label.comment.ctn"/>
	</script>
	
	<script type='text/javascript' src='js/handlebars-v4.1.0.js'></script>
	<script type="text/javascript" src="js/detail.js"></script>
	
</body>
</html>