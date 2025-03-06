
# NOGs - REST API

This is a REST API developed using Java, Spring Boot, Firebase, and Swagger. It is designed to serve the functionalities of the UAM NGO app. The system supports user management, donations, mobile settings, and donation categories.

## Technologies Used

- **Java**
- **Spring Boot**
- **Firebase**
- **Swagger**

## Features

### 1. **User Creation**
Allows the creation of new users within the system, ensuring that basic information such as name, email, and password are registered.

### 2. **Donations**
Manages donations made to the NGO, allowing for the recording and tracking of user contributions. Donations can be associated with specific categories and described as needed.

### 3. **Mobile Settings**
Provides the ability to update the mobile app's settings, such as notifications and theme preferences, enabling users to personalize their experience.

### 4. **Donation Categories**
Defines and provides a list of donation categories, helping to organize and display the contributions made by users.

## How to Run the Project

### 1. **Prerequisites**
- Java 11 or higher
- Maven
- Firebase (Access credentials configured in the Firebase Console)

### 2. **Firebase Setup**
- Create a project in the [Firebase Console](https://console.firebase.google.com/).
- Generate the credentials (the `google-services.json` file) and add it to the `src/main/resources/` folder of the project.

### 3. **Running the Project**
Run the project using the following command:
```bash
mvn spring-boot:run
```

## API Documentation - Swagger

The interactive API documentation can be accessed via Swagger at the following endpoint:

- **URL:** [/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Contributing

Feel free to contribute to the project by opening issues or submitting pull requests.

## License

This project is licensed under the [MIT License](LICENSE).
