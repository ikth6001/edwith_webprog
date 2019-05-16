<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %> <!-- Templating 때문에 EL 표기법 사용 안 함 > 취소. EL을 사용 안하면 JSTL이 동작 안함;; -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>에러</title>
</head>
<body>
	아래 원인으로 인하여 에러가 발생 하였습니다.<br>
	<c:out value="${cause}"></c:out>
</body>
</html>