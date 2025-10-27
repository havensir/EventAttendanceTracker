# 🧠 JoinUp – Project Setup & Run Guide

This document explains how to install, configure, and run the **JoinUp Event Attendance Tracker** application locally.  
It includes all system requirements, environment setup, running instructions, and testing procedures.

---

## ⚙️ System Requirements

Before you begin, ensure your system meets the following:

| Requirement | Version / Notes |
|--------------|----------------|
| **Java JDK** | 17 or higher |
| **Apache Maven** | 3.8+ (CLI installed and added to PATH) |
| **Git** | For cloning and version control |
| **IDE (optional)** | IntelliJ IDEA, VS Code, or Eclipse |
| **Browser** | Any modern browser (Chrome, Edge, Firefox, Safari) |

---

## 🧩 Project Structure Overview

```
EventAttendanceTracker/
│
├── src/
│   ├── main/java/com/joinup/...       → Source code (controllers, services, entities)
│   ├── test/java/com/joinup/...       → Unit and WebMvc tests
│   └── resources/                     → Static resources, templates, or configs
│
├── pom.xml                            → Maven dependencies and build configuration
├── mock-fetch.html / mock-tester.html → Frontend API testing utility
└── README.md                          → General project overview
```

---

## 🚀 Installation & Setup

1. **Clone the repository**

   ```bash
   git clone https://github.com/<your-org>/EventAttendanceTracker.git
   cd EventAttendanceTracker
   ```

2. **Verify Maven and Java**

   ```bash
   mvn -v
   java -version
   ```

   Both commands should show Java 17+ and Maven 3.8+.

3. **Build the project**

   ```bash
   mvn clean package
   ```

4. **Run the application**

   ```bash
   mvn spring-boot:run
   ```

   The API will start at **http://localhost:8080**.

---

## 🧠 Available Endpoints

| Endpoint | Method | Description |
|-----------|--------|-------------|
| `/api/events` | GET / POST | Manage event records |
| `/api/attendees` | GET / POST | Manage attendee records |
| `/api/checkins` | GET / POST | Manage event check-ins |
| `/seed` | GET | Auto-seeds mock data for testing |

---

## 🧪 Running Tests

1. **Run all tests**
   ```bash
   mvn test
   ```

2. **Generate test report**
   ```bash
   mvn site
   open target/site/surefire-report.html
   ```

   The report summarizes all JUnit and WebMvc test results.

---

## 🧾 Notes

- The included **mock-tester.html** tool allows visual verification of API routes.
- Ensure port **8080** is not used by another application.
- Test data seeds automatically on startup for convenience.

---

**Maintainer:** Silas Curry  
**Last Updated:** October 2025
