# Proyecto API de Películas 🎬

## Instrucciones para ejecutar

1. Clonar el repositorio:

git clone https://github.com/DanielHerrer/tp-utn-movies-api

2. Abrir el proyecto con tu IDE y ejecutar la clase principal.

## Requisitos
- Java 21+
- Spring Boot
- Base de datos (MySQL)

## Requests de ejemplo (Postman)

{{baseUrl}} = localhost:8080/movies

POST {{baseUrl}}

GET {{baseUrl}}
GET {{baseUrl}}/:id
GET {{baseUrl}}/year/:year

PUT {{baseUrl}}/:id 
(más el Body de la pelicula)

DELETE {{baseUrl}}/:id
