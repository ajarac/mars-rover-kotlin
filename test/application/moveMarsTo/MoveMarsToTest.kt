package application.moveMarsTo

import com.wallapop.application.moveMarsTo.MoveMarsTo
import com.wallapop.application.moveMarsTo.MoveMarsToCommand
import com.wallapop.domain.MarsRover
import com.wallapop.domain.MarsRoverNotFoundException
import com.wallapop.domain.MarsRoverRepository
import com.wallapop.domain.world.EncounterAnObstacleException
import com.wallapop.domain.world.Obstacle
import com.wallapop.domain.world.World
import com.wallapop.domain.point.Point
import com.wallapop.domain.position.Movement
import domain.MarsRoverStub
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.invoking
import org.amshove.kluent.shouldThrow
import org.junit.Test
import org.junit.jupiter.api.TestInstance
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MoveMarsToTest {
    private val repository = mockk<MarsRoverRepository>()
    private val service: MoveMarsTo = MoveMarsTo(repository)

    @Test
    fun `should move mars to forward and save`() {
        val rover: MarsRover = MarsRoverStub.random()
        val moveMarsToCommand = MoveMarsToCommand(Movement.FORWARD)
        every { repository.findOrFail() } returns rover
        every { repository.update(any()) } returns Unit
        val marsExpected: MarsRover = rover.copy()

        service.execute(moveMarsToCommand)

        marsExpected.moveTo(Movement.FORWARD)
        verify(exactly = 1) { repository.update(marsRover = marsExpected) }
    }

    @Test
    fun `should throw obstacle if mars encounters an obstacle`() {
        val obstaclesList: ArrayList<Obstacle> = arrayListOf(Obstacle(point = Point(1, 0)))
        val rover = MarsRover(world = World(10, 10, obstacles = obstaclesList))
        val moveMarsToCommand = MoveMarsToCommand(Movement.FORWARD)
        every { repository.findOrFail() } returns rover

        invoking { service.execute(moveMarsToCommand) } shouldThrow EncounterAnObstacleException::class
    }

    @Test
    fun `if there is not a mars rover, should tell us it`() {
        val moveMarsToCommand = MoveMarsToCommand(Movement.FORWARD)
        every { repository.findOrFail() } throws MarsRoverNotFoundException()
        every { repository.update(any()) } returns Unit

        invoking { service.execute(moveMarsToCommand) } shouldThrow MarsRoverNotFoundException::class
    }
}
