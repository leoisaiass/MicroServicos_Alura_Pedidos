# Usando a imagem base do OpenJDK 17 com Alpine Linux
FROM openjdk:17-alpine

# Criando um grupo e um usuário chamado 'spring' para evitar problemas de segurança
RUN addgroup -S spring && adduser -S spring -G spring

# Definindo o usuário que será utilizado para executar a aplicação
USER spring:spring

# Definindo um argumento que aponta para o arquivo .jar na pasta target
ARG JAR_FILE=target/*.jar

# Copiando o arquivo .jar para dentro do container e renomeando para app.jar
COPY ${JAR_FILE} app.jar

# Definindo o comando que será executado quando o container iniciar
ENTRYPOINT ["java","-jar","/app.jar"]