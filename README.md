# movieApplication

# 앵커리어 과제

## 사용 기술 스택

### 프로젝트 구성
- MVVM 프레임워크
- Android Clean Architecture
- Multi-Module
### 의존성 주입
- Hilt
### 로컬 데이터베이스
- Room
### 네트워크
- Retrofit2
- Okhttp Interceptor
### 비동기 처리
- Kotlin Coroutines
- Kotlin Flow
### 이미지 리소스
- Glide
### 뷰 관련 라이브러리
- Material Components ( MDC )
- Android Navigation
- Paging3

## 프로젝트 설치 및 빌드 방법
> Android Studio 가 설치되어 있지 않다면 설치 부탁드립니다.
### 코드 확인 및 실행 시
1. 전송한 .zip 파일 압축 풀기
2. Android Studio 실행
3. Open 후 압축 풀기 된 폴더의 루트 위치 열기
4. Gradle Sync 후 Run 버튼 클릭 ( 에뮬레이터 혹은 실 기기 와 연결되어 있어야 함. )
### 코드 미확인 및 실행 시
1. 전송한 .zip 파일 압축 풀기
2. Android Studio 실행
3. Profile Or Debug 실행
4. 압축 풀기 된 폴더에서 빌드 완료된 Apk 클릭
5. 연결된 실 기기 혹은 에뮬레이터로 실행

## 프로젝트 사용법 및 기능
### 영화 검색 페이지
1. 텍스트 작성이 추가될 때마다 검색
2. 즐겨찾기 추가, 삭제 가능
3. 페이질 기능
### 디테일 페이지
1. 위에 있는 카드로 현재 선택된 영화 노출
2. 웹뷰로 현재 아이템에 대한 네이버 검색 결과 노출
3. 상단 앱 바에 영화 이름 노출
### 즐겨찾기 페이지
1. 현재 즐겨찾기에 추가되어 있는 영화들 노출
2. 현재 즐겨찾기에서 삭제 기능 추가.

## 완료되지 않은 이슈
1. TextWatcher 에서 빠르게 Text 를 변경될 때 `Paging Key Error` 가 나오는데, 그 `Paging Key Error` 에 대한 핸들링이 되어있지 않음. 
   -> 하나하나 천천히 페이징을 진행하게 되면 페이징이 정상적으로 변경된다.

