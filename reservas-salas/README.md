# Sistema de Reservas de Salas de Reuniones

## A. Descripción general

Este proyecto consiste en una aplicación Java que permite gestionar la reserva de salas de reuniones dentro de una empresa. El sistema permite:

- Registrar empleados
- Crear y listar salas
- Realizar reservas indicando fecha y horario

Está desarrollado en Java, utilizando MySQL como sistema de base de datos y aplicando el patrón DAO (Data Access Object) para separar la lógica de acceso a datos.

---

## B. Cómo ejecutar el proyecto

1. Clona o descarga este repositorio en tu máquina local.
2. Abre el proyecto directamente en Eclipse.  
   Alternativamente, puedes usar un workspace e importar el proyecto desde allí.
3. Asegúrate de que el servidor MySQL está en ejecución.
4. Ejecuta la clase `App.java` para iniciar la aplicación y probar su funcionamiento.
5. Para ejecutar los tests unitarios, abre y ejecuta la clase `AppTest.java` con JUnit.

---

## C. Instrucciones para importar y usar la base de datos

1. Abre MySQL Workbench.
2. Ejecuta el archivo `script.sql` incluido en el proyecto.  
   Esto creará automáticamente:
   - La base de datos `reservas_db`
   - Las tablas `empleados`, `salas`, y `reservas`
   - Datos de prueba para comenzar a usar la aplicación

3. Verifica que la base de datos ha sido creada correctamente.

---

### NOTA IMPORTANTE: Configuración de conexión a la base de datos

Este proyecto está configurado para conectarse a un servidor MySQL local, utilizando las siguientes credenciales por defecto, 
si cambias o se cambia algo de eso al crear la base de datos, debes modificar esas credenciales en la calse ConexionBD.java para que funcione correctamente:

```java
private static final String URL = "jdbc:mysql://localhost:3306/reservas_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
private static final String USUARIO = "root";
private static final String CONTRASENA = "1234";