<div align="center">

# Booking & Review Service

### A secure, scalable Spring Boot microservice for reservations and customer reviews

[![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)

[![Maven](https://img.shields.io/badge/Maven- build- C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/)

[![MySQL](https://img.shields.io/badge/MySQL-database-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)

[![License](https://img.shields.io/badge/License-TBD-lightgrey?style=for-the-badge)](#license)

<p>
  <strong>Booking & Review Service</strong> is a backend service designed to manage reservation and review workflows in a distributed application ecosystem.
  It combines REST APIs, persistence, security, service discovery, configuration management, and event-driven integration in one maintainable Spring Boot application.
</p>

[Explore the repository](https://github.com/DalalYouness/booking-and-review-service-pfe) · [Report a bug](https://github.com/DalalYouness/booking-and-review-service-pfe/issues) · [Request a feature](https://github.com/DalalYouness/booking-and-review-service-pfe/issues)

</div>

---

## Contents

- [Overview](#overview)
- [Features](#features)
- [Technology stack](#technology-stack)
- [Architecture](#architecture)
- [Project structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Getting started](#getting-started)
- [Configuration](#configuration)
- [Database migrations](#database-migrations)
- [API documentation](#api-documentation)
- [Testing](#testing)
- [Build and packaging](#build-and-packaging)
- [Contributing](#contributing)
- [License](#license)

## Overview

This project is the booking and review bounded context of a broader platform. It provides a foundation for:

- Managing reservation records and their lifecycle.
- Managing reviews associated with completed experiences or reservations.
- Persisting domain data with Spring Data JPA and MySQL.
- Protecting endpoints with Spring Security and JWT-based authentication.
- Publishing or consuming domain events through Apache Kafka.
- Integrating with other services through OpenFeign.
- Registering with Eureka and loading centralized configuration through Spring Cloud.

> **Note:** The exact endpoint contracts and service URLs are defined by the implementation and the environment in which this service is deployed.

## Features

- **Reservation management** with a persisted reservation lifecycle.
- **Review management** backed by dedicated review tables.
- **JWT-aware security** for authenticated and authorized access.
- **Database versioning** with Flyway migrations.
- **Service-to-service communication** with OpenFeign.
- **Event-driven integration** with Spring Kafka.
- **Service discovery** through Netflix Eureka Client.
- **Centralized configuration support** through Spring Cloud Config Client.
- **API validation and consistent error handling** using Spring validation and application exception handlers.
- **OpenAPI/Swagger support** for interactive API exploration.
- **Operational visibility** through Spring Boot Actuator.

## Technology stack

| Area | Technology |
| --- | --- |
| Language | Java 21 |
| Framework | Spring Boot 3.5.x |
| Web/API | Spring Web, Spring Validation |
| Persistence | Spring Data JPA, Hibernate |
| Database | MySQL |
| Migrations | Flyway |
| Security | Spring Security, JWT |
| Messaging | Apache Kafka |
| Distributed systems | Spring Cloud Config, Eureka Client, OpenFeign |
| API documentation | Springdoc OpenAPI / Swagger UI |
| Mapping and boilerplate reduction | MapStruct, Lombok |
| Build | Maven Wrapper |
| Testing | Spring Boot Starter Test, Spring Security Test |

## Architecture

The service follows a layered, domain-oriented structure:

```text
HTTP client
    │
    ▼
Web / controllers ──► DTOs & validation
    │
    ▼
Services / business rules
    │          ├──► Repositories ──► MySQL
    │          ├──► Feign clients ──► other platform services
    │          └──► Messaging ──────► Kafka
    │
    ├── Security / JWT
    ├── Exception handling
    └── Mappers / entities
```

The application can participate in a larger microservice environment through Config Server, Eureka, Feign, and Kafka integrations. For local development, those dependencies should be available or explicitly disabled/configured for the target environment.

## Project structure

```text
.
├── pom.xml
├── mvnw / mvnw.cmd                 # Maven Wrapper scripts
├── src
│   ├── main
│   │   ├── java/com/dalal/boukingandreviewservicepfe
│   │   │   ├── config              # Application configuration
│   │   │   ├── dtos                # Request and response models
│   │   │   ├── entities            # JPA entities
│   │   │   ├── enums               # Domain enumerations
│   │   │   ├── exceptions          # Application exceptions
│   │   │   ├── feign               # OpenFeign integrations
│   │   │   ├── handler             # Exception and web handlers
│   │   │   ├── mappers             # Entity/DTO mappings
│   │   │   ├── messaging           # Kafka integration
│   │   │   ├── repositories        # Data access layer
│   │   │   ├── security            # Security and JWT components
│   │   │   ├── services            # Business services
│   │   │   └── web                 # Web/API layer
│   │   └── resources
│   │       ├── application.properties
│   │       └── db/migration         # Flyway SQL migrations
│   └── test                         # Automated tests
└── README.md
```

## Prerequisites

Before running the service locally, install or make available:

- Java Development Kit (JDK) 21.
- Git.
- MySQL.
- Apache Kafka, when messaging functionality is enabled.
- Spring Cloud Config Server and Eureka Server, when running in the complete microservice environment.

## Getting started

### 1. Clone the repository

```bash
git clone https://github.com/DalalYouness/booking-and-review-service-pfe.git
cd booking-and-review-service-pfe
```

### 2. Prepare the supporting services

Create a MySQL database for the service and make sure the database credentials, Kafka broker, Config Server, and Eureka settings match your local environment. Do not commit passwords, private keys, or other secrets to the repository.

### 3. Configure the application

The default configuration is in `src/main/resources/application.properties`. For local or deployment-specific values, prefer an external configuration source, environment variables, or a profile-specific configuration file.

At minimum, configure:

- Application and server settings.
- MySQL JDBC URL, username, and password.
- JWT verification material or the configured authentication integration.
- Config Server URL, if used.
- Eureka URL, if used.
- Kafka bootstrap servers and topic settings, if used.

### 4. Run the application

Using the Maven Wrapper on macOS/Linux:

```bash
./mvnw spring-boot:run
```

Using the Maven Wrapper on Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Or package and run the generated JAR:

```bash
./mvnw clean package
java -jar target/booking-and-review-service-pfe-0.0.1-SNAPSHOT.jar
```

## Configuration

Configuration is intentionally environment-dependent. Keep secrets outside source control and provide them through your deployment platform or a secure configuration service.

The application is configured to optionally import a Spring Cloud Config Server. This allows the same artifact to run across development, test, and production environments without changing application code.

> **Security reminder:** Never publish real database passwords, JWT private keys, access tokens, or production configuration in commits, issues, or README files.

## Database migrations

Flyway applies versioned migrations from:

```text
src/main/resources/db/migration
```

The current migration history includes:

- `V1__create_reservation_and_review_tables.sql`
- `V2__rename_tables_and_add_created_at.sql`
- `V3__update_reservation_status_default.sql`

Migrations are applied automatically when the application starts and the database connection is correctly configured. New schema changes should be added as a new versioned migration rather than modifying an already-applied migration.

## API documentation

When the application is running, OpenAPI/Swagger UI is available through the Springdoc integration. The exact URL can depend on the server context path and deployment configuration; the conventional local URL is:

```text
http://localhost:8080/swagger-ui.html
```

The generated OpenAPI specification is typically available at:

```text
http://localhost:8080/v3/api-docs
```

## Testing

Run the test suite with:

```bash
./mvnw test
```

For a complete verification including compilation and packaging:

```bash
./mvnw clean verify
```

## Build and packaging

Create a production-ready executable JAR with:

```bash
./mvnw clean package
```

The artifact is generated in the `target/` directory. Use environment-specific configuration at runtime rather than hard-coding deployment settings into the application.

## Contributing

Contributions are welcome. A typical workflow is:

1. Create a feature branch from `master`.
2. Make focused changes with clear commit messages.
3. Add or update tests for behavior changes.
4. Run `./mvnw clean verify`.
5. Open a pull request with context, testing details, and any configuration changes.

Please avoid committing generated files, credentials, local IDE settings, or environment-specific secrets.

## License

No license file is currently declared in this repository. Until a license is added, all rights are reserved by the repository owner. If you intend to reuse or distribute this project, please contact the owner first.

---

<div align="center">
  Built with Java and Spring Boot · Maintained by <a href="https://github.com/DalalYouness">DalalYouness</a>
</div>
