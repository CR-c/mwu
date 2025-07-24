# 多阶段构建
FROM maven:3.8.6-openjdk-8-slim AS builder
WORKDIR /app
COPY pom.xml .
# 先下载依赖（利用Docker缓存层）
RUN mvn dependency:go-offline
COPY src ./src
# 构建应用
RUN mvn package -DskipTests

# 生产镜像
FROM eclipse-temurin:8-jre-alpine
# 设置时区
RUN apk add --no-cache tzdata
ENV TZ=Asia/Shanghai
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

WORKDIR /app
# 从构建阶段复制jar包
COPY --from=builder /app/target/MWU-0.0.1-SNAPSHOT.jar ./app.jar
# 暴露端口
EXPOSE 8090
# 启动命令
ENTRYPOINT ["java","-jar","app.jar"]
