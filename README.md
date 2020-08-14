# Rock Scissor Paper API
_REST API for Rock Scissor Paper game WebApp_

### How to run the project locally?

1. Clone the repository
2. Using the terminal, go the project folder
3. Run `mvn clean install` to compile the project and download the maven dependencies
4. Run `mvn spring-boot:run` to launch the server. It will start a Tomcat server on the default port 8080

**Technologies:**
- [Spring Boot](https://spring.io/projects/spring-boot) 2.3.2 and [Spring Framework](https://spring.io/)
- [Java JDK 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) as programming language and platform
- [JUnit Jupiter](https://junit.org/junit5/docs/current/user-guide/) as testing framework
- [Mockito](https://site.mockito.org/) as mocking framework
- [Maven](https://maven.apache.org/) as dependency and building tool

## Notes
- The main goal of the project is to implement a clean code, arquitecture and design, using patterns and easy testeable code. The same result could be fulfilled using a simpler and faster design. However, a balanced between reusability and speed was a requirement.
- The project is not 100% perfect as there are important questions that would need to be implemented in a real/production version, such as exception handling and security layer.
- TDD has been applied, however, not always in a strict mode (test first).

