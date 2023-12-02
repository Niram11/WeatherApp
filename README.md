Weather Application API
Description
The Weather Application API is an advanced Spring Boot application that provides weather condition information. It allows users to retrieve, add, update, and delete weather data as well as location information. This project was created as part of a learning exercise and to demonstrate programming skills in Spring Boot, RESTful APIs, JPA, and unit testing.

Technologies
Spring Boot: For creating the application framework and managing dependencies.
Spring Data JPA: For handling database operations.
PostgreSQL: As the database management system.
JUnit and Mockito: For writing and running unit tests.
MapStruct: For object DTO mapping.
Features
Retrieve weather data and location information.
Add new weather data and locations.
Update existing data.
Delete weather data and location information.
Search for weather data based on location and date range.
How to Run
Requirements
Java JDK 11 or newer
Maven
PostgreSQL
Installation and Execution
Clone the repository:
bash
Copy code
git clone [repository URL]
Navigate to the project folder:
bash
Copy code
cd weather-app
Create a PostgreSQL database according to the configuration in application.yaml.
Run the application:
arduino
Copy code
mvn spring-boot:run
