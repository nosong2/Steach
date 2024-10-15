# 웹/모바일(웹 기술) 스켈레톤 프로젝트

## 카테고리

| Application | Domain | Language | Framework |
| --- | --- | --- | --- |
| ✅ Desktop Web | ✅ AI | ✅ JavaScript | 🔲 Vue.js |
| 🔲 Mobile Web | 🔲 Big Data | ✅ TypeScript | ✅ React |
| ✅ Responsive Web | 🔲 Blockchain | 🔲 C/C++ | 🔲 Angular |
| 🔲 Android App | 🔲 IoT | 🔲 C# | ✅ Node.js |
| 🔲 iOS App | 🔲 AR/VR/Metaverse | ✅ Python | ✅ Flask/Django |
| 🔲 Desktop App | 🔲 Game | ✅ Java | ✅ Spring/Springboot |
|  |  | 🔲 Kotlin |✅ Tailwind.CSS |
|  |  | ✅ SQL |✅ Redux / Redux tool kit  |

## 프로젝트 소개
아래 간단한 소개와 산출물 폴더 하위 폴더의 READ.md 파일에서 자세히 보실 수 있습니다.

- 프로젝트명: STEACH (*Study & Teach*)
- 서비스 특징: 교육기회가 부족한 분들에게 기회를 제공하여 교육격차 해소를 목표로 하는 무료 온라인 교육 서비스
- 주요 기능
    - 화상 강의실
    - 생성형 AI 기반 진로 추천
    - AI 기반 졸음감지 및 경고
- 주요 기술
    - WebRTC
    - WebSocket
    - JWT Authentication
    - REST API
    - AI
- 배포 환경
    - URL: steach.ssafy.io
    - 테스트 계정:
      - 학생: 
        - ID: student
        - PASSWORD: student
      - 강사: 
        - ID: teacher
        - PASSWORD: teacher
      - ADMIN:
        - ID: admin
        - PASSWORD: admin


## 기획 배경 및 목적
### *배경
1. 코로나 팬데믹 이후 청소년의 교육 격차가 매우 심각한 상황입니다. 교육부의 교육 복지는 학교내 지원 사업이 대부분이므로 방과 후 교육은 사각지대에 위치하고 있습니다.
    - 나원희. (2024). 한국의 교육복지 사업 현황과 과제. 보건복지 Issue & Focus , 443, 1–10. https://doi.org/10.23064/2024.01.443

2. 만 8~23세 청소년의 16%가 한부모 및 조손 가정이고, 거주지가 반지하 혹은 옥탑 등에 해당하는 가구가 18.2%에 해당합니다. 일반 청소년에 비해 취약 계층의 청소년은 방과 후 사교육 경험 비율은 43%에 불과합니다.
    - 홍성효, & 장수명. (2022). 통계자료를 활용한 취약계층 청소년의 취약성 진단과 지원정책 평가. 한국청소년정책연구원. 경제-인문사회연구회 협동연구총서 22-81-02. https://www.nypi.re.kr/brdrr/boardrrView.do?brd_id=BDIDX_PJk7xvf7L096m1g7Phd3YC&menu_nix=4o9771b7&cont_idx=804&edomweivgp=R

### *목적
1. 취약 계층 학생들에게 '공정'한 교육 기회를 부여하여, 교육 불균형을 해소하고 진로를 위한 디딤돌을 제공합니다.

2. 소규모 그룹 강의를 제공하여 학생들이 집중적인 교육을 받을 수 있게 하고, 다양한 분야의 교육을 제공하여 학생들이 원하는 진로에 대해 학습할 수 있는 기회를 제공합니다.


## 팀 소개

- 조시현: 팀장, PM, QA, 백엔드, 인프라
- 이진송: 프론트엔드 테크리더
- 이상철: 백엔드 테크리더, 서버보안관리
- 김호경: 데이터 테크리더, 백엔드
- 주효림: 백엔드, 백엔드 테스트리더
- 감헌규: 프론트엔드, 프론트 테스트리더


## 프로젝트 상세 설명

### 제품 비전 선언문

> 스티치는 교육과 상담의 기회가 부족한 취약계층이 원하는 교육, 상담을 받을 수 없는 문제를 해결 할 수 있도록 소규모 무료 과외, 다양한 교육, 상담을 제공하여 교육의 평등 를 실현하는 데스크톱과 테블릿을 바탕으로 제공하는 실시간 온라인 강의 웹사이트입니다.
> 

### 개발 환경 & 기술 스택

Frontend
- React
- javaScript
- Typescript
- Redux + Redux toolkit
- Tailwind.css

Backend
- java17
- Springboot 3.2.7 (gradle8.8)
- JPA
- MariaDB(provided)
- WebRTC

Environment
- AWS

Collaboration 
- notion
- figma
- jira
- git

# 시스템 구성도

[시스템 구성도](https://lab.ssafy.com/s11-webmobile1-sub2/S11P12D201/-/blob/master/%EC%82%B0%EC%B6%9C%EB%AC%BC/sub2/%EC%84%A4%EA%B3%84/%EC%8B%9C%EC%8A%A4%ED%85%9C%EA%B5%AC%EC%84%B1%EB%8F%84.md?ref_type=heads)

# ERD

[ERD](https://lab.ssafy.com/s11-webmobile1-sub2/S11P12D201/-/blob/master/%EC%82%B0%EC%B6%9C%EB%AC%BC/sub2/%EC%84%A4%EA%B3%84/ERD.md?ref_type=heads)


# MockUp

[Figma URL](https://www.figma.com/design/Ty9shKBP9wq01ayhCGvFd6/%EC%8A%A4%ED%8B%B0%EC%B9%98_%EC%9E%91%EC%84%B1%EC%A4%91?node-id=0-1&t=LIbx5xSG07wwQM8P-0)


# 기능 명세서
[기능 명세서](https://lab.ssafy.com/s11-webmobile1-sub2/S11P12D201/-/blob/master/%EC%82%B0%EC%B6%9C%EB%AC%BC/sub2/%EC%84%A4%EA%B3%84/%EA%B8%B0%EB%8A%A5%EB%AA%85%EC%84%B8%EC%84%9C.md?ref_type=heads)
