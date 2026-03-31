# 🌸 Florería Valeria - Proyecto Final
https://github.com/valeriahernan/portafolioproject
<a href="https://ibb.co/HT6ktVHZ"><img src="https://i.ibb.co/HT6ktVHZ/portafolioproject1.png" alt="portafolioproject1" border="0"></a> <a href="https://ibb.co/PZFS0dGd"><img src="https://i.ibb.co/PZFS0dGd/portafolioproject2.png" alt="portafolioproject2" border="0"></a> <a href="https://ibb.co/R40SsyQM"><img src="https://i.ibb.co/R40SsyQM/portafolioproject2-admin.png" alt="portafolioproject2-admin" border="0"></a> <a href="https://ibb.co/fz0qLdTq"><img src="https://i.ibb.co/fz0qLdTq/portafolioproject2-cliente.png" alt="portafolioproject2-cliente" border="0"></a>
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

