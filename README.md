# Focus Track API

![status](https://img.shields.io/badge/status-active-brightgreen)
![Java](https://img.shields.io/badge/Java-blue?logo=java\&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-brightgreen?logo=spring\&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-blue?logo=postgresql\&logoColor=white)
![OpenAPI](https://img.shields.io/badge/OpenAPI-orange?logo=openapi\&logoColor=white)

**Focus Track API** is a backend service built with **Spring Boot** and **PostgreSQL**, designed to support the Focus Track frontend. It provides secure authentication, CRUD endpoints for projects, goals, and steps, and features for project management and goal tracking.

The frontend repository is available [here](https://github.com/cstefc/focus_track_ui).

---

## Tech Stack

* **Backend Framework:** Spring Boot
* **Database:** PostgreSQL 17
* **Language:** Java 21
* **Authentication:** Firebase Authentication (OAuth2 / JWT)
* **Front-end:** React [(link to repo)](https://github.com/cstefc/focus_track_ui)
* **Documentation:** OpenAPI

---

## Features

* **Authentication & Authorization:** Secure communication via Firebase JWT tokens. Endpoints are protected; tokens must be sent in requests using the `Authorization: Bearer <token>` header.
* **CRUD Endpoints:**

  * `/projects`: GET, POST, PUT, DELETE
  * `/goals`: GET, POST, PUT, DELETE
  * `/steps`: GET, POST, PUT, DELETE
* **Development Mode:** Mock data available for front-end development and testing. Token verification can be bypassed using the Spring `dev` profile.
* **Environment Variables:** Database credentials and other sensitive information stored in `.env` files.
* **Unit & Integration Tests:** Basic setup provided for automated testing.

---

## Roadmap

Planned features and improvements:

* **Logging Feature:** Track progress and updates within projects.
* **Events:** Manage events related to goals and projects.
* **Dashboard Endpoints:** Provide statistics for dashboards.

---

## Prerequisites

* PostgreSQL database + appUser for the API
* Firebase project for authentication
* Java 21 installed

---

## Setup Instructions

### 1. Create `.env` file

Create a `.env` file in the project root (or set environment variables locally) with the following defaults:

```
DATABASE_HOST=db-hostname
DATABASE_PORT=db-port
DATABASE_NAME=db-name
DATABASE_USER=db-user
DATABASE_PASSWORD=something hard
FIREBASE_KEY_PATH=/path/to/private-key.json
SERVER_PORT=8080
CORS_ALLOWED_ORIGINS: http://localhost:5173
```

---

### 2. Add Firebase Service Account

Download the private key from your Firebase console:
[Firebase Service Account Tutorial](https://clemfournier.medium.com/how-to-get-my-firebase-service-account-key-file-f0ec97a21620)

Place the JSON file at the location specified in your environment variables.

---

### 3. Run the Application

#### Linux / macOS

```
./mvnw spring-boot:run
```

#### Windows

```
mvnw.cmd spring-boot:run
```

---

### 4. Verify API

Once running, visit:
`http://localhost:8080/public/docs`

> ⚠️ All protected endpoints require the header:
> ```
> Authorization: Bearer <JWT token from Firebase login>
> ```

---

### 5. Development Mode (Optional)

To bypass token verification and use mock data during development, use the Spring `dev` profile to load development settings.

> ⚠️ Do not use development mode in production.
