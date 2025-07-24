# 多阶段构建
FROM maven:3.8.6-openjdk-8-slim AS builder
WORKDIR /app
COPY pom.xml .
# 先下载依赖（利用Docker缓存层）
RUN mvn dependency:go-offline
COPY src ./src
# 构建应用，添加clean确保清理旧构建文件
RUN mvn clean package -DskipTests

# 生产镜像
FROM eclipse-temurin:8-jre-alpine
# 设置时区
RUN apk add --no-cache tzdata
ENV TZ=Asia/Shanghai
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

WORKDIR /app
# 使用通配符复制JAR文件，避免文件名版本号问题
COPY --from=builder /app/target/*.jar ./app.jar
# 暴露端口
EXPOSE 8090
# 添加启动参数，显式指定Spring Boot主类路径
ENTRYPOINT ["java","-jar","app.jar"]
