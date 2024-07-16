# Challenge "Foro Hub"

Este proyecto es una aplicación desarrollada con Spring Boot que proporciona servicios relacionados con un foro. Utiliza autenticación basada en tokens JWT para asegurar los endpoints y gestiona operaciones CRUD básicas para los temas de discusión.

## Requerimientos

- **Java JDK 17:** 
- **Maven:** 
- **Spring Boot:** 
- **MySQL:** 
- **IDE:** IntelliJ IDEA (opcional)
- **INSOMNIA:**

## Configuración Inicial del Proyecto

### Creación del Proyecto con Spring Initializr

- Java (versión 17)
- Maven 
- Spring Boot 3.3.1
- Proyecto en formato JAR

### Dependencias Agregadas

- Lombok
- Spring Web
- Spring Boot DevTools
- Spring Data JPA
- Flyway Migration
- MySQL Driver
- Validation
- Spring Security
- Auth0

### Configuracion de `application.properties`

- spring.datasource.url=jdbc:mysql://localhost:3306/foro_db
- spring.datasource.username=root
- spring.datasource.password=(personal)
- spring.jpa.show-sql=true
- spring.jpa.properties.hibernate.format_sql=true
- api.security.secret=${JWT_SECRET:123456}
- spring.flyway.enabled=true
- spring.flyway.locations=classpath:db/migration
- spring.flyway.baseline-on-migrate=true
- spring.flyway.ignore-future-migrations=true

## Instalación y Configuración

1. **Java JDK:** Instalar Java JDK versión 17.
   
2. **Maven:** Instalar Maven.
   
3. **Spring Boot:** Utilizar [Spring Initializr](https://start.spring.io/) para crear un nuevo proyecto Spring Boot con las dependencias mencionadas.

4. **MySQL:** Instalar MySQL versión 8. Configurar y crear una base de datos según sea necesario.

5. **IDE (IntelliJ IDEA):** Opcional. Descargar [IntelliJ IDEA](enlace) y configurarlo para el desarrollo del proyecto.

## Uso

### Ejecución del Proyecto

1. Clonar el repositorio o descargar el código fuente.

2. Importar el proyecto en tu IDE preferido.

3. Configurar las propiedades de conexión a la base de datos MySQL en `application.properties`.

4. Compilar y ejecutar el proyecto.

## Uso de Insomnia para Probar los Endpoints

### Configuración inicial

1. **Abrir Insomnia:**
   - Descarga e instala Insomnia desde [Insomnia](https://insomnia.rest/download).

2. **Importar la Colección de Endpoints:**
   - Importa la colección de endpoints proporcionada (`insomnia_collection.json`).

### Obtener un Token JWT

- **POST `/login`**
  - Cuerpo de la solicitud:
    ```json
    {
      "username": "usuario",
      "password": "contraseña"
    }
    ```
  - Respuesta exitosa: Devuelve un token JWT válido.

### Incluir el Token en las Solicitudes Protegidas

- Para los endpoints protegidos, incluye el token en el encabezado `Authorization` de tipo Bearer.

### Ejemplos de Endpoints

#### Autenticación

- **POST `/login`**
  - Cuerpo de la solicitud:
    ```json
    {
      "username": "usuario",
      "password": "contraseña"
    }
    ```
  - Respuesta exitosa: Devuelve un token JWT válido.

#### Gestión de Temas

- **GET `/topicos`**
  - Devuelve todos los temas de discusión disponibles.

- **POST `/topicos`**
  - Cuerpo de la solicitud:
    ```json
    ```
  - Crea un nuevo tema de discusión.

- **GET `/topicos/{id}`**
  - Devuelve el tema de discusión con el ID especificado.

- **PUT `/topicos/{id}`**
  - Cuerpo de la solicitud:
    ```json
    ```
  - Actualiza el tema de discusión con el ID especificado.

- **DELETE `/topicos/{id}`**
  - Elimina el tema de discusión con el ID especificado.



## Licencia

Este proyecto está licenciado por Eduardo Aguirre Alumno de ALURA LATAM.
