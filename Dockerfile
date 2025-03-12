# Используем Maven-образ для сборки
FROM maven:3.9.9-eclipse-temurin-17 AS build

# Указываем рабочую директорию
WORKDIR /app

# Копируем файлы проекта (всё, кроме target/)
COPY . .

# Собираем JAR-файл
RUN mvn clean package -DskipTests

# Используем более легковесный образ с JDK для запуска
FROM openjdk:17-jdk-slim

WORKDIR /app

# Копируем собранный JAR из предыдущего этапа
COPY --from=build /app/target/*.jar app.jar

# Открываем порт
EXPOSE 8080

# Запускаем приложение
CMD ["java", "-jar", "app.jar"]