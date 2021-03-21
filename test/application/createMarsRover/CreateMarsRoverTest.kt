package application.createMarsRover

import com.wallapop.application.createMarsRover.CreateMarsRover
import com.wallapop.application.createMarsRover.CreateMarsRoverCommand
import com.wallapop.domain.MarsRover
import com.wallapop.domain.MarsRoverRepository
import com.wallapop.domain.world.World
import com.wallapop.domain.point.Point
import com.wallapop.domain.position.Direction
import com.wallapop.domain.position.Position
import domain.point.PointStub
import domain.position.DirectionStub
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import org.junit.jupiter.api.TestInstance
import shared.FakerSingleton

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CreateMarsRoverTest {
    private val repository = mockk<MarsRoverRepository>()
    private val service: CreateMarsRover = CreateMarsRover(repository)

    @Test
    fun `should create mars rover to save in the repository`() {
        val pointRover: Point = PointStub.random()
        val directionRover: Direction = DirectionStub.random()
        val heightPlanet: Int = FakerSingleton.randomInt(10, 100)
        val widthPlanet: Int = FakerSingleton.randomInt(10, 100)
        val createMarsRoverCommand =  CreateMarsRoverCommand(point = pointRover, direction = directionRover, heightPlanet = heightPlanet, widthPlanet = widthPlanet, obstacles = emptyList())
        every { repository.create(any()) } returns Unit

        service.execute(createMarsRoverCommand)

        val position = Position(point = pointRover, direction = directionRover)
        val world = World(height = heightPlanet, width = widthPlanet, obstacles = emptyList())
        verify(exactly = 1) { repository.create(MarsRover(position = position, world = world)) }
    }
}
