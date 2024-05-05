# spring-data-mongodb

### _Document._
[MongoDB 공식문서](https://www.mongodb.com/docs/manual/introduction/)를 참고하여 [정리](https://leeseunghee00.notion.site/MongoDB-fef2662c55374393b0c69f6e6b2b7466?pvs=4)합니다.
<br />

### _Env._
- Java 17
- SpringBoot 3.2.5
- IntelliJ
- Docker MongoDB
<br />

### _Setting_
본 프로젝트는 Docker 로 진행되었습니다. 프로젝트를 진행할 경우, 아래 단계를 확인해주세요.

1. Docker 설치
    - 자세한 설치 방법은 [공식 문서](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-enterprise-with-docker/)에서 확인할 수 있습니다.
2. 프로젝트에서 `docker-compose.yml` 을 생성 후 아래 예시를 참고해 작성합니다.

```yaml
version: '3'
services:
  application:
    image: mongodb/mongodb-community-server   # 컨테이너명
    environment:
      - CONN_STR=mongodb://user:pass@mongodb  # 몽고DB 서버 연결을 위한 문자열
    command: '/bin/bash -c "sleep 5; mongosh $$CONN_STR --eval \"show dbs;\""'
    depends_on:
      - mongodb
      
  mongodb:
    image: mongodb/mongodb-community-server:6.0-ubi8
    environment:
      - MONGO_INITDB_ROOT_USERNAME=user       # 사용할 계정
      - MONGO_INITDB_ROOT_PASSWORD=pass       # 비밀번호
    volumes:
      - type: bind
        source: ./data
        target: /data/db
```