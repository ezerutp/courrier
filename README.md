## 📦 Courrier - Sistema de Gestión de Encomiendas

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)
![Estado](https://img.shields.io/badge/estado-en%20desarrollo-orange)

Sistema web de gestión de encomiendas para empresas de courrier. Este proyecto busca ofrecer una solución integral para el manejo de envíos, sucursales, repartidores y seguimiento de paquetes.

---

## 🚀 Características planeadas

- Registro y gestión de encomiendas 📦
- Generación de código de seguimiento único 🔍
- Gestión de clientes, sucursales y repartidores 🧍🏽🏤🛵
- Búsqueda por placa de vehículo y código de seguimiento
- Seguridad con Spring Security (con y sin autenticación)
- Exportación de reportes (PDF/Excel) 📄
- Diseño responsivo con Bootstrap + Thymeleaf
- Módulo de seguimiento en tiempo real (futuro)
- Dashboard de estadísticas 📊
- Soporte multiusuario con roles (ADMIN, OPERADOR, CLIENTE)

---

## ⚙️ Tecnologías usadas

| Tecnología     | Versión     |
|----------------|-------------|
| Java           | 17          |
| Spring Boot    | 3.x         |
| Spring Data JPA| ✔️          |
| Lombok         | ✔️          |
| MySQL          | ✔️          |
| Thymeleaf      | ✔️          |
| Bootstrap      | ✔️          |

---

## ✅ Avances actuales

- [x] Configuración del proyecto con Spring Boot
- [x] Creación de entidades: `Cliente`, `Encomienda`, `Sucursal`, `Repartidor`
- [x] Relación entre entidades (ManyToOne, OneToMany)
- [x] Repositorios JPA funcionales
- [x] Servicio con anotación `@Transactional` y `@RequiredArgsConstructor`
- [x] Métodos: guardar, listar, buscar por ID, eliminar
- [x] Generación automática de código de seguimiento
- [x] Validaciones con `@NotBlank`, `@Pattern`
- [x] Formularios Thymeleaf básicos para CRUD
- [x] Script SQL de estructura inicial
- [ ] Autenticación Spring Security
- [ ] Sistema de tracking de encomiendas
- [ ] Exportación de reportes
- [ ] Responsive completo y diseño estético

---

## 📂 Estructura del proyecto

```
courrier/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── pe/transporte/courrier/
│   │   │       ├── entities/
│   │   │       ├── controllers/
│   │   │       ├── services/
│   │   │       └── repositories/
│   │   ├── resources/
│   │       ├── templates/
│   │       ├── static/
│   │       └── application.properties
├── pom.xml
```

---

## 🔧 Cómo ejecutar

```bash
# Clona el proyecto
git clone https://github.com/ezerutp/courrier.git
cd courrier

# Ejecuta con Maven
mvn spring-boot:run
```

Accede a la app en: `http://localhost:8080`

---

## 🧠 Colaboradores

- [@ezerutp](https://github.com/ezerutp) - Desarrollador principal

---

## 📝 Licencia

Este proyecto está bajo la licencia MIT - consulta el archivo [LICENSE](LICENSE) para más detalles.

---

## ❤️ Apóyanos

¿Te gusta este proyecto? ¡Dale una estrella ⭐ en GitHub y compártelo!

[![Star](https://img.shields.io/github/stars/ezerutp/courrier?style=social)](https://github.com/ezerutp/courrier)
