# Code Challenge #
Contact Trush081@gmail.com for any questions, issues, or explanations of the design.

### Details of Challenge ###
1. Create a REST service with a single endpoint that accepts a json message with two fields.."id" and "message". (example: { "id": "123", "message": "hello world" })
2. The endpoint should return a json document with a single field "count" that contains the total number of words contained in all the messages received to that point.
   For example, if the first message contains 3 words it would respond with count = 3. If the next message contains 5 words it would respond with count = 8.
3. The service should ignore messages with duplicate ids. (i.e. ids that have already been processed)
4. Use the programming language of your choice.
5. Upload all code to a public GitHub repo with a readme that explains how to build and run the project

### Solution ###
##### My solution involves using Spring Boot to help create a REST service and clean and readable code. Not to mention how powerful using Spring technologies and dependencies are. Some tools I've used here: #####
* In memory Database using H2 and JPARepository (make sure to check out my other branch)
* Swagger docs for a useful ui component http://localhost:8080/swagger-ui/index.html#/
* Gradle has a superior build speed that I love taking advantage of
* Unit testing using Mockito
* Java 17

### Setup ###
1. Clone repository onto local machine (I recommend using an IDE such as IntelliJ)
2. This project is using Java 17, so make sure to have a recent JDK installed
3. It can be helpful to have the latest version of [gradle](https://gradle.org/install/) installed (if not running from an IDE) 
4. From project directory, run `./gradlew build` to download dependencies and run tests
5. Lastly, run `./gradlew bootrun` to start up the application

### Example Request and Postman Collection ###
#### Curl ####
curl --location --request POST 'http://localhost:8080/user' \
--header 'Content-Type: application/json' \
--data-raw '{
"id": "123",
"message": "hello world"
}'
#### Postman Collection ####
https://www.getpostman.com/collections/dc34ead09e24a17859dc
