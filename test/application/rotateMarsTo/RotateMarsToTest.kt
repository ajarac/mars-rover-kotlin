package application.rotateMarsTo

import com.wallapop.application.rotateMarsTo.RotateMarsTo
import com.wallapop.application.rotateMarsTo.RotateMarsToCommand
import com.wallapop.domain.MarsRover
import com.wallapop.domain.MarsRoverNotFoundException
import com.wallapop.domain.MarsRoverRepository

import com.wallapop.domain.position.Rotate
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
class RotateMarsToTest {
    private val repository = mockk<MarsRoverRepository>()
    private val service: RotateMarsTo = RotateMarsTo(repository)

    @Test
    fun `should rotate mars to left and save`() {
        val mars: MarsRover = MarsRoverStub.random()
        val rotateMarsToCommand = RotateMarsToCommand(Rotate.LEFT)
        every { repository.get() } returns Optional.of(mars)
        every { repository.update(any()) } returns Unit
        val marsExpected: MarsRover = mars.copy()

        service.execute(rotateMarsToCommand)

        marsExpected.rotateTo(Rotate.LEFT)
        verify(exactly = 1) { repository.update(marsRover = marsExpected) }
    }

    @Test()
    fun `if there is not a mars rover, should tell us it`() {
        val rotateMarsToCommand = RotateMarsToCommand(Rotate.LEFT)
        every { repository.get() } returns Optional.empty()
        every { repository.update(any()) } returns Unit

        invoking { service.execute(rotateMarsToCommand) } shouldThrow MarsRoverNotFoundException::class
    }

}
