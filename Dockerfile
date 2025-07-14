FROM eclipse-temurin:21-jdk

# Установим Maven вручную
RUN apt-get update && apt-get install -y maven

WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

CMD ["java", "-jar", "target/school-managment-system-0.0.1-SNAPSHOT.jar"]