# API Gateway Microservices Project

This project implements a microservices architecture with an API Gateway. The goal is to build a scalable and well-documented application, including security, testing, and deployment via containers.

---

## 🌟 Project Overview

### Theme
The theme of this project is **Sport Management**. This system manages members, teams, and matches within a sports organization.

### Microservices and Components
The project consists of the following components:
- **API Gateway:** Responsible for routing requests to the appropriate services and implementing security via OAuth2.
- **Microservices:**
  - **Leden-service:** Handles the CRUD operations for members (add, retrieve, update, and delete member data such as name, age, and email).
  - **Team-service:** Handles the CRUD operations for teams (add, retrieve, update, and delete teams with details such as team name and city).
  - **Wedstrijd-service:** Handles the CRUD operations for matches (add, retrieve, update, and delete matches, including details such as teams, date, and location).
- **Databases:**
  - **MongoDB (NoSQL):** Used in **leden-service** for storing member information.
  - **MySQL (relational):** Used in **team-service** and **wedstrijd-service** for managing team and match data.

---

## 📊 Component Diagram
![Component Diagram](./schema.png)
> Add a visual overview of the components, including gateways, services, databases, and interactions.

---

## 📖 API Documentation

### General API Specifications
- **Methods:** Each service supports at least 3 GET, 1 POST, 1 PUT, and 1 DELETE method.
- **Parameters:**
  - **Path parameters:** For example, `/leden/{id}`, where `{id}` is the unique identification of a member.
  - **Query parameters:** For example, `/wedstrijden?teamId=5`, where `teamId` is a query parameter to retrieve matches for a specific team.
  - **Body:** For POST and PUT requests, the data is sent in JSON format.

### Endpoints

#### Leden-service
| Method  | Endpoint            | Description                |
|---------|---------------------|----------------------------|
| **GET** | /leden              | Get all members            |
| **GET** | /leden/{id}         | Get member by ID           |
| **GET** | /leden/search?name=X| Search members by name     |
| **POST**| /leden              | Add a new member           |
| **PUT** | /leden/{id}         | Update member details      |
| **DELETE**| /leden/{id}        | Delete a member            |

#### Team-service
| Method  | Endpoint             | Description                |
|---------|----------------------|----------------------------|
| **GET** | /teams               | Get all teams              |
| **GET** | /teams/{id}          | Get team by ID             |
| **GET** | /teams/search?name=X | Search teams by name       |
| **POST**| /teams               | Add a new team             |
| **PUT** | /teams/{id}          | Update team details        |
| **DELETE** | /teams/{id}        | Delete a team              |

#### Wedstrijd-service
| Method  | Endpoint             | Description                |
|---------|----------------------|----------------------------|
| **GET** | /wedstrijden         | Get all matches            |
| **GET** | /wedstrijden/{id}    | Get match by ID            |
| **GET** | /wedstrijden/search?location=X | Search matches by location |
| **POST**| /wedstrijden         | Add a new match            |
| **PUT** | /wedstrijden/{id}    | Update match details       |
| **DELETE** | /wedstrijden/{id}  | Delete a match             |

---

## CI/CD
GitHub Actions is configured to automatically build and deploy containers.

---

## 🔐 Security
- **Authentication:** OAuth2 is implemented via the API Gateway.
  - **Secure endpoints:** `/leden/**`, `/teams/**`, `/wedstrijden/**`
  - **Unsecure endpoints:** `/`, `/login`, `/error`

---

## ✅ Testing

### Unit Testing
Each service contains unit tests for service classes. The tests can be found in the `test` folder within each service.

---

## 🔗 Project Link
- [GitHub Repository](https://github.com/Alae-M/voetbal-beheer-systeem)

---

## 🛠 Deployment

### Docker
- **Dockerfiles:** Each service and the API Gateway has its own Dockerfile. View the **[Dockerfile](./path-to-dockerfiles)** in the respective folders.
- **Docker Compose:** All components are deployed together using `docker-compose.yml`. View the file **[here](./docker-compose.yml)**.

---

## 📝 Model Classes Information

### 1. **Lid (Member) Model (leden-service)**
```java
package com.example.ledenservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "leden")
public class Lid {
    @Id
    private String id;
    private String name;
    private int age;
    private String email;

    // Constructors
    public Lid() {}

    public Lid(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
