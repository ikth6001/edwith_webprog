<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!-- Templating 때문에 EL 표기법 사용 안 함 > 취소. EL을 사용 안하면 JSTL이 동작 안함;; -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
    pageContext.setAttribute("newline", "\n"); 
    pageContext.setAttribute("br", "<br>"); 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><spring:message code="title.site" /></title>

<style type="text/css">

	#container {
		width: 600px;
		height: 100%;
		
		margin-left: auto;
		margin-right: auto;
		
		padding-left: 0px;
		padding-right: 0px;
	}
	
	#areaGnb {
		background-color: #F1F6F2;
		font-weight: bold;
	}
	
	div {
	   margin-bottom: 10px;
	}
	
	.needBottomPadding {
	   padding-bottom: 20px;
	}
	
	.textContainer {
        margin-left: 20px;
	}
	
	#titleArea {
	   text-align: center;
	   font-weight: bold;
	   margin-bottom: 5px;
	}
	
	#imgArea {
	   height: 100%;
	   width: 100%;
	}
	
	#txtArea {
	   position: absolute;
	   top: 35%;
	   left: 50%;
	   transform: translate(-50%, -50%);
	   font-weight: bold;
	   color: white;
	}
	
	.priceBtn {
	   width: 38px;
	   height: 38px;
	   display: table-cell;
	   
	   padding-bottom: 0px;
	   
	   margin-bottom: 0px;
	   margin-left: 0px;
	   margin-right: 0px;
	   margin-top: 0px;
	   
	   border: solid 1px silver;
	   text-align: center;
	   vertical-align: middle;
	   font-size: 1.5em;
	   
	   border: solid 0.5px black;
	}
	
	.formLabel {
        width: 80px;
        font-weight: bold;
    }
    
    .formInput {
        width: 340px;
        height: 30px;
    }
	
	.form {
	   display: inline-block;
	}
	
	#reservationFinal {
	   width: 600px;
	
	   display: table-cell;
	   text-align: center;
	   vertical-align: middle;
	   font-weight: bold;
	   color: white;
	   background-color: silver;

	   height: 40px;
	   padding-bottom: 0px;
	   
	   cursor: pointer;
	}
	
</style>

</head>
<body>
	<div id="container" style="border: solid 1px green;">
		<div id="areaGnb">
			<div id="areaBtnToMain" style="display: inline-block;  cursor: pointer;">
				<img src="img/mainLog.png" align="middle" style="margin: 5px;"> 예약
			</div>
			<div id="areaBtnReservInfo" style="display: inline-block; float: right; margin: 5px;">
				<div style="display: inline-block;">
					<a href= "/edwith.reserve.service/reservationList"><c:out value="${userName}"/></a>
					<a href= "<c:out value="${loginReqUrl}"/>"><c:out value="${logInOut}"/></a> 
				</div>
			</div>
		</div>
	
		<div id="titleArea" class="needBottomPadding" style="text-align: center; font-weight: bold;"><c:out value="${mainTxt}"/></div>
		<div id="mainArea" class="needBottomPadding" style="width:100%; text-align: center;">
			<div id="imgArea"><img src="<c:out value="${mainImg}"/>" width="100%" height="400px"></div>
			<div id="txtArea"><c:out value="${mainTxt}"/></div>
		</div>
		<div id="descArea">
			<div id="productDesc" class="textContainer needBottomPadding">
                <b><c:out value="${mainTxt}"/></b><br>
                <c:out value="${place}"/><br>			
			</div>
			<div id="productTime" class="textContainer needBottomPadding">
                <b>관람시간</b><br>
                <c:set var="openingHours" value="${openingHours}"/>
                ${fn:replace(openingHours, newline, br)}
			</div>
			<div id="productPrice" class="textContainer needBottomPadding">
			</div>
		</div>
		<div id="ticketSelArea" class="needBottomPadding">
		</div>
		<div id="reserverInfo" class="needBottomPadding">
			<div class="textContainer"><b>예매자 정보(필수입력)</b></div>
			<div>
                <div class="form formLabel textContainer" id="lblName">예매자</div>
                <input class="form formInput" id="inputName" type="text" placeholder="  예매자 이름을 입력하세요">
                <div id="nameErrMsg" style="display: inline-block;"></div>
			</div>
			<div>
                <div class="form formLabel textContainer" id="lblPhone">연락처</div>
                <input class="form formInput" id="inputPhone" type="text" placeholder="  휴대폰 입력 시 예매내역 문자 발송">
                <div id="phoneErrMsg" style="display: inline-block;"></div>
			</div>
			<div>
                <div class="form formLabel textContainer" id="lblEmail">이메일</div>
                <input class="form formInput" id="inputEmail" type="text" value="<c:out value="${userEmail}"/>" placeholder="  예매자 이메일을 입력하세요">
                <div id="emailErrMsg" style="display: inline-block;"></div>
			</div>
			<div class="textContainer">
				<div style="display: inline-block;">총 </div>
				<div id="totalCount" style="display: inline-block;">0</div>
				<div style="display: inline-block;"> 매</div>
			</div>
		</div>
		
		<div id="reservationFinal">예약하기</div>
	</div>
	
	<script id="displayInfoId" type="text/hiddenInfo">
        <c:out value="${displayInfoId}"/>
    </script>
    
    <script id="priceTemplate" type="text/template">
		<div>
			<div id="priceLeft" class="textContainer" style="display:inline-block; width: 45%">
				<div>
					<b>{{priceTypeName}}<br>{{price}}</b>
				</div>
				<div>
				   <font color="silver">{{price}}({{discountRate}}% 할인)</font>
				</div>
			</div>
			<div id="priceRight" style="display:inline-block; width: 45%">
				<div id="{{productPriceId}}" style="vertical-align: middle;">
				   <div class="priceBtn" id="btnPriceMinus{{idx}}">-</div>
				   <div class="priceBtn" id="btnTicketCnt{{idx}}" >0</div>
				   <div class="priceBtn" id="btnPricePlus{{idx}}" >+</div>
				</div>
				<div>
					<div style="display:inline-block;"><font color="silver" id="totalPrice{{idx}}">0</font></div>
					<div style="display:inline-block;"><font color="silver">원</font></div>
				</div>
			</div>
		</div>
	</script>

	<script type='text/javascript' src='js/handlebars-v4.1.0.js'></script>
	<script type="text/javascript" src="js/reservationView.js"></script>
</body>
</html>