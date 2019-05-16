<H1>simpleReservation</H1>

백앤드, 스프링프레임워크 개발, 프론트앤드 개발 학습을 위해 간단히 만들어본 공연 예약 웹 어플리케이션입니다.  
<br/>
<br/>

**어플리케이션 기동 방법**

1. Repository를 체크아웃 받으면 simpleReservation이란 프로젝트가 있습니다. 이클립스 Maven 프로젝트이므로 이클립스에 import 해줍니다.
2. 어플리케이션은 H2 내장 Database를 사용합니다. 어플리케이션 기동시 기본 DDL 및 DML이 실행 됩니다.
    * 기본 사용자로 아이디 user01@naver.com, 암호 : user01 이 DML로 등록되어 있습니다.
    * 추가 사용자를 만들고 싶다면 /src/main/resources/sqls/reservation_dml.sql 파일에 reservation_user 테이블 DML 문을 추가 합니다.
3. 기동이 완료되면 http://localhost:8080 으로 접속합니다.

<br/>
<br/>

**어플리케이션 사용 방법**


1. 어플리케이션 기동 후, http://localhost:8080 으로 접속합니다. 접속하면, 아래와 같은 화면이 나타납니다.
    * 로그인 버튼을 누르면 로그인 페이지로 이동합니다
    * 각각의 카테고리 버튼을 누르면 카테고리에 맞는 공연 목록이 나타납니다.
