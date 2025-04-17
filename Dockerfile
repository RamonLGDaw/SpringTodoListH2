# Utiliza una imagen base de Maven con JDK 21
FROM maven:3.9.6-jdk-21

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia los archivos del proyecto al contenedor
COPY . /app

# Construye la aplicación usando Maven
RUN mvn clean install -DskipTests

# Define el comando para ejecutar la aplicación
CMD ["java", "-jar", "target/*.jar"]