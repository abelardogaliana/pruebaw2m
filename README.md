# pruebaw2m

Anotaciones sobre la prueba:

- La aplicación se ejecuta sobre el puerto 8081

- Se han creado dos usuarios: "user" y "admin" con la contraseña "1234". El usuario admin tiene acceso a todo los recursos y el usuario user solo a los GET

- La anotación personalizada, el cacheo de peticiones y la documentación de la API manual está implementado únicamente sobre el recurso /heroes/all

- El test de integración requiere que la aplicación esté corriendo ya que hace llamadas directamente sobre la URL.

Anotaciones sobre los Puntos opcionales de mejora:

- Librería scripts DDL: en el application.properties he añadido unas propiedades para que se genere en la raíz del proyecto un archivo "create.sql" No tengo claro si esto es a lo que se refiere esta opción.
- Presentar la aplicación dockerizada: He añadido un dockerfile básico. Entiendo que si este microservicio se debe añadir a otros microservicios o se necesitan herramientas extra, lo interesante sería crear una orquestación de microservicios. docker-compose , Kubernetes. Tengo nociones básicas sobre contenedores pero no lo he aplicado a un ámbito profesional aún.
- Seguridad del API: Añadida una configuración de autenticación básica. Para una comunicación externa con otros microservicios utilizariamos un sistema de autorización como Oauth2 o herramientas como Keycloak

En cuanto al TDD conozco la filosofía pero nunca lo he aplicado profesionalmente.
