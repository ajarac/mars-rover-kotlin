import com.wallapop.*
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

        rover.getPosition() `should be equal to` Position(Point(0, 1), Direction.NORTH)
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
}
