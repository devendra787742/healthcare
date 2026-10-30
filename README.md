# 🏥 E-HealthCare | 3D Digital Clinical Portal

> **An Intelligent Full-Stack Healthcare Management & Teleconsultation Platform with Interactive 3D Anatomy Visualizations and Role-Based Dashboards.**

[![React](https://img.shields.io/badge/React-18.2.0-61DAFB?logo=react&logoColor=black)](https://reactjs.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7+-6DB33F?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Three.js](https://img.shields.io/badge/Three.js-WebGL%203D-000000?logo=threedotjs&logoColor=white)](https://threejs.org/)
[![Bootstrap](https://img.shields.io/badge/Bootstrap-5.2-7952B3?logo=bootstrap&logoColor=white)](https://getbootstrap.com/)
[![JWT](https://img.shields.io/badge/Security-JWT%20Auth-000000?logo=jsonwebtokens&logoColor=white)](https://jwt.io/)
[![Razorpay](https://img.shields.io/badge/Payments-Razorpay-0C2340?logo=razorpay&logoColor=white)](https://razorpay.com/)

---

## 📌 Table of Contents
- [Project Overview](#-project-overview)
- [Key Features](#-key-features)
- [System Architecture](#-system-architecture)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Database Configuration](#-database-configuration)
- [Installation & Setup](#-installation--setup)
  - [1. Database Setup](#1-database-setup)
  - [2. Backend Setup (Spring Boot)](#2-backend-setup-spring-boot)
  - [3. Frontend Setup (React.js)](#3-frontend-setup-reactjs)
- [Role-Based Access & Dashboards](#-role-based-access--dashboards)
- [REST API Endpoints](#-rest-api-endpoints)
- [Security & Encryption](#-security--encryption)
- [Authors & Acknowledgments](#-authors--acknowledgments)

---

## 🌟 Project Overview

**E-HealthCare 3D Digital Portal** is an end-to-end digital health ecosystem engineered to eliminate clinical barriers, streamline patient appointments, and facilitate secure teleconsultation. 

The application integrates hardware-accelerated **3D spatial WebGL visualizations**, responsive **glassmorphic design**, real-time **symptom-based department triage**, and role-based portals for **Patients**, **Doctors**, and **Hospital Administrators**.

---

## 🚀 Key Features

### 🧬 Interactive 3D Biomedical Visualizer
* **3D Rotating DNA Double Helix:** Dual-helix strand with glowing nucleotide base pairs and dynamic depth projection.
* **Molecular Neural Lattice:** 3D connected atomic nodes and synapse bonds responding to physics and boundaries.
* **Cardio Nebula:** Dynamic cardiogram pulse wave visualizer with live heartbeat simulation.
* **Interactive 3D Viewport:** Drag and move your cursor to orbit and tilt the camera in 3D real-time.

### 🎴 3D Perspective Tilt & Modern UI
* **Dynamic Tilt Tracking:** Medical cards dynamically track mouse position with `perspective(1000px) rotateX(...) rotateY(...)` physics.
* **Specular Reflection Glare:** Real-time lighting glare overlay following cursor angle.
* **Glassmorphic Aesthetic:** Frosted glass navbar (`backdrop-filter: blur(16px)`), glowing ambient neons, and dark-mode health theme.

### 🧭 Smart Symptom & Department Navigator
* Interactive symptom selector (*Chest Pain, Migraines, Joint/Spine Pain, Child Fever, Skin Rash, etc.*).
* Instant triage recommendation, urgency classification badge, matching specialist doctor, and direct appointment booking CTA.

### 🩺 Comprehensive Role-Based Portals
* **Patient Portal:** Online appointment scheduling, treatment history timeline, prescription vault, lab reports, and doctor feedback.
* **Doctor Portal:** Manage today's appointments, approve/reject pending bookings, prescribe medications, and record diagnosis notes.
* **Admin Portal:** Manage medical departments, doctor credentials, patient records, and hospital system metrics.

### 💳 Integrated Payments & Notifications
* **Razorpay Payment Gateway:** Secure checkout for doctor fees and diagnostics with instant digital receipts.
* **Email Dispatch Service:** Automated email confirmations for appointments and account registrations via Spring Mail (SMTP).

---

## 🏗️ System Architecture

```text
[ Browser / Client ]
       │
       ▼
[ React 18 SPA (Port 3000) ]
   ├── 3D Canvas / WebGL Engine (Three.js & Hardware Acceleration)
   ├── TiltCard3D Mouse Perspective Engine
   ├── React Router v6 & Axios HTTP Client
   └── Bootstrap 5 & Reactstrap UI
       │  (REST API calls via JWT Token)
       ▼
[ Spring Boot Backend (Port 8080) ]
   ├── Spring Security + JWT Authentication Filter
   ├── REST Controllers (Admin, Doctor, Patient, Auth)
   ├── Business Service Layer
   └── Spring Data JPA / Hibernate ORM
       │
       ▼
[ MySQL Database (Port 3306) ]
   └── Tables: admins, doctors, patients, departments, appointments, feedback, treatments, lab_tests
```

---

## 🛠️ Tech Stack

### Frontend:
* **Core:** React.js 18.2.0, React DOM
* **Routing:** React Router DOM v6.4
* **3D & Graphics:** Three.js, HTML5 Canvas 2D/WebGL Context, CSS 3D Transforms
* **Styling & UI:** Bootstrap 5.2.1, Reactstrap, Bootstrap Icons, Google Fonts (`Outfit`, `Plus Jakarta Sans`)
* **State & Networking:** Axios, React Toastify, React Fast Marquee

### Backend:
* **Framework:** Spring Boot 2.7+ (Java 8 / Java 11 / Java 17)
* **Security:** Spring Security, JWT (JSON Web Tokens)
* **Data Access:** Spring Data JPA, Hibernate ORM
* **Documentation:** SpringDoc OpenAPI / Swagger UI (`/swagger-ui/index.html`)
* **Email Service:** Spring Boot Starter Mail (SMTP)
* **Build Tool:** Apache Maven

### Database & Storage:
* **Database:** MySQL 8.0+
* **File Uploads:** Local Multipart image storage (`/images`)

---

## 📂 Project Structure

```text
E-HealthCare/
├── BackEnd_Final/                       # Spring Boot REST API
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/app/
│   │   │   │   ├── controller/          # REST API Controllers (Admin, Doctor, Patient, User)
│   │   │   │   ├── dto/                 # Data Transfer Objects & Auth Payloads
│   │   │   │   ├── entity/              # JPA Database Entities
│   │   │   │   ├── repository/          # Spring Data JPA Repositories
│   │   │   │   ├── service/             # Business Logic & Implementations
│   │   │   │   └── security/            # JWT Filters & Security Configurations
│   │   │   └── resources/
│   │   │       ├── application.properties
│   │   │       └── static/
│   ├── pom.xml                          # Maven Dependencies
│   └── mvnw / mvnw.cmd
│
├── FrontEnd_Final/                      # React 18 Single Page Application
│   ├── public/
│   │   ├── index.html                   # HTML template with Three.js CDN & Fonts
│   │   └── manifest.json
│   ├── src/
│   │   ├── Components/
│   │   │   ├── FrontPageComponents/     # Landing page & 3D Interactive Visualizers
│   │   │   │   ├── Medical3DScene.js    # 3D DNA, Molecule & Heartbeat Canvas
│   │   │   │   ├── TiltCard3D.js        # Reusable 3D Mouse Perspective Engine
│   │   │   │   ├── Header.js            # Glassmorphic Sticky Navigation
│   │   │   │   ├── Middle.js            # 3D Hero, Highlights & Features
│   │   │   │   ├── DepartmentSection.js # 3D Specialty Department Cards
│   │   │   │   ├── SymptomNavigator.js  # Smart Interactive Symptom Triage
│   │   │   │   ├── DoctorsReview.js     # Filterable Doctor Carousel & Grid
│   │   │   │   ├── ImpactStats.js       # Live Milestones Counter
│   │   │   │   ├── About.js             # Mission, Values & FAQ
│   │   │   │   └── Footer.js            # 4-Column Modern Tech Footer
│   │   │   ├── Layouts/
│   │   │   │   └── LoginPage.js         # Glassmorphic 3D Login Card
│   │   │   ├── Patient/                 # Patient Dashboard & Booking Views
│   │   │   ├── Doctor/                  # Doctor Appointment & Treatment Views
│   │   │   └── Admin/                   # Hospital Management Views
│   │   ├── Services/                    # Axios auth services & token handlers
│   │   ├── App.js                       # Top-level Routes & ToastContainer
│   │   ├── index.js                     # React DOM Root
│   │   └── boot-api.js                  # Backend Base URL Configuration
│   └── package.json
│
└── Database_Final.sql                   # Schema and Initial Dummy Data
```

---

## 🗄️ Database Configuration

Open `E-HealthCare/BackEnd_Final/src/main/resources/application.properties` and verify your MySQL connection:

```properties
# Server Configuration
server.port=8080

# MySQL Database Credentials
spring.datasource.url=jdbc:mysql://localhost:3306/project2?useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=your_mysql_password

# JPA / Hibernate
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

# JWT Secret & Expiration (24 Hours)
SECRET_KEY=mySecretKey1234
EXP_TIMEOUT=86400000

# Swagger Documentation
springdoc.swagger-ui.path=/
springdoc.api-docs.path=/api-docs
```

---

## ⚙️ Installation & Setup

### 1. Database Setup
1. Ensure MySQL Server is running on port `3306`.
2. Open your MySQL client (MySQL Workbench or CLI) and create the database:
   ```sql
   CREATE DATABASE project2;
   USE project2;
   ```
3. Import the database schema and sample data:
   ```bash
   mysql -u root -p project2 < "E-HealthCare/Database_Final.sql"
   ```

---

### 2. Backend Setup (Spring Boot)
1. Open a terminal and navigate to the backend directory:
   ```bash
   cd "E-HealthCare/BackEnd_Final"
   ```
2. Build the project using Maven:
   ```bash
   ./mvnw clean install
   ```
   *(On Windows Command Prompt or PowerShell: `mvnw.cmd clean install`)*
3. Run the Spring Boot server:
   ```bash
   ./mvnw spring-boot:run
   ```
4. The backend server will start at:
   👉 **`http://localhost:8080`**  
   API Documentation & Swagger UI available at:  
   👉 **`http://localhost:8080/`**

---

### 3. Frontend Setup (React.js)
1. Open a new terminal and navigate to the frontend directory:
   ```bash
   cd "E-HealthCare/FrontEnd_Final"
   ```
2. Install dependencies (if not already installed):
   ```bash
   npm install
   ```
3. Start the React development server:
   ```bash
   npm start
   ```
4. The frontend will launch in your browser at:  
   👉 **`http://localhost:3000`**

---

## 👥 Role-Based Access & Dashboards

| Role | Access URL | Capabilities |
| :--- | :--- | :--- |
| **Public / Visitor** | `/` | Explore 3D visualizers, check symptoms, review doctors, view specialties. |
| **Patient** | `/patient/*` | Book appointments, view treatment history, download prescriptions, pay doctor fees. |
| **Doctor** | `/doctor/*` | Inspect daily appointment queues, update patient treatment details, submit diagnosis. |
| **Admin** | `/admin/*` | Add/remove departments, register doctors, oversee hospital operations. |

---

## 📡 REST API Endpoints (Highlights)

### 🔐 Authentication
* `POST /authenticate` - User sign-in (validates credentials and returns JWT bearer token + role).
* `POST /register` - Register new patient with image upload.

### 🏢 Administrator (`/admin/*`)
* `GET /admin/departments` - Fetch all clinical departments.
* `POST /admin/department` - Create new medical department.
* `DELETE /admin/department/{id}` - Delete department.
* `GET /admin/doctors` - Fetch all registered doctors.
* `POST /admin/doctor` - Register new doctor with profile.

### 🩺 Doctor (`/doctor/*`)
* `GET /doctor/today/{id}` - Retrieve current day's appointments.
* `GET /doctor/pending/{id}` - Retrieve pending booking requests.
* `POST /doctor/treatment` - Record new treatment session and prescription.

### 🧑‍⚕️ Patient (`/patient/*`)
* `GET /patient/appointments/{id}` - Fetch patient appointment history.
* `POST /patient/appointment` - Book doctor appointment slot.
* `GET /patient/treatments/{id}` - Access electronic health records.
* `POST /patient/feedback` - Submit doctor rating & testimonial.

---

## 🔒 Security & Encryption

* **Stateless JWT Security:** Authentication headers (`Authorization: Bearer <TOKEN>`) protect all private endpoints.
* **CORS Safe Policy:** Configured to allow verified origins while rejecting unauthenticated cross-domain injections.
* **Role Guards:** React `ProtectedRoute` components prevent unauthorized client-side URL routing.
* **Audit & Validation:** Validated input sanitization across patient profiles and appointment bookings.

---

## 📄 License & Acknowledgments

* **License:** Distributed under the MIT License.
* **Credits:** Built with passion for modern digital healthcare, combining cutting-edge WebGL graphics with clinical accessibility.
