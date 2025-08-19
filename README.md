# ForoHub API

## 📝 Descripción del Proyecto

ForoHub es una **API RESTful** desarrollada como parte del **Challenge Backend de Alura Latam**.

La API se ha construido siguiendo las **mejores prácticas** de la industria, incluyendo una arquitectura en capas, seguridad robusta y una documentación clara con **Swagger UI**.

## 🚀 Funcionalidades Principales

* **Autenticación y Autorización**:
    * **Login**: La API cuenta con un `endpoint` de autenticación que permite a los usuarios iniciar sesión con sus credenciales y obtener un **token JWT**.
    * **Acceso con token**: Una vez obtenido el token, el usuario puede acceder a los `endpoints` protegidos para gestionar los tópicos.
    * **Usuario de prueba**: Por ahora, la funcionalidad de login se prueba con un usuario preexistente en la base de datos.
* **Gestión de Tópicos (CRUD)**:
    * **Crear**: Un usuario autenticado puede crear un nuevo tópico.
    * **Listar**: Se pueden listar todos los tópicos con paginación, ordenamiento y filtros.
    * **Actualizar**: Un usuario puede actualizar cualquier tópico existente.
    * **Eliminar**: Un usuario puede eliminar cualquier tópico existente.
* **Manejo de Excepciones**:
    * La API cuenta con un gestor de errores global que maneja de manera centralizada las excepciones de validación (`400 Bad Request`) y las de recursos no encontrados (`404 Not Found`).

---

## 🛠️ Tecnologías Utilizadas

* **Java 21**: Lenguaje de programación.
* **Spring Boot 3**: Framework para el desarrollo de la API.
* **Spring Security**: Para la autenticación y autorización con tokens JWT.
* **Spring Data JPA**: Para la persistencia de datos y la interacción con la base de datos.
* **Flyway**: Herramienta de migración de base de datos para mantener el esquema versionado.
* **PostgreSQL**: Base de datos relacional.
* **Lombok**: Para reducir el código `boilerplate`.
* **Auth0 JWT**: Biblioteca para la generación y validación de tokens JWT.
* **SpringDoc OpenAPI**: Para la documentación de la API con Swagger UI.

---

## ⚙️ Configuración y Uso

### Variables de Entorno

Para ejecutar la aplicación, es necesario configurar las siguientes variables de entorno:

| Variable | Descripción | Ejemplo |
| :--- | :--- | :--- |
| `DB_URL` | URL de conexión a la base de datos. | `jdbc:postgresql://localhost:5432/forohub` |
| `DB_USERNAME` | Nombre de usuario de la base de datos. | `postgres` |
| `DB_PASSWORD` | Contraseña del usuario de la base de datos. | `123456` |
| `JWT_SECRET` | Clave secreta para la firma del token JWT. | `miclavesecretaparaeljwt` |
| `JWT_EXPIRATION_HOURS` | Tiempo de expiración del token en horas. | `24` |

### Inicio de la Aplicación

1.  Clona el repositorio.
2.  Configura las variables de entorno o el archivo `application.properties`.
3.  Ejecuta la clase `ForohubApplication`.

La aplicación se iniciará en `http://localhost:8080`.

---

## 📚 Documentación de la API

La API está documentada con **Swagger UI**. Puedes acceder a la documentación en la siguiente URL:

`http://localhost:8080/swagger-ui.html`

**Usuario de testeo:**
* **Login**: `user@example.com`
* **Contraseña**: `123456`

---

## 💻 Autor

**Damian Villalba** - Desarrollado para el challenge ForoHub de Alura + ONE.

