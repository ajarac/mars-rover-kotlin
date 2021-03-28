# MY SOLUTION

Hey guys! this is my Mars Rover Test in Kotlin

## Libraries used on the project:
- Ktor as server framework
- JUnit5 for testing
- Kodein for dependency injection
- Kluent as assertion tests
- Mockk for mocks
- JavaFaker for creating random data

## Design
I started with the MarsRover Class and then with the World class as dependency of MarsRover.
This approach allow us to have more than 1 Mars Rover in our Mars World, but in this case we can create only 1 Mars Rover with 1 World by application services.

## Improvements
- Obstacles validation inside World and not repeat themselves the positions
- Better integration of testing with edger cases
- Logging

## How to use

In total there are 6 API Requests:

### POST "/marsRover"
To Create a Mars Rover with the world

Request:
```javascript 
{
    "point": {
        "x": number;
        "y": number;
    },
    "direction": "NORTH" || "EAST" || "SOUTH" || "WEST",
    "heightPlanet": number;
    "widthPlanet": number;
    "obstacles": {
        "x": number;
        "y": number;
    }[]
}
```

Success Response:
- 201 Created, No Content


### GET "/marsRover"
To receive the Mars rover with the world
Response:
```javascript
{
    "position": {
        "point": {
            "x": number,
            "y": number
        },
        "direction": "NORTH" || "EAST" || "SOUTH" || "WEST"
    },
    "world": {
        "height": number,
        "width": number,
        "obstacles": 
            {
                "point": {
                    "x": number,
                    "y": number
                }
            }[]
    }
}
```

### PUT "/marsRover/move"
To move Mars Rover to forward or backward

Request:
```javascript
{
    "movement": "FORWARD" || "BACKWARD"
}
```

Success Response:
- 201 Created, No Content

### PUT "/marsRover/rotate"
To rotate mars Rover to left or right

Request:
```javascript
{
    "rotate": "LEFT" || "RIGHT"
}
```

Success Response:
- 201 Created, No Content

### DELETE "/marsRover"
to delete Mars Rover if there is one.

### Extra
There is an extra API Request to check the api if is running or not:
- GET "/check"
