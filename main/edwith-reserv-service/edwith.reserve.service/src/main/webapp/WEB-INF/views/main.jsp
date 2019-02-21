<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> <!-- Templating 때문에 EL 표기법 사용 안 함 > 취소. EL을 사용 안하면 JSTL이 동작 안함;; -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		}
		
		#areaGnb {
			background-color: #F1F6F2;
			font-weight: bold;
		}
		
		#areaCategory {
			text-align: center;
			margin-top: 15px;
			margin-bottom: 15px;
		}
		
		#areaProductList {
			background-color: #F1F6F2;
			margin-bottom: 15px;
		}
		
		#areaBtnMore {
			margin-bottom: 15px;
			cursor: pointer;
		}
		
		#areaBtnToTop {
			margin-bottom: 15px;
			cursor: pointer;
		}
		
		/* .categoryBtn {
			display: inline-block;
			margin-left: 20px;
			margin-right: 20px;
			font-weight: bold;
			cursor: pointer;
		} */
		
		.areaProduct {
			display: inline-block;
			width: 49%;
		}
		
		.areaProduct > div {
			text-align: center;
			margin: 10px;
		}
	</style>
	
</head>
<body>
	<div id="container" style="border: solid 1px gray;">
		<div id="areaGnb">
			<div id="areaBtnToMain" style="display: inline-block;">
				<img src="img/mainLog.png" align="middle" style="margin: 5px;"> 예약
			</div>
			<div id="areaBtnReservInfo" style="display: inline-block; float: right; margin: 5px;">
				<spring:message code="label.nologin"/>
			</div>
		</div>
		<div id="areaPromotion" style="vertical-align: top; height: 200px; width: 600px; overflow: hidden;"></div>
		<div id="areaCategory">
			<div class="categoryBtn" categoryId="0" style="display: inline-block; margin-left: 20px; margin-right: 20px; font-weight: bold; cursor: pointer;">
				<spring:message code="category.all"/>
			</div>
			<!-- <div class="categoryBtn" code="ALL">전체 리스트</div>
			<div class="categoryBtn" code="DPL">전시</div>
			<div class="categoryBtn" code="MSC">뮤지컬</div>
			<div class="categoryBtn" code="CRT">콘서트</div>
			<div class="categoryBtn" code="CLS">클래식</div>
			<div class="categoryBtn" code="THT">연극</div> -->
		</div>
		<div id="areaCount" style="text-align: center; margin-bottom: 15px;">
			<c:out value="${productCountMessage}"></c:out>
		</div>
		<div id="areaProductList">
			<div class="areaProduct" id="productLeft"></div>
			<div class="areaProduct" id="productRight"></div>
		</div>
		<div id="areaBtnMore" style="text-align: center;">
			<spring:message code="btn.more"/>
		</div>
		<div id="areaBtnToTop" style="text-align: center;">
			^ TOP
		</div>
		
	</div>
	
	<script id="promotionTemplate" type="text/template">
		<div class="promotionItem" style="position: relative; display: inline;">
			<img src="{{path}}" width="600" height="200">
		</div>
	</script>
	
	<script id="categoryTemplate" type="text/template">
		<div class="categoryBtn" categoryId="{{categoryId}}" style="display: inline-block; margin-left: 20px; margin-right: 20px; font-weight: bold; cursor: pointer;">
			{{name}}
		</div>
	</script>
	
	<script id="productTemplate" type="text/template">
		<img src="{{path}}" height="350" width="280"><br>
		<b>{{name}}</b><br>
		{{place}}<br>
		{{description}}
	</script>
	
	<script id="label.product.count" type="text/message">
		<spring:message code="label.product.count"/>
	</script>
	
	<script type='text/javascript' src='js/handlebars-v4.1.0.js'></script>
	<script type="text/javascript" src="js/main.js"></script>
</body>
</html>