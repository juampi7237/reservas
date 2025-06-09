# Sistema de Reservas para Espacios Comunitarios

## Estructura del Proyecto

El proyecto está aplicando **arquitectura hexagonal** para realizar un
- **Backend**: API REST desarrollada con Spring Boot 


## 🚀 Backend (Spring Boot)

### Requisitos previos
- Java JDK 17+
- MySQL 8+
- Maven

### Configuración inicial

1. Clonar el repositorio: https://github.com/juampi7237/backend
   ```bash
   git clone git@github.com:juampi7237/backend.git

### Configurar la base de datos:

Asegúrate de tener MySQL instalado y corriendo

Editar el archivo src/main/resources/application.properties con tus credenciales:

```code
spring.datasource.url=jdbc:mysql://localhost:3306/clinica?createDatabaseIfNotExist=true
spring.datasource.username=root    # Cambiar si es necesario
spring.datasource.password=toor    # Cambiar si es necesario
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true

server.servlet.context-path=/api/v1
```

Notas de configuración:

Si usas diferente puerto para MySQL: jdbc:mysql://localhost:<tu_puerto>/clinica...

Si quieres cambiar el puerto de la aplicación, añade: server.port=<puerto_deseado>

### Ejecución del proyecto
Ejecutar la clase principal ClinicaApplication.java

El frontend se levantará en el puerto **8080** por defecto.

Puedes acceder a la aplicación en: http://localhost:8080/api/v1/services

### Endpoints principales
