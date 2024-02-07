# 실용주의 프로그래머 - 프로젝트 자동화

## 환경
### build tool: ant
### Oracle Linux

## 오류 기록
### 'includeantruntime' waring
* ANT 빌드 수행 시 오류는 아니지만 'includeantruntime' warning이 남는 경우 아래와 같이 수정
* 현상
```
compile:
    [javac] /home/opc/study/automation/chap02/dms/build.xml:29: warning: 'includeantruntime' was not set, defaulting to build.sysclasspath=last; set to false for repeatable builds
    [javac] Compiling 2 source files to /home/opc/study/automation/chap02/dms/build/prod
```
* 수정
  * 대상 파일 - build.xml
  * javac 요소의 includeantruntime 속성 값을 false 로 변경
  * includeantruntime="false"








EOF

