<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        }
        
        #overview {
            text-align: center;
            padding-left: 0px;
            padding-right: 0px;
            width: 100%;
        }
        
        .inOverview {
            color: white;
            font-weight: bold;
            background-color: green;
            text-align: center;
            display: inline-block;
            width: 49%;
            
            margin-left: 0px;
            margin-right: 0px;
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
        }
        
        #cancelLabel {
            color: white; 
            background-color: silver; 
            text-align: center;
            display: table-cell;
            vertical-align: middle;
        }
    </style>
</head>
<body>
    <div id="container">
        <div id="overview">
            <div id="activeCnt" class="inOverview">
                <div>예약확정</div>
                <div>2</div>
            </div>
            <div id="cancelCnt" class="inOverview">
                <div>예약취소</div>
                <div>1</div>
            </div>
        </div>
        <div id="details">
            <div id="active">
                <div id="activeLabel"><h2>예약확정</h2></div>
                <div id="titleArea">
                    <h3>상품 명</h3>
                </div>
                <div id="contentsArea">
                    <div><font color="gray">일정</font> 2009.03.12</div>
                    <div><font color="gray">내역</font> 내역이 없습니다.</div>
                    <div><font color="gray">장소</font> 예술의 전당</div>
                    <div>결제 예정 금액 <font color="red">150000</font>원</div>
                </div>
            </div>
            <div id="canceled">
                <div id="cancelLabel"><h2>예약취소</h2></div>
                <div id="titleArea">
                    <h3>상품 명</h3>
                </div>
                <div id="contentsArea">
                    <div><font color="gray">일정</font> 2009.03.12</div>
                    <div><font color="gray">내역</font> 내역이 없습니다.</div>
                    <div><font color="gray">장소</font> 예술의 전당</div>
                    <div>결제 예정 금액 <font color="red">150000</font>원</div>
                </div>
            </div>
        </div>
    
    </div>

</body>
</html>