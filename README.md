# 🌸 Florería Valeria - Proyecto Final
❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀  ❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁
## 📌 Descripción
Aplicación ecommerce hecha con **Spring Boot**, **Thymeleaf**, **Spring Security** y **MySQL**.  
Permite a los clientes iniciar sesión, ver un catálogo de flores y usar un carrito de compras.  
También incorpora un panel de administración para gestionar productos mediante CRUD.


## Tecnologías que utilicé
- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- Thymeleaf
- MySQL
- Bootstrap 5
- HTML, CSS y JS

❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀

##  Base de datos
Crear la base de datos en MySQL:

```sql
CREATE DATABASE paraportafolio;
```

❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀

## Configuración
Archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/paraportafolio
spring.datasource.username=root
spring.datasource.password=123

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀

## Ejecución local

### Desde IntelliJ IDEA
1. Abrir el proyecto.
2. Esperar que Maven descargue dependencias.
3. Ejecutar `PortafolioProjectApplication.java`.

### Desde terminal
```bash
mvn spring-boot:run
```
❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀

## Rutas que utilicé
- `/` → Redirección al catálogo
- `/catalogo` → Catálogo de flores
- `/login` → Inicio de sesión
- `/carrito` → Carrito de compras
- `/admin` → Panel de administración

❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀

## Credenciales para Testear el Prototipo

### Cliente
- Usuario: `cliente@test.com`
- Contraseña: `1234`

❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀
### Administrador
- Usuario: `admin@test.com`
- Contraseña: `admin123`

---
❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀❁✿❀
## Funcionalidades
- Login simple admin y cliente
- Catálogo con tarjetas de productos (flores )
- Carrito con agregar, eliminar, actualizar cantidad y total
- CRUD de productos para el administrador
- BD hecha en MySQL
- Formularios y sus respectivas validaciones
- Mensaje de error
- Productos

