import com.wallapop.*
import org.junit.Test;

import org.amshove.kluent.`should be equal to`

class MarsRoverTest {

    @Test
    fun `Mars rover should initialize at position 0,0 and north`() {
        val rover = MarsRover()
        rover.getPosition() `should be equal to` Position(Point(0, 0))
    }

    @Test
    fun `Mars rover should move forward` () {
        val rover = MarsRover()

        rover.moveTo(Movement.FORWARD)

        rover.getPosition() `should be equal to` Position(Point(1, 0))
    }

    @Test
    fun `Mars rover should move to backward` () {
        val rover = MarsRover()

        rover.moveTo(Movement.BACKWARD)

        rover.getPosition() `should be equal to` Position(Point(0, 1))
    }
}
