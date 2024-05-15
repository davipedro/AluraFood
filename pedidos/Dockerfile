FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
# cria usuário spring
USER spring:spring
# variável para o jar
ARG JAR_FILE=target/*.jar
# copia o jar para o container
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]