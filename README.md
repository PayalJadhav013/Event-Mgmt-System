# Event Management System

## Overview
This project is an Event Management System built with Java, Spring Boot, PostgreSQL, JPA, and REST API for the backend. The frontend is developed using Angular, TypeScript, HTML, CSS, and JavaScript. The application allows users to manage events, attendees, and registrations with a seamless user experience.

## Project Structure
Backend
The backend is a Spring Boot application that interacts with a PostgreSQL database and exposes RESTful APIs.

backend/
├── src/
│   ├── main/
│   │   ├── java/com/eventmanagement/
│   │   │   ├── config/          # Configuration classes
│   │   │   ├── controller/      # REST controllers
│   │   │   ├── dto/             # Data Transfer Objects
│   │   │   ├── exception/       # Exception handling
│   │   │   ├── model/           # Entity classes
│   │   │   ├── repository/      # JPA repositories
│   │   │   ├── service/         # Business logic
│   │   │   └── EventManagementApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   └── test/                    # Test classes
├── pom.xml

## Frontend
The frontend is built with Angular and provides a clean UI for managing events, attendees, and registrations.

frontend/
├── src/
│   ├── app/
│   │   ├── components/
│   │   │   ├── event/
│   │   │   │   ├── event-list/
│   │   │   │   ├── event-details/
│   │   │   │   ├── event-create/
│   │   │   │   └── event-edit/
│   │   │   ├── attendee/
│   │   │   │   ├── attendee-list/
│   │   │   │   ├── attendee-details/
│   │   │   │   ├── attendee-create/
│   │   │   │   └── attendee-edit/
│   │   │   ├── registration/
│   │   │   │   ├── registration-list/
│   │   │   │   └── registration-create/
│   │   │   └── shared/
│   │   │       └── confirmation-dialog/
│   │   ├── models/
│   │   ├── services/
│   │   ├── app.routes.ts
│   │   └── app.config.ts
│   ├── assets/
│   ├── environments/
│   ├── index.html
│   └── styles.css
├── angular.json
├── package.json
└── tsconfig.json

## Installation and Setup
Prerequisites

Before you start, ensure you have the following installed:

Java 17+

Spring Boot

PostgreSQL database running

Node.js (for frontend)

Angular CLI

## Steps
   1. Clone the repository
      git clone https://github.com/PayalJadhav013/Event-Mgmt-System.git
   2. Backend Setup
      > Navigate to the backend/ folder:
        cd backend
      > Install dependencies using Maven:
        mvn clean install
      > Configure application.properties with your PostgreSQL database details:
        spring.datasource.url=jdbc:postgresql://localhost:5432/yourdbname
        spring.datasource.username=yourusername
        spring.datasource.password=yourpassword
      > Run the Spring Boot application:
        mvn spring-boot:run
   3. Frontend Setup
      > Navigate to the frontend/ folder:
        cd frontend
      > Install Angular dependencies:
        npm install
      > Start the Angular development server:
        ng serve
   4. Access the Application
      > Backend will be running at http://localhost:8080/.
      > Frontend will be running at http://localhost:4200/.
      > Open your browser and go to the Angular app at http://localhost:4200/ to interact with the Event Management System.

## Contribution
   Feel free to fork this repository, make changes, and submit pull requests. Please follow best practices for code formatting and include tests for new features or bug fixes.

## License
   This project is licensed under the MIT License - see the LICENSE file for details.
      
      
