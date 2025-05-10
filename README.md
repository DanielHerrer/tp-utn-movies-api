# Proyecto API de Películas 🎬

## Instrucciones para ejecutar

1. Clonar el repositorio:

        git clone https://github.com/DanielHerrer/tp-utn-movies-api

2. Crear un SCHEMA desde tu Cliente de SQL con el nombre "cine_db"

<img src="https://github.com/user-attachments/assets/2ff1e05d-2c55-4cd9-ab17-9881944b579e">

3. Abrir la carpeta "/demo_web" desde Visual Studio Code

4. Instalar la extensión 'Live Server' en VSCode

<img src="https://github.com/user-attachments/assets/3ccb4d6a-bc29-41de-83bf-24d73753f391">

5. Hacer click derecho desde VSCode a "index.html" y darle a "Open with Live Server"

<img src="https://github.com/user-attachments/assets/b6ceaae5-7517-4ee0-89f9-0ae5562c3c11">

6. Abrir la carpeta "/demo" con tu IDE y ejecutar la clase principal "DemoApplication.java"

<img src="https://github.com/user-attachments/assets/a0ae9b77-ea63-4ecb-a5b0-2397f97bb738">

## Requisitos
- Java 21+
- Spring Boot
- Base de datos (MySQL)

## Requests de ejemplo (Postman)

<img src="https://github.com/user-attachments/assets/6151746f-490f-4baa-b738-c5388ceeb6ff">

<img src="https://github.com/user-attachments/assets/84db2080-0a3e-4a65-a42f-b0c0731f18c6" height=200>

POST · Nueva Pelicula

        {{baseUrl}}

GET · Listar todas las Peliculas

        {{baseUrl}}

GET · Listar Pelicula por ID

        {{baseUrl}}/:id

GET · Listar Peliculas por Año de Estreno

        {{baseUrl}}/year/:year

DELETE · Eliminacion lógica de una Pelicula

        {{baseUrl}}/:id

PUT · Actualizar una Pelicula

        {{baseUrl}}/:id (más el Body de la pelicula)