package infrastructure.repository.inmemory

import com.wallapop.domain.MarsRover
import com.wallapop.domain.position.Rotate
import com.wallapop.infrastructure.repository.inmemory.InMemoryMarsRoverRepository
import domain.MarsRoverStub
import org.amshove.kluent.`should be equal to`
import org.junit.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InMemoryMarsRoverRepositoryTest {
    private val repository: InMemoryMarsRoverRepository = InMemoryMarsRoverRepository()

    @Test
    fun `should save a mars rover`() {
        val marsRover: MarsRover = MarsRoverStub.random()
        repository.create(marsRover)

        repository.get().get() `should be equal to` marsRover
    }

    @Test
    fun `should update mars rover`() {
        val marsRover: MarsRover = MarsRoverStub.random()
        repository.create(marsRover)

        marsRover.rotateTo(Rotate.RIGHT)
        repository.update(marsRover)

        repository.get().get() `should be equal to` marsRover
    }

    @Test
    fun `should return a mars rover if exists`() {
        val marsRover: MarsRover = MarsRoverStub.random()
        repository.create(marsRover)

        repository.get().get() `should be equal to` marsRover
    }

    @Test
    fun `should return a empty mars rover if does not exist`() {
        repository.get().isPresent `should be equal to` false
    }

    @Test
    fun `should delete a mars rover`() {
        val marsRover: MarsRover = MarsRoverStub.random()
        repository.create(marsRover)

        repository.delete()

        repository.get().isPresent `should be equal to` false
    }

}
