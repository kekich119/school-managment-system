# Используем JDK 21
FROM eclipse-temurin:21-jdk

# Создаём рабочую директорию внутри контейнера
WORKDIR /app

# Копируем всё содержимое проекта внутрь контейнера
COPY . .

# Собираем приложение с помощью Maven, без тестов
RUN ./mvnw clean package -DskipTests

# Запускаем приложениеmvn clean package
CMD ["java", "-jar", "target/school-0.0.1-SNAPSHOT.jar"]