***Spring Security Project with MySQL Authentication***

This project is a Spring Boot application that implements Spring Security for user authentication and authorization. It includes a backend API for user registration, login, logout, and viewing all users, as well as a frontend demo with registration, login, and user management pages using mysql database.

**Features**

✅ Backend (Spring Boot & Spring Security)
User Registration API (/registration): Saves user data in a MySQL database.
User Login API (/login): Validates credentials and allows access if the user exists.
User Logout API (/logout): Logs out the authenticated user.
View All Users API (/allusers): Displays all registered users (requires authentication).
BCrypt Password Encoding: Ensures secure password storage.


**Frontend (HTML, CSS, JavaScript) - Demo Pages**

Registration Page: Allows users to sign up.
Login Page: Users can log in with their credentials.
View All Users Page: Displays all users after authentication.
Logout Page: Provides an option to log out securely

**Technologies Used**

Spring Boot (Backend Framework)
Spring Security (Authentication & Authorization)
MySQL (Database)
BCrypt Password Encoder (Password Security)
HTML, CSS, JavaScript (Frontend for Demo)

**API Endpoints**

Method	Endpoint	Description	Authentication

POST	/register	Register a new user	❌ No

POST	/login	Authenticate user login	❌ No

GET	/users/all	View all registered users	✅ Yes

POST	/logout	Logout the user	✅ Yes

**Project Structure**

spring-security-project/

│── src/main/java/com/example/

│   ├── config/               # Security configuration files

│   ├── model/                # User model/entity

│   ├── repository/           # Database access layer

│   ├── service/              # Business logic layer

│   ├── controller/           # API endpoints

│   ├── SpringSecurityApplication.java  # Main entry point

│── src/main/resources/

│   ├── application.properties  # Database and security configuration

│── frontend/                 # Demo frontend pages

│   ├── welcome.html            # Registration Page

│   ├── login.html            # Login Page

│   ├── allusers.html            # View All Users Page

│   ├── logout.html           # Logout Page

│── pom.xml    

