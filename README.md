📝 Todos Application – Spring Boot

A secure, full-stack Todo Management application built using Spring Boot, Spring Security, Spring Data JPA, MySQL, and JSP.
The application supports user authentication, signup, and user-specific todo management.

🚀 Features
🔐 Authentication & Security

User Signup & Login

Password encryption using BCrypt

Auto-login after successful signup

Role-based access control (ROLE_USER)

Session-based authentication with Spring Security

✅ Todo Management

Create, update, delete todos

User-specific todos (each todo belongs to a user)

Mark todo as completed (done)

Target date validation (@FutureOrPresent)

Server-side validation with meaningful error messages

🗄️ Database

MySQL database integration

JPA/Hibernate ORM

Persistent storage of users and todos

🧱 Clean Architecture

DTO pattern for safe data transfer

Separation of concerns (Controller, Service, Repository)

Entity ↔ DTO mapping

🛠️ Tech Stack
Layer	Technology
Backend	Spring Boot
Security	Spring Security
ORM	Spring Data JPA (Hibernate)
Database	MySQL
View	JSP + JSTL
Build Tool	Gradle
Java Version	Java 17
📂 Project Structure
src/main/java/com/project/todos
│
├── config
│   └── SpringSecurityConfig.java
│
├── controller
│   ├── LoginController.java
│   ├── SignupController.java
│   └── TodoController.java
│
├── dto
│   ├── TodoDTO.java
│   └── UserDTO.java
│
├── entity
│   ├── TodoEntity.java
│   └── UserEntity.java
│
├── repository
│   ├── TodoRepository.java
│   └── UserRepository.java
│
├── service
│   ├── TodoService.java
│   └── UserService.java
│
└── TodosApplication.java

🗃️ Database Schema
🧑 Users Table
users
-----
id (PK)
username (unique)
email
password
role

📌 Todos Table
todos
-----
id (PK)
description
target_date
done
username (FK)

⚙️ Configuration
application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/todosDB
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp

▶️ Running the Application
Prerequisites

Java 17+

MySQL

Gradle

IDE (IntelliJ recommended)

Steps
git clone https://github.com/your-username/todos-application.git
cd todos-application
./gradlew bootRun


Access the app at:

http://localhost:8080/login

🧪 Validation Rules

Todo description: minimum 10 characters

Target date: today or future only

Username must be unique

Passwords are encrypted before saving

🔄 DTO Usage (Why it exists)

DTOs are used to:

Prevent exposing database entities directly to UI

Avoid over-posting attacks

Control exactly what data flows between layers

Improve long-term maintainability

🔐 Security Flow

User signs up

Password is encrypted

User is saved to DB

Auto-authentication via AuthenticationManager

SecurityContext is updated

Redirect to /welcome

📌 Future Enhancements

REST API version

Pagination & sorting

Remember-me login

Email verification

Swagger documentation

React frontend

👨‍💻 Author

Sayan Sen
Automation Engineer | Spring Boot Developer
