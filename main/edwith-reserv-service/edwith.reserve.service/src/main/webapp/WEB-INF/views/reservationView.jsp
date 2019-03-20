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
		
		padding-left: 0px;
		padding-right: 0px;
	}
	
	#titleArea {
	   text-align: center;
	   font-weight: bold;
	   margin-bottom: 5px;
	}
	
	#mainArea {
	   width: 100%;
	   height: 300px;
	}
	
	#imgArea {
	
	}
	
	#txtArea {
	   text-align: center;
	}
	
	.priceBtn {
	   width: 40px;
	   height: 40px;
	}
	
	.formLabel {
        width: 80px;
    }
    
    .formInput {
        width: 340px;
    }
	
	.form {
	   display: inline-block;
	}
	
</style>

</head>
<body>
	<div id="container" style="border: solid 1px green;">
        <div style=""></div>
		<div id="titleArea">title</div>
		<div id="mainArea">
			<div id="imgArea">img</div>
			<div id="txtArea">txt</div>
		</div>
		<div id="descArea">
			<div id="productDesc">
                <b>타이틀</b>
			</div>
			<div id="productTime">
                <b>관람시간</b>
			</div>
			<div id="productPrice">
                <b>요금</b>
			</div>
		</div>
		<div id="ticketSelArea">
			<!-- 성인, 유아 등등이 동적인지는 API 명세 확인 필요 > 동적임. -->
			<div id="ticketAdult">
				<div id="tAdultLeft" style="display:inline-block; width: 45%">
					<div>
						<b>성인<br>10200원</b>
					</div>
					<div><font color="silver">10200원(할인15%)</font></div>
				</div>
				<div id="tAdultRight" style="display:inline-block; width: 45%">
					<div>
					   <img src="img/price_minus.png" class="priceBtn"/>
                       <img src="img/price_empty.png" class="priceBtn"/>
                       <img src="img/price_plus.png" class="priceBtn"/>
					</div>
					<div><font color="silver">10200 * n원</font></div>
				</div>
			</div>
		</div>
		<div id="reserverInfo">
			<div><b>예매자 정보(필수입력)</b></div>
			<div>
                <div class="form formLabel">예매자</div>
                <input class="form formInput" type="text" placeholder="예매자 이름을 입력하세요">
			</div>
			<div>
                <div class="form formLabel">연락처</div>
                <input class="form formInput" type="text" placeholder="휴대폰 입력 시 예매내역 문자 발송">
			</div>
			<div>
                <div class="form formLabel">이메일</div>
                <input class="form formInput" type="text" placeholder="자동 입력 되야 함.">
			</div>
			<div>예매내용 2017.2.17. 총 10매</div>
		</div>
		<div id="reservationRule">
			<div>개인정보 수집 동의</div>
			<div>개인정보 제 3자 제공 동의</div>
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