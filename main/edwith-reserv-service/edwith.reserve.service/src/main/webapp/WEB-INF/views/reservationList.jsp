<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>예약 목록</title>
    
    <style type="text/css">
        #container {
            height: 100%;
            width: 600px;
            margin-left: auto;
            margin-right: auto;
            
            border: solid 1px silver;
        }
        
        #details {
            width: 100%;
        }
        
        #activeLabel {
            color: white; 
            background-color: green; 
            text-align: center;
            display: table-cell;
            vertical-align: middle;
            
            height: 50px;
            width: 600px;
        }
        
        #cancelLabel {
            color: white; 
            background-color: silver; 
            text-align: center;
            display: table-cell;
            vertical-align: middle;
            
            height: 50px;
            width: 600px;
        }
        
        .contentsContainer {
        	width: 50%;
        	margin-left: auto;
        	margin-right: auto;
        	margin-bottom: 30px;
        }
        
        .inActive{
        	/* javascript에서 event 중 onmouseover, onmouseleave가 있음  */
        	cursor: pointer;
        }
        
        .btnCancel {
        	background-color: silver;
        	font-weight: bold;
        	color: white;
        	text-align: center;
        }
    </style>
</head>
<body>
    <div id="container">
        <div id="details">
            <div id="active">
                <div id="activeLabel"><h3> 예약확정(N개) </h3></div>
            </div>
            <div id="canceled">
                <div id="cancelLabel"><h3>예약취소(N개)</h3></div>
            </div>
        </div>
    </div>
    
    <script type="text/template" id="reservationTempalte">
        	<h3>{{productName}}</h3>
            <div><font color="gray">일정</font> {{openingHours}}</div>
            <div><font color="gray">내역</font> 내역이 없습니다.</div>
            <div><font color="gray">장소</font> {{place}}</div>
            <div>결제 예정 금액 <font color="red">{{price}}</font>원</div>
	</script>
    
    <script type='text/javascript' src='js/handlebars-v4.1.0.js'></script>
	<script type="text/javascript" src="js/reservationList.js"></script>
</body>
</html>