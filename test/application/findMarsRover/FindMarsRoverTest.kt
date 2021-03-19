package application.findMarsRover

import com.wallapop.application.findMarsRover.FindMarsRover
import com.wallapop.domain.MarsRover
import com.wallapop.domain.MarsRoverNotFoundException
import com.wallapop.domain.MarsRoverRepository
import domain.MarsRoverStub
import io.mockk.every
import io.mockk.mockk
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.invoking
import org.amshove.kluent.shouldThrow
import org.junit.Test
import org.junit.jupiter.api.TestInstance
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FindMarsRoverTest {
    private val repository = mockk<MarsRoverRepository>()
    private val service: FindMarsRover = FindMarsRover(repository)

    @Test
    fun `should get the mars rovers`() {
        val rover: MarsRover = MarsRoverStub.random()
        every { repository.get() } returns Optional.of(rover)

        val roverExpected: MarsRover = service.execute()

        roverExpected `should be equal to` rover
    }

    @Test
    fun `should throw mars rover not found if does not exist`() {
        every { repository.get() } returns Optional.empty()

        invoking { service.execute() } shouldThrow MarsRoverNotFoundException::class
    }
}
