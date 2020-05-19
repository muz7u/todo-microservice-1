FROM openjdk:8
EXPOSE 2222
ADD target/todo.jar todo.jar
ENTRYPOINT ["sh", "-c", "java -jar /todo.jar"]