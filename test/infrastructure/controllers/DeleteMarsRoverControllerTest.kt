package infrastructure.controllers

import com.google.gson.Gson
import com.wallapop.domain.MarsRover
import com.wallapop.domain.point.Point
import com.wallapop.infrastructure.controllers.CreateMarsRoverDTO
import com.wallapop.main
import domain.MarsRoverStub
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.amshove.kluent.`should be equal to`
import org.junit.Test

class DeleteMarsRoverControllerTest {
    @Test
    fun `should delete mars rover if exists`(): Unit = withTestApplication(Application::main) {
        val marsRover: MarsRover = MarsRoverStub.random()
        val createMarsRoverDTO = CreateMarsRoverDTO(
            point = marsRover.getPosition().point,
            direction = marsRover.getPosition().direction.toString(),
            heightPlanet = marsRover.getPlanet().height,
            widthPlanet = marsRover.getPlanet().width,
            obstacles = marsRover.getPlanet().obstacles.map { it.point } as ArrayList<Point>)
        handleRequest(HttpMethod.Post, "/marsRover") {
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            setBody(Gson().toJson(createMarsRoverDTO))
        }

        with(handleRequest(HttpMethod.Delete, "/marsRover")) {
            response.status() `should be equal to` HttpStatusCode.OK
            response.content `should be equal to` null
        }

        with(handleRequest(HttpMethod.Get, "/marsRover") {
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
        }) {
            response.status() `should be equal to` HttpStatusCode.NotFound
            response.content `should be equal to` null
        }
    }

    @Test
    fun `should do nothing if mars rover does not exist`(): Unit = withTestApplication(Application::main) {
        with(handleRequest(HttpMethod.Delete, "/marsRover")) {
            response.status() `should be equal to` HttpStatusCode.OK
            response.content `should be equal to` null
        }

        with(handleRequest(HttpMethod.Get, "/marsRover") {
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
        }) {
            response.status() `should be equal to` HttpStatusCode.NotFound
            response.content `should be equal to` null
        }
    }
}
