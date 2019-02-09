<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>예약 서비스</title>
	
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
		
		#center {
			position: absolute;
			top: 50%;
			left: 50%;
			transform: translate(-50%, -50%);
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
		<div id="titleArea">
			<img src="img/1_ma_2.png" width="100%" height="300px">
			
			<div id="topLeft">
				<img src="img/reserv_icon.png" width="60px" height="30px">
			</div>
			
			<div id="topRight" style="font-weight: bold; color: white;">
				예약 확인
			</div>
			
			<div id="center" style="font-weight: bold; color: white; font-size: xx-large;">
				<c:out value="${title}"></c:out>
			</div>
		</div>
		<div>
			<div class="textContentsArea" id="productContents" style="height: 100px; overflow: hidden;">
				<c:out value="${productContents}"></c:out>
			</div>
			<div id="btnCollapseSpand">펼쳐보기▽</div>
		</div>
		<div>
			<div class="textContentsArea" style="font-weight: bold;">이벤트 정보</div>
			<hr width="100%" style="margin: 0px">
			<div class="textContentsArea" id="eventContents">
				<c:out value="${eventContents}"></c:out>
			</div>
		</div>
		<div id="btnReserveArea">예매하기</div>
		<div id="commentArea">
			<div>
				<div class="textContentsArea"><b>예매자 한줄평</b></div>
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
				<div class="textContentsArea"><b><c:out value="${score}"></c:out></b>&nbsp;&nbsp; <c:out value="${userId}">&nbsp;&nbsp; </c:out><c:out value="${wDate}"></c:out></div>
			</div>
		</div>
		<div id="btnCommentMore">
			예매자 한줄평 더보기→
		</div>
		<hr width="100%" style="border: 0; height: 10px; background: #ccc;">
		<div id="reservInfoTabContainer">
			<div class="tabMenu" id="tabArea">상세정보</div>
			<div class="tabMenu" id="mainArea">오시는길</div>
			<hr width="100%">
			<div class="textContentsArea">
				<c:out value="${reserveDetail}"></c:out>건 등록
			</div>
		</div>
	</div>
</body>
</html>