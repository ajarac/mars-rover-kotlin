import com.wallapop.domain.MarsRover
import com.wallapop.domain.planet.Planet
import com.wallapop.domain.position.*
import org.junit.Test;

import org.amshove.kluent.`should be equal to`

class MarsRoverTest {

    @Test
    fun `Mars rover should initialize at position 0,0 and north`() {
        val rover = MarsRover()
        rover.getPosition() `should be equal to` Position(Point(0, 0), Direction.NORTH)
    }

    @Test
    fun `Mars rover should move forward and north` () {
        val rover = MarsRover()

        rover.moveTo(Movement.FORWARD)

        rover.getPosition() `should be equal to` Position(Point(1, 0), Direction.NORTH)
    }

    @Test
    fun `Mars rover should move to backward and north` () {
        val rover = MarsRover()

        rover.moveTo(Movement.BACKWARD)

        rover.getPosition() `should be equal to` Position(Point(9, 0), Direction.NORTH)
    }

    @Test
    fun `Mars rover should rotate to left, north to west`() {
        val rover = MarsRover()

        rover.rotateTo(Rotate.LEFT)

        rover.getPosition() `should be equal to` Position(Point(0, 0), Direction.WEST)
    }

    @Test
    fun `Mars rover should rotate to right, north to east`() {
        val rover = MarsRover()

        rover.rotateTo(Rotate.RIGHT)

        rover.getPosition() `should be equal to` Position(Point(0, 0), Direction.EAST)
    }

    @Test
    fun `Mars rover should rotate to right, south to west`() {
        val rover = MarsRover(position = Position(direction = Direction.SOUTH))

        rover.rotateTo(Rotate.RIGHT)

        rover.getPosition() `should be equal to` Position(Point(0, 0), Direction.WEST)
    }

    @Test
    fun `Mars rover should rotate to right and then move to forward`() {
        val rover = MarsRover()

        rover.rotateTo(Rotate.RIGHT)
        rover.moveTo(Movement.FORWARD)

        rover.getPosition() `should be equal to` Position(Point(0, 9), Direction.EAST)
    }

    @Test
    fun `Mars rover should rotate to left and then move to backward`() {
        val rover = MarsRover()

        rover.rotateTo(Rotate.LEFT)
        rover.moveTo(Movement.BACKWARD)

        rover.getPosition() `should be equal to` Position(Point(0, 9), Direction.WEST)
    }

    @Test
    fun `Mars rover should initialize at mars with 10 x 10 size`() {
        val rover = MarsRover()

        rover.getPlanet() `should be equal to` Planet(10, 10)
    }

    @Test
    fun `Mars rover when arrive at the limit, should be on the other side`() {
        val rover = MarsRover(position = Position(point = Point(9, 9)))

        rover.moveTo(Movement.FORWARD)

        rover.getPosition() `should be equal to` Position(point = Point(0, 9))
    }

    @Test
    fun `Mars rover when arrive at the back limit and move backward, should be at the other side`() {
        val rover = MarsRover(position = Position(point = Point(0, 0)))

        rover.moveTo(Movement.BACKWARD)

        rover.getPosition() `should be equal to` Position(point = Point(9, 0))
    }
}
