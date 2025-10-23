# ---------- 1단계: 빌드 ----------
FROM gradle:8.10.2-jdk17-alpine AS build
WORKDIR /app

# 프로젝트 고정 파일들만 먼저 복사해서 의존성 캐시 극대화
COPY gradlew ./
COPY gradle ./gradle
# Gradle Kotlin DSL / Groovy DSL 둘 다 대응
COPY settings.gradle.kts settings.gradle.kts
COPY build.gradle.kts    build.gradle.kts

# 권한 부여 (일부 환경에서 필요)
RUN chmod +x gradlew

# 의존성만 미리 받기 (소스 없이) -> 캐시층 형성
RUN ./gradlew --no-daemon dependencies || true

# 나머지 소스 복사
COPY . .

# Spring Boot 실행 JAR 생성 (test 스킵 권장)
RUN ./gradlew clean bootJar -x test

# ---------- 2단계: 실행 ----------
FROM openjdk:17-jdk-alpine
WORKDIR /app

# 타임존/로캘(선택)
ENV TZ=Asia/Seoul

# 빌드 산출물 복사 (bootJar 산출물 1개 가정)
# build/libs 안의 *-SNAPSHOT.jar 또는 버전 jar를 app.jar로 통일
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

# 실행
ENTRYPOINT ["java", "-jar", "app.jar"]