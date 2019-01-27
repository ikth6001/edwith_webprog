<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>예약 서비스</title>
	
	<style type="text/css">
		#container {
			height: 100%;
			width: 600px;
			margin-left: auto;
			margin-right: auto;
		}
		
		#areaGnb {
			background-color: gray;
			color: white;
			font-weight: bold;
		}
		
		#areaCategory {
			text-align: center;
			margin-top: 15px;
			margin-bottom: 15px;
		}
		
		.categoryBtn {
			display: inline-block;
			margin-left: 20px;
			margin-right: 20px;
			font-weight: bold;
			cursor: pointer;
		}
		
		.product {
			display: inline-block;
			width: 49%;
		}
		
		.product > div {
			text-align: center;
			margin: 10px;
		}
	</style>
	
</head>
<body>
	<div id="container">
		<div id="areaGnb">
			<div id="areaBtnToMain" style="display: inline-block;">
				<img src="images/mainLog.PNG" align="middle" style="margin: 5px;"> 예약
			</div>
			<div id="areaBtnReservInfo" style="display: inline-block; float: right; margin: 5px;">
				예약 확인
			</div>
		</div>
		<div id="areaPromotion">
			
		</div>
		<div id="areaCategory">
			<div class="categoryBtn" typeCode="ALL">전체 리스트</div>
			<div class="categoryBtn" typeCode="DPL">전시</div>
			<div class="categoryBtn" typeCode="MSC">뮤지컬</div>
			<div class="categoryBtn" typeCode="CRT">콘서트</div>
			<div class="categoryBtn" typeCode="CLS">클래식</div>
			<div class="categoryBtn" typeCode="THT">연극</div>
		</div>
		<div id="areaCount" style="text-align: center;">
			예약 가능한 공연이 ${count}개 있습니다.
		</div>
		<div id="areaProductList">
			<div class="product" id="productLeft">
				<div>left(1)</div>
				<div>left(2)</div>
			</div>
			<div class="product" id="productRight">
				<div>right(1)</div>
				<div>right(2)</div>
			</div>
		</div>
		<div id="areaBtnMore" style="text-align: center;">
			더 보기
		</div>
		<div id="areaBtnToTop" style="text-align: center;">
			^ TOP
		</div>	
	</div>
	
	<script id="promotionTemplate", type="text/template">
		<div class="promotionItem">
			<img src="${path}" width="600" height="200">
		</div>
	</script>
	
	<script type="text/javascript" src="javascript/index.js"></script>
</body>
</html>