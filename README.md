# 🛍️ API REST - Gestión de Productos

Proyecto desarrollado para la asignatura **Desarrollo de Software** de la carrera **Ingeniería en Sistemas de Información - UTN FRM**.

Este sistema provee una **API REST completa** para gestionar productos con operaciones CRUD, validaciones, manejo global de excepciones, capa de persistencia con JPA/H2 y documentación con Swagger (OpenAPI).

---

## ⚙️ Tecnologías utilizadas

- ✅ **Java 21**
- ✅ **Spring Boot 3.5**
- ✅ **Spring Data JPA** (persistencia)
- ✅ **H2 Database** (base de datos en memoria)
- ✅ **Spring Validation**
- ✅ **Springdoc OpenAPI / Swagger UI**
- ✅ **Lombok**
- ✅ **Maven** (gestión de dependencias)

---

## 🚀 Instrucciones para clonar y ejecutar
1. Clonar el repositorio:
```bash 
   git clone https://github.com/LisanCar/Productos-Api.git
   ``` 
2. Entrar a la carpeta del proyecto:
```bash
  cd productos-api
  ```
  
3. Compilar y ejecutar el proyecto:
```bash
  mvn spring-boot:run
  ```
  
4. Acceder desde el navegador a:

Swagger UI 👉 http://localhost:8080/swagger-ui/index.html 

Consola H2 👉 http://localhost:8080/h2-console

---
## 🌐 Endpoints principales

| Método | Ruta | Descripción |
|:-------:|:---------------------------------------------------|:---------------------------------------------|
| **GET** | `/api/productos` | Lista todos los productos registrados |
| **GET** | `/api/productos/{id}` | Obtiene un producto específico por su ID |
| **GET** | `/api/productos/categoria/{categoria}` | Filtra y lista los productos por categoría |
| **POST** | `/api/productos` | Crea un nuevo producto (requiere `ProductoDTO`) |
| **PUT** | `/api/productos/{id}` | Actualiza completamente un producto existente |
| **PATCH** | `/api/productos/{id}/stock` | Actualiza **solo el stock** de un producto |
| **DELETE** | `/api/productos/{id}` | Elimina un producto por su ID |

---

### ⚙️ Códigos de estado HTTP comunes

| Código | Significado |
|:-------:|:------------|
| **200** | Solicitud exitosa (OK) |
| **201** | Recurso creado exitosamente |
| **204** | Recurso eliminado exitosamente (sin contenido) |
| **400** | Error de validación de datos |
| **404** | Recurso no encontrado |
| **500** | Error interno del servidor |

---

## 📸 Capturas de pantalla

### 📘 Documentación completa

![Swagger UI - Documentación completa](screenshots/swagger_fullscreen.png)

---

### ✅ Creación exitosa de producto (POST)

![POST Creación exitosa](screenshots/POST_responses.png)

---

### 🔍 Listado de productos (GET)

![GET Listar productos](screenshots/GET_responses.png)

---

### ⚠️ Producto no encontrado (Error 404)

![Error 404 - Producto inexistente](screenshots/Error404.png)

---

### 🚫 Error de validación (Error 400)

![Error 400 - Validación de datos](screenshots/Error400.png)

---

### 🗄️ Consola H2 con datos persistidos

![Consola H2 - Datos persistidos](screenshots/h2.png)

---

## 👤 Autor
Nombre: Lisandro Carrillo 

Legajo: 50831 

📧 carrillo.lisan@gmail.com 

📅 Año: 2025 
