# ForoHub

![Static Badge](https://img.shields.io/badge/java-orange?style=for-the-badge) 
![Static Badge](https://img.shields.io/badge/base--de--datos-blue?style=for-the-badge)
![Static Badge](https://img.shields.io/badge/'en%20desarrollo'-yellow?style=social)

## Índice

- [Descripción del proyecto](#descripción-del-proyecto)
- [Características de la aplicación y demostración](#características-de-la-aplicación-y-demostración)
- [Acceso al proyecto](#acceso-al-proyecto)
- [Tecnologías utilizadas](#tecnologías-utilizadas)
- [Conclusión](#conclusión)

# Descripción del proyecto

**Foro** es una aplicación de gestión de foros basada en **Java** y **Spring Boot** que permite crear, actualizar y eliminar tópicos y respuestas. La aplicación utiliza JPA para la persistencia de datos y se conecta a una base de datos MySQL. Este proyecto es parte de la formación de Java y Spring Framework.

# Características de la aplicación y demostración

**Foro** permite realizar las siguientes acciones:

- **Crear usuario**: Permite registrar un nuevo usuario en el sistema.
- **Actualizar usuario**: Permite actualizar la información de un usuario existente.
- **Eliminar usuario**: Permite deshabilitar un usuario.
- **Crear tópico**: Permite crear un nuevo tópico en el foro.
- **Actualizar tópico**: Permite actualizar la información de un tópico existente.
- **Eliminar tópico**: Permite eliminar un tópico.
- **Crear respuesta**: Permite crear una nueva respuesta en un tópico.
- **Actualizar respuesta**: Permite actualizar la información de una respuesta existente.
- **Eliminar respuesta**: Permite eliminar una respuesta.

A continuación se da un pequeño recorrido a la estructura del proyecto:

- **src/main/java/com/maru/foro**:
  - **controller**: Contiene los controladores REST (`UsuarioController`, `TopicoController`, `RespuestaController`).
  - **domain**: Contiene las entidades JPA (`Usuario`, `Topico`, `Respuesta`) y sus respectivos DTOs y validaciones.
  - **repository**: Contiene los repositorios JPA (`UsuarioRepository`, `TopicoRepository`, `RespuestaRepository`).

# Acceso al proyecto

1. Clona el repositorio:

    ```bash
    git clone https://github.com/tu-usuario/foro.git
    cd foro
    ```

2. Configura la base de datos en el archivo [application.properties](http://_vscodecontentref_/0):

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/foro
    spring.datasource.username=tu-usuario
    spring.datasource.password=tu-contraseña
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. Compila y ejecuta la aplicación:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

# Tecnologías utilizadas

1. Lenguaje [Java (Versión 17)](https://docs.oracle.com/en/java/javase/17/docs/api/index.html)
2. Framework [Spring Boot](https://spring.io/projects/spring-boot)
3. Base de datos [MySQL](https://www.mysql.com/)
4. Librerías utilizadas:
   - [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
   - [Hibernate](https://hibernate.org/)
   - [Spring Web](https://spring.io/guides/gs/rest-service/)
   - [Spring Security](https://spring.io/projects/spring-security)
   - [Flyway](https://flywaydb.org/)

# Conclusión

El proyecto Foro representa un esfuerzo significativo en la implementación y aplicación de conocimientos adquiridos en Java y Spring Boot. A través de su desarrollo, se demostró la capacidad de integrar múltiples tecnologías para crear una aplicación funcional y útil que facilita la gestión de tópicos y respuestas en un foro.

Foro no solo cumple con los objetivos académicos de la formación de Java y Spring Framework, sino que también ofrece una herramienta práctica para el usuario final. La colaboración en el grupo y la implementación de buenas prácticas de programación aseguran que el proyecto sea robusto y escalable.
