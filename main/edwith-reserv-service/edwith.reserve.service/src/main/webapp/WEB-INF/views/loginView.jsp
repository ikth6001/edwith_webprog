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
	</style>
	
</head>
<body>
	<div id="container">
		<input id="txtId" type="text" name="id" placeholder="아이디">
		<input id="txtPw" type="password" name="passwd" placeholder="비밀번호">
		<input id="btnLogin" type="submit" value="로그인"/>
		<div id="areaMsg"></div>
	</div>
	
    <script type="text/javascript" src="js/loginView.js"></script>
</body>
</html>