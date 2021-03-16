import com.wallapop.MarsRover
import com.wallapop.Movements
import com.wallapop.Position
import org.junit.Test;

import org.amshove.kluent.`should be equal to`

class MarsRoverTest {

    @Test
    fun `Mars rover should initialize at position 0,0`() {
        val rover = MarsRover()
        rover.getPosition() `should be equal to` Position(0,0)
    }

    @Test
    fun `Mars rover should move to forward` () {
        val rover = MarsRover()

        rover.moveTo(Movements.FORWARD)

        rover.getPosition() `should be equal to` Position(1, 0)
    }

    @Test
    fun `Mars rover should move to backward` () {
        val rover = MarsRover()

        rover.moveTo(Movements.BACKWARD)

        rover.getPosition() `should be equal to` Position(0, 1)
    }

}
