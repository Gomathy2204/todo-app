📌 To-Do App

A full-stack To-Do List Application built using:

HTML, CSS, JavaScript (Frontend)

Spring Boot + JDBC (Backend)

MySQL Database

This project allows users to add, complete, and delete tasks with full CRUD API support.


🚀 Features

✔ Add new tasks
✔ Mark tasks as completed / uncompleted
✔ Delete tasks
✔ Tasks stored permanently in MySQL
✔ Clean UI (HTML + CSS + JS)
✔ REST API using Spring Boot
✔ JDBC for database operations


🧩 Tech Stack
Frontend:
HTML
CSS
JavaScript

Backend:
Java
Spring Boot
JDBC
REST API

Database:
MySQL


📦 Project Structure:

todo-app/
 ├── backend/
 │     ├── src/main/java/com/todo/todoapp/
 │     ├── pom.xml
 │     └── ...
 ├── frontend/
 │     ├── index.html
 │     ├── to-dolist.html
 │     ├── todo.js
 │     ├── style.css
 │     └── ...
 └── README.md

 🗄 Database Setup:
Create database:
CREATE DATABASE todoapp;

Create table:
CREATE TABLE tasks (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  completed BOOLEAN
);

Configure application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/todoapp
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

▶️ Running the Backend (Spring Boot)

Open the backend folder

Run:

mvn spring-boot:run


Backend runs on:

http://localhost:8080

▶️ Running the Frontend

Open:

frontend/to-dolist.html

http://localhost:8080/Frontend/to-dolist.html


Or run using Live Server.

🔗 API Endpoints
Method	Endpoint	Description
GET	/tasks	Get all tasks
POST	/tasks	Add new task
PUT	/tasks/{id}	Update task status
DELETE	/tasks/{id}	Delete task


