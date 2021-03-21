package infrastructure.repository.inmemory

import com.wallapop.domain.MarsRover
import com.wallapop.domain.MarsRoverNotFoundException
import com.wallapop.domain.position.Rotate
import com.wallapop.infrastructure.repository.inmemory.InMemoryMarsRoverRepository
import domain.MarsRoverStub
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.invoking
import org.amshove.kluent.shouldThrow
import org.junit.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InMemoryMarsRoverRepositoryTest {
    private val repository: InMemoryMarsRoverRepository = InMemoryMarsRoverRepository()

    @Test
    fun `should save a mars rover`() {
        val marsRover: MarsRover = MarsRoverStub.random()
        repository.create(marsRover)

        repository.findOrFail() `should be equal to` marsRover
    }

    @Test
    fun `should update mars rover`() {
        val marsRover: MarsRover = MarsRoverStub.random()
        repository.create(marsRover)

        marsRover.rotateTo(Rotate.RIGHT)
        repository.update(marsRover)

        repository.findOrFail() `should be equal to` marsRover
    }

    @Test
    fun `should return a mars rover if exists`() {
        val marsRover: MarsRover = MarsRoverStub.random()
        repository.create(marsRover)

        repository.findOrFail() `should be equal to` marsRover
    }

    @Test
    fun `should throw mars rover not found exception if does not exist`() {
        invoking {  repository.findOrFail() } shouldThrow MarsRoverNotFoundException::class
    }

    @Test
    fun `should delete a mars rover`() {
        val marsRover: MarsRover = MarsRoverStub.random()
        repository.create(marsRover)

        repository.delete()

        invoking {  repository.findOrFail() } shouldThrow MarsRoverNotFoundException::class
    }

}
