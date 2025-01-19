# Foro Hub

![Badge-Spring](https://github.com/user-attachments/assets/c385e117-c5eb-4178-b890-3af1e65670bd)


## 📝 Descripción
Este proyecto es una API REST para gestionar los topicos de un foro de discusión. Presenta la funcionalidad de autenticacion mediante JWT. Este proyecto está desarrollado en Java con el framework de Spring Boot y una base de datos usando el gestor de MySQL.


## ✨ Características principales
- ✅ **Gestión de topicoa**: Registro, listado, busqueda mediante id, eliminación y actualización de tópicos
- 🔐 **Autenticación**: Sistema basado en JWT para proteger las rutas.

## Estructura del proyecto
El proyecto sigue una estructura de división por capas, está estructurado mediante los siguientes paquetes:
1. domain: Paquete que contiene todas las clases encargadas de modelar los datos y contiene las clases con las entidades correspondientes que realizan el mapeo en la Base de datos. A su vez está dividido en dos paquetes que son:
  -usuario
  -topicos
2. controller: Paquete que contiene las clases TopicoController, que se encarga de recibir las peticiones del cliente y responder de acuerdo a las reglas de negocio establecidas, hace uso del paquete service. A su vez La clase AutenticacionController se encarga de
  poder obtener un token de acceso en caso de que el usuario que se intenta loguear esté registrado.
3. service: contiene las clases que se encargan de validar la lógica de negocio y de acceder a los recursos por medio de la inyección de dependencias del repositorio de los topicos.
4. infra: a su vez contiene dos paquetes: errors, que se encarga del manejo de las excepciones por medio de la clase TratadorDeErrores usando la notación @RestControllerAdvice y el paquete security, que contiene las clases que se encargan de realizar la configuracion de seguridad y de poder realizar la autenticacion por medio de jwt 

## 📋 Requisitos
- ☕ **Java 17** o superior
- 🛠️ **Maven 3.9.9** o superior
- 🐬 **MySQL**

## Autor

Desarrollado por [J. Abraham Ochoa Velásquez].
