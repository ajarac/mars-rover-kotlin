package application.moveMarsTo

import com.wallapop.application.moveMarsTo.MoveMarsTo
import com.wallapop.application.moveMarsTo.MoveMarsToCommand
import com.wallapop.domain.MarsRover
import com.wallapop.domain.MarsRoverNotFoundException
import com.wallapop.domain.MarsRoverRepository
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
        val mars: MarsRover = MarsRoverStub.random()
        val moveMarsToCommand = MoveMarsToCommand(Movement.FORWARD)
        every { repository.get() } returns Optional.of(mars)
        every { repository.update(any()) } returns Unit
        val marsExpected: MarsRover = mars.copy()

        service.execute(moveMarsToCommand)

        marsExpected.moveTo(Movement.FORWARD)
        verify(exactly = 1) { repository.update(marsRover = marsExpected) }
    }

    @Test
    fun `if there is not a mars rover, should tell us it`() {
        val moveMarsToCommand = MoveMarsToCommand(Movement.FORWARD)
        every { repository.get() } returns Optional.empty()
        every { repository.update(any()) } returns Unit

        invoking { service.execute(moveMarsToCommand) } shouldThrow MarsRoverNotFoundException::class
    }
}
