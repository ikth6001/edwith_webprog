<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!-- Templating 때문에 EL 표기법 사용 안 함 > 취소. EL을 사용 안하면 JSTL이 동작 안함;; -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
	}
	
	#btnPriceMinus {
	   cursor: pointer;
	}
	
	#btnPricePlus {
	   cursor: pointer;
	   background-color: green;
	}
	
	.formLabel {
        width: 80px;
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
                <c:out value="${openingHours}"/>
			</div>
			<div id="productPrice" class="textContainer needBottomPadding">
                <b>요금</b><br>
                <c:out value="${price}"/>
			</div>
		</div>
		<div id="ticketSelArea" class="needBottomPadding">
			<!-- 성인, 유아 등등이 동적인지는 API 명세 확인 필요 > 동적임. -->
			<div id="ticketAdult">
				<div id="tAdultLeft" class="textContainer" style="display:inline-block; width: 45%">
					<div>
						<b>성인<br>10200원</b>
					</div>
					<div>
					   <font color="silver">10200원(할인15%)</font>
					</div>
				</div>
				<div id="tAdultRight" style="display:inline-block; width: 45%">
					<div style="vertical-align: middle;">
					   <div class="priceBtn" id="btnPriceMinus">-</div>
					   <div class="priceBtn" id="btnTicketCnt">0</div>
					   <div class="priceBtn" id="btnPricePlus">+</div>
					</div>
					<div><font color="silver">10200 * n원</font></div>
				</div>
			</div>
		</div>
		<div id="reserverInfo" class="needBottomPadding">
			<div class="textContainer"><b>예매자 정보(필수입력)</b></div>
			<div>
                <div class="form formLabel textContainer">예매자</div>
                <input class="form formInput" type="text" placeholder="  예매자 이름을 입력하세요">
			</div>
			<div>
                <div class="form formLabel textContainer">연락처</div>
                <input class="form formInput" type="text" placeholder="  휴대폰 입력 시 예매내역 문자 발송">
			</div>
			<div>
                <div class="form formLabel textContainer">이메일</div>
                <input class="form formInput" type="text" placeholder="  자동 입력 되야 함.">
			</div>
			<div class="textContainer">총 10매</div>
		</div>
		
		<div id="reservationFinal">예약하기</div>
	</div>
	
	<script id="displayInfoId" type="text/hiddenInfo">
        <c:out value="${displayInfoId}"/>
    </script>

	<script type='text/javascript' src='js/handlebars-v4.1.0.js'></script>
	<script type="text/javascript" src="js/reservationView.js"></script>
</body>
</html>