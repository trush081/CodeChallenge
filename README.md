# Code Challenge #
#### CANNOT BE RAN LOCALLY WITHOUT FIRESTORE ACCESS!!! ####
Contact Trush081@gmail.com for any questions, issues, or explanations of the design.

### Details of Challenge ###
1. Create a REST service with a single endpoint that accepts a json message with two fields.."id" and "message". (example: { "id": "123", "message": "hello world" })
2. The endpoint should return a json document with a single field "count" that contains the total number of words contained in all the messages received to that point.
   For example, if the first message contains 3 words it would respond with count = 3. If the next message contains 5 words it would respond with count = 8.
3. The service should ignore messages with duplicate ids. (i.e. ids that have already been processed)
4. Use the programming language of your choice.
5. Upload all code to a public GitHub repo with a readme that explains how to build and run the project

### Solution ###
#### As a little extra, I created this API using GCP and some of their technologies. ####
* Firebase document database (This was chosen due to familiarity)
* Google Cloud Run, an auto-scaling service (This was chosen for the mere factor that it has cold starts which is much nicer than setting up a costly compute engine)
* Swagger docs for a useful ui component https://code-hphjt6sita-uc.a.run.app/swagger-ui/index.html#/
* Jib a tool that helps to create containers directly from the command line with little to no effort (Note: I attempted to set up a pipeline using cloud build which you can see in the ugly commit history. An issue with GCP not wanting to run my application using Java 17 prevented me from doing this.)

### Cold Starts ###
Be aware that all initial calls to the API will have a drastic latency. This solution is only being used because it is nearly free.

### Example Request and Postman Collection ###
#### Curl ####
curl --location --request POST 'https://code-hphjt6sita-uc.a.run.app/user' \
--header 'Content-Type: application/json' \
--data-raw '{
"id": "1235",
"message": "hello world"
}'
#### Postman Collection ####
https://www.getpostman.com/collections/dc34ead09e24a17859dc
