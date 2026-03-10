# Product Order System

Spring Boot REST API for managing products, cart, and orders.

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

## Setup

Clone project

git clone https://github.com/rahulkotgyale/Product-Order.git

Configure database in application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/ordersystem
spring.datasource.username=root
spring.datasource.password=root

Run application

mvn spring-boot:run

## API

POST /products  
GET /products  
GET /products/{id}  
PUT /products/{id}  
DELETE /products/{id}

POST /cart/add  
GET /cart  

POST /orders/create  
GET /orders
