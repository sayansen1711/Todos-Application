# TODOS APPLICATION – SPRING BOOT

A secure, full-stack Todo Management application built using Spring Boot, Spring Security, Spring Data JPA, MySQL, and JSP.
The application supports user authentication, signup, and user-specific todo management.

# FEATURES

# Authentication and Security

- User signup and login

- Password encryption using BCrypt

- Auto-login after successful signup

- Role-based access control (ROLE_USER)

- Session-based authentication using Spring Security

# Todo Management

- Create, update, delete todo items

- Each todo is associated with a specific user

- Mark todos as completed

- Target date validation (future or present only)

- Server-side validation with clear error messages

# Database

- MySQL database integration

- JPA and Hibernate ORM

- Persistent storage for users and todos

# Architecture

- DTO pattern for safe data transfer

- Clear separation of Controller, Service, Repository layers

- Entity to DTO mapping for security and maintainability

# TECH STACK

- Backend: Spring Boot
- Security: Spring Security
- ORM: Spring Data JPA (Hibernate)
- Database: MySQL
- View Layer: JSP with JSTL
- Build Tool: Gradle
- Java Version: Java 17

# PROJECT STRUCTURE

- src/main/java/com/project/todos

- config

-- SpringSecurityConfig.java

- controller

-- LoginController.java

-- SignupController.java

-- TodoController.java

- dto

-- TodoDTO.java

-- UserDTO.java

- entity

-- TodoEntity.java

-- UserEntity.java

- repository

-- TodoRepository.java

-- UserRepository.java

- service

-- TodoService.java

-- UserService.java

- TodosApplication.java

# DATABASE STRUCTURE

- Users Table

-- id (Primary Key)

-- username (unique)

-- email

-- password

-- role

- Todos Table

-- id (Primary Key)

-- description

-- target_date

-- done

-- username (Foreign Key)

# APPLICATION CONFIGURATION

- application.properties example:

- spring.datasource.url=jdbc:mysql://localhost:3306/todosDB
- spring.datasource.username=root
- spring.datasource.password=your_password

- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.show-sql=true

- spring.mvc.view.prefix=/WEB-INF/jsp/
- spring.mvc.view.suffix=.jsp

# RUNNING THE APPLICATION

Prerequisites

- Java 17 or higher

- MySQL

- Gradle

- IDE (IntelliJ IDEA recommended)

# Steps

- Clone the repository

- Navigate to project directory

- Run the application using Gradle

- The application will start at:
-- http://localhost:8080/login

# VALIDATION RULES

- Todo description must contain at least 10 characters

- Target date must be today or a future date

- Username must be unique

- Passwords are always stored in encrypted format

# WHY DTO IS USED

DTOs are used to:

- Prevent exposing database entities directly to the UI

- Protect against over-posting and mass assignment attacks

- Control data flow between layers

- Improve long-term code maintainability

# SECURITY FLOW

- User signs up

- Password is encrypted

- User data is saved to the database

- Authentication is performed programmatically

- SecurityContext is updated

- User is redirected to the welcome page

# FUTURE ENHANCEMENTS

- REST API version

- Pagination and sorting

- Remember-me authentication

- Email verification

- Swagger API documentation

- React frontend integration

# AUTHOR

Sayan Sen
Automation Engineer | Spring Boot Developer
