# 1단계: 빌드용 단계
FROM gradle:8.5.0-jdk17-alpine AS build
WORKDIR /app

# Gradle 캐시를 활용하기 위해 의존성 관련 파일 먼저 복사
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
RUN gradle dependencies || true

# 나머지 소스 복사
COPY . .

# 프로젝트 빌드 (jar 생성)
RUN gradle build --no-daemon -x test

# 2단계: 실행용 단계 (최종 이미지)
FROM openjdk:17-jdk-alpine
WORKDIR /app

# 빌드된 jar 복사
COPY --from=build /app/build/libs/*.jar app.jar

# 포트 설정
EXPOSE 8080

# 실행
ENTRYPOINT ["java", "-jar", "app.jar"]