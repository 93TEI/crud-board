# 웹 프로젝트 - 게시판
    간단한 CRUD부터 무중단 배포까지 실제 서비스를 하고 있는 프로젝트로,
    기능을 점점 더 추가하여 최종적으로는 op.gg같은 같은 웹서비스를 목표로 하고있습니다.
      
# 프로젝트 진행

    21.07.14 웹프로젝트 시작
    
    
    21.08.31 AWS 서버 환경 구축 완료 - putty를 사용하여 EC2 서버 설정 완료
    21.09.01 AWS RDS 마리아DB 생성 완료
    21.09.03 EC2와 RDS 연동 완료, putty에서 ec2서버에 프로젝트 배포 시작하는데 오류남
    21.09.03 ~ 21.09.06 오류 고침.
    21.09.09 H2로 구동되던 DB를 RDS로 옮겼음
    21.09.09 RDS 연결 오류 잡는중
    
    21.09.23 s3 putty에 다운중
    21.09.29 NGINX 오류로 홈페이지 제대로 작동하지 않음 해결중
    21.09.30 NGINX 설정 - 서버 - location / 부분에 코드 추가 및 수정해주니 해결됨
    21.10.01 네이버 로그인 오류 : Callback URL 오류
    21.10.09 기능 추가가 안됨.
    21.10.12 복습 : RestfulAPI, MVC패턴
    21.10.13 복습 : 폼, JPA를 이용한 Dto
    21.10.14 복습 : DB (h2)
    21.10.16 복습 : 롬복, 리팩토링
    21.10.17 복습 : 프로젝트 복습 ( ~ PostsRepositoryTest)
    21.10.18 복습 : 프로젝트 복습 ( PostsRepositoryTest ~ 수정/조회test)
    21.10.20 복습 : 프로젝트 복습 ( JPA Auditing ~ 프로젝트 끝까지)
    21.10.20 기능 추가 오류 해결( RestTemplate )
    21.10.22 피파온라인 감독 정보 가져오기 + 감독 정보 단위테스트 성공 / 내장was 문제
    21.10.23 롤 api 가져올 준비로 Controller, Service, Cto, ApiController, 뷰 구현
    21.10.24 롤 유저 정보 저장 및 가져오기, 단위테스트 성공
    21.10.25 피파 유저 정보 DB 구현 후 프로젝트 분리
    21.11.04 글등록 버튼 무반응 오류 해결
