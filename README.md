# MANOFACIL - Marketplace de Servicios Domésticos
###### _Conectando hogares con profesionales confiables_ ✨

<div align="center">

![Progress](https://img.shields.io/badge/Estado-En%20Desarrollo-%2300cc00?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-17-%23ED8B00?logo=openjdk&style=for-the-badge)
![Spring](https://img.shields.io/badge/Spring%20Boot-3.2-%236DB33F?logo=spring&style=for-the-badge)

</div>

## 👥 Equipo
#### **Valeria Saidid Miranda Ibarra**

## Índice
<details>
<summary>🔍 Ver índice detallado</summary>

1. [Introducción](#introducción)
2. [Identificación del Problema o Necesidad](#identificación-del-problema-o-necesidad)
3. [Descripción de la Solución](#descripción-de-la-solución)
4. [Modelo de Entidades](#modelo-de-entidades)
5. [Testing y Manejo de Er[README.md](README.md)rores](#testing-y-manejo-de-errores)
6. [Medidas de Seguridad Implementadas](#medidas-de-seguridad-implementadas)
7. [Eventos y Asincronía](#eventos-y-asincronía)
8. [GitHub](#github)
9. [Conclusión](#conclusión)
10. [Apéndices](#apéndices)

</details>

---

## 🧭 Introducción

### 📌 Contexto
<p align="center">
  <img src="images/imagenproblema.jpg" width="300"/>
</p>


En el contexto peruano, muchas personas requieren servicios domésticos confiables como plomería, electricidad, jardinería y limpieza. Sin embargo, encontrar profesionales confiables puede ser complicado. MANOFÁCIL nace como una solución digital a esta necesidad cotidiana.


### 🎯 Objetivos del Proyecto

* Crear un sistema web que conecte usuarios con profesionales del hogar.
* Garantizar la seguridad de los datos y la facilidad de uso.
* Automatizar procesos como registros, reservas y pagos.

---

## 🔍 Identificación del Problema o Necesidad

### ❗ Descripción del Problema

La informalidad en la contratación de servicios domésticos implica riesgos para usuarios y trabajadores. Muchos usuarios dependen del "boca a boca" sin garantías sobre la calidad o la seguridad.

### 💡 Justificación

Este proyecto contribuye a digitalizar el acceso a servicios domésticos, ofreciendo un sistema seguro, organizado y accesible que beneficie a usuarios y profesionales independientes.

---

## 💡 Descripción de la Solución

### ⚙️ Funcionalidades Implementadas (en desarrollo)

* Registro y autenticación de usuarios.
* Asociación de direcciones a usuarios.
* Listado y consulta de usuarios.
* Creación de profesionales.
* Creación de servicios.
* Sistema de reservas de servicios.
* Sistema de calificaciones.
* Integración futura con pasarelas de pago (Stripe/PayPal).

### 🧰 Tecnologías Utilizadas

* Lenguaje: Java 17
* Framework: Spring Boot
* Base de Datos: PostgreSQL
* Herramientas: Maven, Lombok, GitHub, Postman
* API externas previstas: Google Maps API, Stripe/PayPal API

---

## 🧩 Modelo de Entidades

### 📌 Diagrama Entidad-Relación (ERD)

imagen


---

### 📄 Tabla de Entidades y Atributos

| 🧱 Entidad      | 📝 Atributos Principales                                              |
| --------------- | --------------------------------------------------------------------- |
| **Usuario**     | id, nombre, email, contraseña, teléfono                               |
| **Dirección**   | id, ciudad, distrito, referencia, latitud, longitud, usuario_id      |
| **Profesional** | id, nombre, especialidad, experiencia, disponibilidad, usuario_id    |
| **Servicio**    | id, categoría, precio, duración, profesional_id                       |
| **Reserva**     | id, fecha, estado, usuario_id, profesional_id, servicio_id            |
| **Reseña**      | id, puntuación, comentario, usuario_id, profesional_id, reserva_id    |

---

### 🔗 Relaciones entre Entidades

| Relación               | Tipo  | Descripción                                         |
|------------------------|-------|-----------------------------------------------------|
| Usuario ↔ Dirección    | 1 a N | Un usuario puede tener varias direcciones.          |
| Usuario ↔ Reserva      | 1 a N | Un usuario puede realizar muchas reservas.          |
| Profesional ↔ Servicio | 1 a N | Cada profesional puede ofrecer múltiples servicios. |
| Usuario ↔ Reseña       | 1 a N | Un usuario puede dejar varias reseñas.              |
| Profesional ↔ Reseña   | 1 a N | Un profesional puede recibir varias reseñas.        |
| Reserva ↔ Reseña       | 1 a 1 | Cada reserva puede generar una única reseña.        |

---

### 🧠 Observaciones Técnicas

* 🔐 Se usa **clave primaria** (`id`) en todas las entidades.
* 🔄 Las relaciones están implementadas usando **anotaciones JPA** como `@OneToMany`, `@ManyToOne`, `@OneToOne`.
* 📦 Las claves foráneas se manejan automáticamente gracias al **mapeo por objetos** en Spring Boot.
* ✅ Validaciones como `@NotNull`, `@Size`, `@Email` se usan para garantizar la integridad.

---

## 🧪 Testing y Manejo de Errores

### 📊 Niveles de Testing Realizados

* **Unitarios**: validación de entidades y servicios.
* **Integración**: pruebas de endpoints REST con base de datos embebida.
* **Sistema (previsto)**: prueba del sistema completo.
* **Aceptación (previsto)**: evaluación de usuario final.

### ✅ Resultados

* Se han corregido errores de mapeo de entidades, errores 404 y validaciones de campos.

### 🧯 Manejo de Errores

* Se implementa una clase `GlobalExceptionHandler` para manejar:
    * Validaciones (400)
    * Recursos no encontrados (404)
    * Errores internos (500)

---

## 🔐 Medidas de Seguridad Implementadas

### 🔒 Seguridad de Datos

* Se planea usar JWT para autenticación.
* Cifrado de contraseñas con BCrypt.

### 🛡️ Prevención de Vulnerabilidades

* Validación de entradas del usuario.
* Uso de `@Valid` y DTOs para proteger el modelo.
* Prevención futura de CSRF y XSS mediante Spring Security.

---

## ⚙️ Eventos y Asincronía

* Uso de anotaciones `@Async` para procesos como el envío de correos de confirmación y notificaciones.
* Mejora la experiencia del usuario evitando bloqueos innecesarios.

---

## 🌐 GitHub

### 📋 Uso de GitHub Projects

* Planificación de tareas con tableros tipo Kanban.
* Uso de issues para cada funcionalidad.
* Asignación de prioridades por etiquetas (bug, feature, enhancement).

### ⚙️ GitHub Actions (previsto)

* Flujo CI/CD para:
    * Validación de tests automáticos.
    * Despliegue a entorno de prueba (Heroku o Render).

---

## ✅ Conclusión

### 🏆 Logros del Proyecto

* Arquitectura robusta con Spring Boot.
* Entidades correctamente estructuradas.
* Endpoints REST funcionando.

### 📘 Aprendizajes Clave

* Buenas prácticas en diseño de APIs REST.
* Integración de herramientas como Postman y PostgreSQL.
* Uso disciplinado de GitHub para el trabajo individual y en equipo.

### 🚀 Trabajo Futuro

* Implementar autenticación con roles.
* Sistema completo de reservas.
* Integración con pasarelas de pago.
* Implementar panel de administración y frontend con ReactJS.

---

## 📎 Apéndices

### 📄 Licencia

MIT License. Libre para uso, modificación y distribución.

### 🔗 Referencias

* Documentación oficial de Spring Boot
* PostgreSQL.org
* OWASP Top 10
* Stripe Developers
* Google Maps API