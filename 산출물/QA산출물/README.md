# sonarqube
> SonarQube는 소프트웨어 품질 관리 도구로, 코드의 품질을 지속적으로 검사하고 분석하는 데 사용됩니다. 이 도구는 코드의 잠재적인 버그, 코드 스멜(Code Smells), 보안 취약성, 그리고 테스트 커버리지 부족 등을 식별하여 개발자들에게 피드백을 제공합니다.

CI/CD 과정에 sonarqube를 통해서 항상 소프트웨어 코드의 품질을 관리합니다.
## sonarqube 결과
![전체테스트](/산출물/QA산출물/image/sonarqube/sonarqube.png)

# 테스트
더 자세한 결과 이미지들은 [/산출물/QA산출물/image/...](https://lab.ssafy.com/s11-webmobile1-sub2/S11P12D201/-/tree/master/%EC%82%B0%EC%B6%9C%EB%AC%BC/QA%EC%82%B0%EC%B6%9C%EB%AC%BC/image?ref_type=heads) 아래에 사진 첨부하였습니다.


## 전체 테스트 결과
아래 이미지를 클릭하시면, 전체 테스트 코드의 위치로 이동합니다.

[![전체테스트](/산출물/QA산출물/image/전체테스트.png)](https://lab.ssafy.com/s11-webmobile1-sub2/S11P12D201/-/tree/master/backend/src/test/java/com/twentyone/steachserver?ref_type=heads)

## 인수테스트 결과
아래 이미지를 클릭하시면, 관련 코드를 확인 할 수 있습니다.

[![인수테스트](/산출물/QA산출물/image/projectMainTest.png)]((https://lab.ssafy.com/s11-webmobile1-sub2/S11P12D201/-/blob/master/backend/src/test/java/com/twentyone/steachserver/acceptance/MainAcceptanceTest.java?ref_type=heads))

## 성능테스트 결과

### 메인 페이지의 인기 커리큘럼에 대해서 Redis와 MariaDB 사용에 따른 성능 테스트 결과
![성능테스트1](/산출물/QA산출물/image/jmeter/Popular_curriculum_get_responsetime_compare.png)

### 최신 페이지의 인기 커리큘럼에 대해서 Redis와 MariaDB 사용에 따른 성능 테스트 결과
![성능테스트2](/산출물/QA산출물/image/jmeter/Latest_curriculum_get_responsetime_compare.png)

아래 주소를 통해 레디스를 사용하는 코드를 볼 수 있습니다.   
[레디스를 통해서 조회하는 코드](https://lab.ssafy.com/s11-webmobile1-sub2/S11P12D201/-/blob/master/backend/src/main/java/com/twentyone/steachserver/domain/curriculum/service/redis/CurriculumRedisService.java?ref_type=heads)


# jacoco Test Report
![Jacoco Test Report](/산출물/QA산출물/image/jacoco/jacocoReport.png)

