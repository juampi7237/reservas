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

1. Clonar el repositorio: https://github.com/juampi7237/reservas
   ```bash
   git clone git@github.com:juampi7237/reservas.git

### Configurar la base de datos:

Asegúrate de tener MySQL instalado y corriendo

Editar el archivo src/main/resources/application.properties con tus credenciales:

```code
spring.datasource.url=jdbc:mysql://localhost:3306/reservas?createDatabaseIfNotExist=true
spring.datasource.username=root    # Cambiar si es necesario
spring.datasource.password=toor    # Cambiar si es necesario
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true

server.servlet.context-path=/api/v1
```

Notas de configuración:

Si usas diferente puerto para MySQL: jdbc:mysql://localhost:<tu_puerto>/reservas...

Si quieres cambiar el puerto de la aplicación, añade: server.port=<puerto_deseado>

### Ejecución del proyecto
Ejecutar la clase principal ReservasApplication.java

El frontend se levantará en el puerto **8080** por defecto.

Puedes acceder a la aplicación en: http://localhost:8080/api/v1/users

### Endpoints principales
### Usuarios
- **GET** - Obtener todos los usuarios:
~~~
http://localhost:8080/api/v1/users
~~~ 
- **GET** - Obtener un usuarios por id:
~~~
http://localhost:8080/api/v1/users/{id}
~~~ 
- **POST** - Crear un usuario:
~~~
http://localhost:8080/api/v1/users
~~~ 
- **PUT** - Actualizar un usuario:
~~~
http://localhost:8080/api/v1/users/{id}
~~~ 
- **DELETE** - Eliminar un ususario:
~~~
http://localhost:8080/api/v1/users/{id}
~~~ 
- **GET** - Obtener un usuarios por email:
~~~
http://localhost:8080/api/v1/users/email/jp@example.com
~~~ 


### Espacios
- **GET** - Obtener todos los espacios:
~~~
http://localhost:8080/api/v1/spaces
~~~ 
- **GET** - Obtener un espacios por id:
~~~
http://localhost:8080/api/v1/spaces/{id}
~~~ 
- **POST** - Crear un espacios:
~~~
http://localhost:8080/api/v1/spaces
~~~ 
- **PUT** - Actualizar un espacios:
~~~
http://localhost:8080/api/v1/spaces/{id}
~~~ 
- **DELETE** - Eliminar un espacios:
~~~
 http://localhost:8080/api/v1/spaces/{id}
~~~ 

### Reservas
- **GET** - Obtener todas las Reservas:
~~~
http://localhost:8080/api/v1/bookings
~~~ 
- **GET** - Obtener reserva por id::
~~~
http://localhost:8080/api/v1/bookings/{id}
~~~ 
- **GET** - Obtener todas las Reservas por fecha:
~~~
http://localhost:8080/api/v1/bookings/date?date=2025-06-15
~~~ 

- **GET** - Obtener todas las Reservas por rango de fechas:
~~~
http://localhost:8080/api/v1/bookings/date-range?startDate=2025-06-13&endDate=2025-06-16
~~~ 

- **GET** - Obtener todas las Reservas por tipo de espacio:
~~~
http://localhost:8080/api/v1/bookings/type?spaceType=CANCHA
~~~ 
- **POST** - Crear una Reserva:
~~~
http://localhost:8080/api/v1/bookings
~~~ 
- **PUT** - Actualizar una Reserva:
~~~
http://localhost:8080/api/v1/bookings/{id}
~~~ 
- **DELETE** - Eliminar una Reserva:
~~~
 http://localhost:8080/api/v1/bookings/{id}
~~~ 

### Notificacions
- **GET** - Obtener todos las notificaciones:
~~~
http://localhost:8080/api/v1/notifications
~~~ 
