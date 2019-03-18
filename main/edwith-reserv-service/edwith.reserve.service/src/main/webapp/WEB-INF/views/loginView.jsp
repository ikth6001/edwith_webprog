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
			
			background-color: silver;
		}
		
		.loginFormArea {
			width: 300px;

			margin-bottom: 10px;
			margin-left: auto;
			margin-right: auto;
		}
		
		.inputForm {
			width: 290px;
			height: 30px;
		}
		
		.btnForm {
			width: 294px;
			height: 36px;
		}
		
	</style>
	
</head>
<body>
	<div id="container">
		<div style="text-align: center;">
			<H1>예약</H1>
		</div>
		<div class="loginFormArea">
			<input class="inputForm" id="txtId" type="text" name="id" placeholder="  예약자 이메일 입력">
		</div>
		<div class="loginFormArea">
			<input class="inputForm" id="txtPw" type="password" name="passwd" placeholder="  비밀번호">
		</div>
		<div id="areaMsg" style="text-align: center; margin-bottom: 10px;"></div>
		<div class="loginFormArea">
			<input class="btnForm" id="btnLogin" type="button" value="로그인">
		</div>
	</div>		
	
    <script type="text/javascript" src="js/loginView.js"></script>
</body>
</html>