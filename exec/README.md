1. Gitlab 소스 클론 이후 빌드 및 배포할 수 있도록 정리한 문서  
   1) 사용한 JVM, 웹서버, WAS 제품 등의 종류와 설정 값, 버전(IDE버전 포함) 기재
   - 사용한 jvm : java 17
   - 웹서버 : vite
   - WAS 제품 : spring boot 내장 was
   - IDE 버전 : Intellij 2024.2.1, VSCode

   2) 빌드 시 사용되는 환경 변수 등의 내용 상세 기재  
   (링크 참조)
   - server 설정 : [build.gradle](https://lab.ssafy.com/s11-webmobile1-sub2/S11P12D201/-/blob/master/backend/build.gradle?ref_type=heads) 및 [backend 아래의 .gradle](https://lab.ssafy.com/s11-webmobile1-sub2/S11P12D201/-/blob/master/backend/?ref_type=heads)에 기재
   - front 설정 : [package.config](https://lab.ssafy.com/s11-webmobile1-sub2/S11P12D201/-/blob/master/frontend/package.json?ref_type=heads) 및 [package-lock.json](https://lab.ssafy.com/s11-webmobile1-sub2/S11P12D201/-/blob/master/frontend/package-lock.json?ref_type=heads)에 기재

   3) 배포 시 특이사항 기재  
   이미지 서버, 웹 서버, 스프링 백서버가 nginx 80포트를 중심으로 설정되어 있습니다.

   4) DB 접속 정보 등 프로젝트(ERD)에 활용되는 주요 계정 및 프로퍼티가 정의된 파일 목록  
    - MariaDB: stg-yswa-kr-practice-db-master.mariadb.database.azure.com:3306/S11P11D201?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8
        - user: S11P11D201@stg-yswa-kr-practice-db-master.mariadb.database.azure.com
        - password: enlwlrpgkwk  

    - MongoDB: S11P12D201:gnghldjqtdlgkwk@ssafy.ngivl.mongodb.net/S11P12D201?authSource=admin
        - user: S11P12D201
        - password: gnghldjqtdlgkwk
        
    - Redis: steach.ssafy.io:6379/0


2. 프로젝트에서 사용하는 외부 서비스 정보를 정리한 문서  
   : 소셜 인증, 포톤 클라우드, 코드 컴파일 등에 활용 된 ‘외부 서비스’가입 및 활용에 필요한 정보
   - openai API



3. DB 덤프 파일 최신본  
    - [dump1.zip](https://lab.ssafy.com/s11-webmobile1-sub2/S11P12D201/-/blob/master/exec/dump1.zip?ref_type=heads) : 테이블 별로 dml + ddl 압축 파일
    - [dump2.zip](https://lab.ssafy.com/s11-webmobile1-sub2/S11P12D201/-/blob/master/exec/Dump2.zip?ref_type=heads) : 스키마 전체 dml + ddl 압축 파일

4. 시연 시나리오  
   [시연시나리오](https://lab.ssafy.com/s11-webmobile1-sub2/S11P12D201/-/blob/master/exec/Scenarios.md?ref_type=heads) 파일에 따로 작성
