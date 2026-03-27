MediCall is an online doctor–patient management system that helps patients and doctors manage their medical records efficiently. The platform allows doctors, patients, and hospitals to register online, enabling consultations, prescriptions, and record keeping in a centralized system.

The biggest benefit is that patients can keep track of their medicines and consultations, reducing the chance of forgetting medicine schedules.

Features

✅ Hospital registration
✅ Doctor registration and profile management
✅ Patient registration and profile management
✅ Patients can consult doctors online
✅ Doctors can prescribe medicines and manage consultations
✅ Online management of medical records

Tech Stack
Backend: Java, Spring Boot, Spring Security, Hibernate/JPA
Database: MySQL / PostgreSQL
Authentication:  Spring Security

Installation

Clone the repository
git clone https://github.com/RajTM2316/medicall.git
cd medicall

Configure the database in application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/medicall
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

Build the project
./mvnw clean install

Run the application
./mvnw spring-boot:run

Registration Api
| HTTP Method | Endpoint                   | Request Body              | Description                      | Response                                      |
| ----------- | -------------------------- | ------------------------- | -------------------------------- | --------------------------------------------- |
| POST        | `/auth/register/patients`  | `UserRegisterRequest`     | Register a new patient           | `Map<String, String>` (e.g., success message) |
| POST        | `/auth/register/admins`    | `UserRegisterRequest`     | Register a new admin             | `Map<String, String>`                         |
| POST        | `/auth/register/doctors`   | `UserRegisterRequest`     | Register a new doctor            | `Map<String, String>`                         |
| POST        | `/auth/register/hospitals` | `HospitalRegisterRequest` | Register a new hospital          | `Map<String, String>`                         |
| POST        | `/auth/register/medicines` | `AddMedicineRequest`      | Add a new medicine to the system | `Medicine` (ResponseEntity with HTTP 201)     |

Doctor Api
| HTTP Method | Endpoint               | Request Body          | Description                             | Response                                      |
| ----------- | ---------------------- | --------------------- | --------------------------------------- | --------------------------------------------- |
| PUT         | `/doctor/profile`      | `UpdateDoctorProfile` | Update doctor’s profile information     | `Map<String, String>` (e.g., success message) |
| POST        | `/doctor/prescription` | `PrescriptionRequest` | Create a new prescription for a patient | `Prescription` (created prescription object)  |

Patient Api
| HTTP Method | Endpoint           | Request Body           | Description                          | Response                                      |
| ----------- | ------------------ | ---------------------- | ------------------------------------ | --------------------------------------------- |
| PUT         | `/patient/profile` | `UpdatePatientProfile` | Update patient’s profile information | `Map<String, String>` (e.g., success message) |

Consultation Api
| HTTP Method | Endpoint                | Request Body          | Description                                                | Response                                |
| ----------- | ----------------------- | --------------------- | ---------------------------------------------------------- | --------------------------------------- |
| POST        | `/consult`              | `ConsultationRequest` | Create a new consultation request                          | `Map<String, String>` (success message) |
| GET         | `/consult/{id}`         | None                  | Get consultation details by consultation ID                | `Consultation` object                   |
| DELETE      | `/consult/{id}`         | None                  | Delete a consultation by ID                                | `String` (success message)              |
| GET         | `/consult/patient/{id}` | None                  | Get all consultations for a specific patient by patient ID | `List<Consultation>`                    |
| GET         | `/consult/doctor/{id}`  | None                  | Get all consultations for a specific doctor by doctor ID   | `List<Consultation>`                    |

Prescription Api
| HTTP Method | Endpoint              | Request Body | Description                         | Response              |
| ----------- | --------------------- | ------------ | ----------------------------------- | --------------------- |
| GET         | `/prescriptions/{id}` | None         | Get a prescription by its ID        | `Prescription` object |
| GET         | `/prescriptions`      | None         | Get all prescriptions in the system | `List<Prescription>`  |

Test Login Api
| HTTP Method | Endpoint        | Description                              | Response                    |
| ----------- | --------------- | ---------------------------------------- | --------------------------- |
| GET         | `/test/admin`   | Verify access for admin users            | `"Admin Access granted"`    |
| GET         | `/test/doctor`  | Verify access for doctor users           | `"Doctor Access granted"`   |
| GET         | `/test/patient` | Verify access for patient users          | `"Patient Access granted"`  |
| GET         | `/test/auth`    | Public endpoint accessible without login | `"Public endpoint working"` |

Future Plan / Features

Medicine Reminders & Timers
Send notifications to patients when it’s time to take their medicines.
Option for multiple doses per day and adjustable schedules.
Push notifications, email, or SMS alerts.

Adherence Tracking
Monitor whether patients actually take their medicines on time.
Track missed doses and generate adherence reports for doctors.
Provide analytics for patients to improve compliance.

Enhanced Consultation Management
Allow patients to schedule consultations with doctors.
Add appointment reminders and calendar integration.
Enable doctors to approve/reject consultation requests online.

Advanced Reporting & Analytics
Generate patient adherence charts and medicine usage reports.
Analytics dashboard for doctors and hospitals to track treatment outcomes.

Mobile App / Web Notifications
Cross-platform app for iOS and Android.
Real-time notifications for consultations, prescriptions, and medicine reminders.

Email / SMS Alerts
Send alerts for new prescriptions, consultation updates, and reminders.
Provide automated follow-up notifications for missed doses or appointments.

User Experience Enhancements
Patient and doctor dashboards with intuitive interface.
History logs of prescriptions, consultations, and adherence.


