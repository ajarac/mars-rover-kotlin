# MY SOLUTION

Hey guys! this is my Mars Rover Test in Kotlin

## Libraries used on the project:
- Ktor as server framework
- JUnit5 for testing
- Kodein for dependency injection
- Kluent as assertion tests
- Mockk for create mocks
- JavaFaker for create random data

## Design
I started with the MarsRover Class and then with the World class as dependency of MarsRover.
This approach allow us to have more than 1 Mars Rover in our Mars World, but in this case we can create only 1 Mars Rover with 1 World by application services. 

## Improvements
- Obstacles validation inside World and not repeat themselves the positions
- Better integration of testing with edger cases
- Logging

