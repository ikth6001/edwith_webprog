<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
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