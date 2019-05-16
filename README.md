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
![reservationMain](images/simpleReservation_main.png?raw=true "reservationMain")
2. 우측 상단의 로그인 버튼을 누르면 간단한 로그인 페이지가 나타납니다. 로그인을 하면 우측 main 페이지로 redirect 됩니다.
      * 로그인 아이디 : user01@naver.com
      * 로그인 암호 : user01
      * 로그인 후 main 페이지를 보면 로그인 버튼 대신, 로그인 아이디 버튼이 생깁니다.
      * 로그인 아이디 버튼을 누르면 예약 목록을 확인할 수 있습니다.
![reservationLogin](images/simpleReservation_login.png?raw=true "reservationLogin")
3. 원하는 공연을 선택하면 공연 상세 정보를 볼 수 있습니다.
      * 예매하기 버튼을 누르면 예매를 할 수 있습니다.
      * 예매자 한줄평 더보기 버튼을 누르면 한줄평을 볼 수 있습니다. 예매 평 남기기 기능은 미구현 상태입니다.
![reservationDetail](images/simpleReservation_detail.png?raw=true "reservationDetail")
4. 예매하기를 눌러 예매 페이지로 이동합니다.
      * 로그인을 안했거나, 로그인 시간이 만료되면 로그인 페이지로 이동됩니다.
      * 예매할 티켓을 플러스(+), 마이너스(-) 버튼을 눌러 설정합니다.
      * 예매자 정보를 입력합니다.
      * 정보를 전부 입력하면 예약하기 버튼이 활성화 됩니다.
![reservationReserve](images/simpleReservation_reserve.png?raw=true "reservationReserve")
5. 최종적으로 예약하기 버튼을 누르면 예약이 완료되고, 예약 목록 확인 페이지로 이동합니다.
      * 예약된 항목을 클릭하면 예약을 취소할 수 있습니다.
![reservationList](images/simpleReservation_list.png?raw=true "reservationList")

<br/>
<br/>




