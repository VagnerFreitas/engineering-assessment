# FoodTruckFinder

FoodTruckFinder is a web application built to evaluate the best food trucks in San Francisco.

## Running the Application

To run the application, simply execute `docker-compose up --build`. You can then access the API documentation at http://localhost:8080/swagger-ui/index.html.

Note that while it is not necessary to be authenticated to register or search for food trucks, you must be authenticated to log in.

## Future Improvements

I have several improvements planned for FoodTruckFinder:

- Adding unit tests and integration tests
- Adding more logs to improve observability
- Allowing food truck owners to register and creating a corresponding user role
- Improving pagination on food truck search results
