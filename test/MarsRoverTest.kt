import com.wallapop.MarsRover
import com.wallapop.Position
import org.junit.Test;

import org.amshove.kluent.`should be equal to`

class MarsRoverTest {

    @Test
    fun `Mars rover should initialize at position 0,0`() {
        val rover = MarsRover()
        rover.getPosition() `should be equal to` Position(0,0)
    }

}
