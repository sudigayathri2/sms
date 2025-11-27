# =============================================
# 1️⃣ Use an official JDK image to run the app
# =============================================
FROM openjdk:17-jdk-slim

# =============================================
# 2️⃣ Set working directory inside container
# =============================================
WORKDIR /app

# =============================================
# 3️⃣ Copy the JAR file built by Maven (CircleCI)
# =============================================
COPY target/*.jar app.jar

# =============================================
# 4️⃣ Expose application port (match your app)
# =============================================
EXPOSE 8100

# =============================================
# 5️⃣ Run the Spring Boot application
# =============================================
ENTRYPOINT ["java", "-jar", "app.jar"]
