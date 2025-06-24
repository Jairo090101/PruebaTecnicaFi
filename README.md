# Proyecto API de Usuarios

Este es un proyecto backend desarrollado con Spring Boot que permite realizar operaciones CRUD sobre usuarios. La aplicación está conectada a una base de datos PostgreSQL y documentada con Swagger UI.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Maven
- Swagger (OpenAPI)
- Lombok

## Estructura del proyecto

- `controllers/` – Controladores REST
- `services/` – Lógica de negocio
- `repositories/` – Acceso a base de datos
- `entities/` – Entidades JPA
- `dtos/` – Data Transfer Objects
- `enums/` – Enumeraciones (como Rol)
- `mappers/` – Conversión entre entidades y DTOs (opcional)

##  Requisitos previos

- JDK 17
- Maven 3.8+
- PostgreSQL 12+
- (Opcional) Postman o Swagger UI para probar

## Crea una base de datos
CREATE DATABASE usuarios_db;

spring.datasource.url=jdbc:postgresql://localhost:5432/usuarios_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

