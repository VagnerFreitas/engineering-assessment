# FoodTruckFinder

FoodTruckFinder is a web application built to evaluate the best food trucks in San Francisco.

## Dependencies

To run this application, you will need to have the following installed:

- Docker
- Java 17
- Maven 3.8.7

## Running the Application

To run the application, simply execute `docker-compose up --build`. The docker-compose file will instantiate a new Postgres image and populate it with the necessary data. You can then access the API documentation at http://localhost:8080/swagger-ui/index.html.

Note that while it is not necessary to be authenticated search for food trucks or to create a new user account, but you must be authenticated to rate food trucks.

## Testing

To test this application you will need docker running on your computer because this application uses [TestContainers](https://www.testcontainers.org/) to instantiate a postgre container for integration tests.
Command to run tests: `mvn test`

## Future Improvements

I have several improvements planned for FoodTruckFinder:

- Adding more logs to improve observability
- Add build pipeline
- Allowing food truck owners to register and creating a corresponding user role
- Improving pagination on food truck search results
- Add another endpoint to find food trucks nearby user location
