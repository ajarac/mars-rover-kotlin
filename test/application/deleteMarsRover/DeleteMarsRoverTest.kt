package application.deleteMarsRover

import com.wallapop.application.deleteMarsRover.DeleteMarsRover
import com.wallapop.domain.MarsRoverRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DeleteMarsRoverTest {
    private val repository = mockk<MarsRoverRepository>()
    private val service: DeleteMarsRover = DeleteMarsRover(repository)

    @Test
    fun `should delete mars rover`() {
        every { repository.delete() } returns Unit

        service.execute()

        verify(exactly = 1) { repository.delete() }
    }
}
