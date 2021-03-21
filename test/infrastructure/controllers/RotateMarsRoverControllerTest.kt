package infrastructure.controllers

import com.google.gson.Gson
import com.wallapop.domain.MarsRover
import com.wallapop.domain.point.Point
import com.wallapop.infrastructure.controllers.CreateMarsRoverDTO
import com.wallapop.infrastructure.controllers.RotateMarsToDTO
import com.wallapop.main
import domain.MarsRoverStub
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.amshove.kluent.`should be equal to`
import org.junit.Test

class RotateMarsRoverControllerTest {
    @Test
    fun `should move mars in a Put request`(): Unit = withTestApplication (Application::main) {
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

        val rotateMarsToDTO = RotateMarsToDTO("LEFT")

        with(handleRequest (HttpMethod.Put, "/marsRover/rotate"){
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            setBody(Gson().toJson(rotateMarsToDTO))
        }) {
            response.status() `should be equal to` HttpStatusCode.Accepted
            response.content `should be equal to` null
        }
    }

    @Test
    fun `should throw mars rover not found if does not exists`(): Unit = withTestApplication(Application::main) {
        val rotateMarsToDTO = RotateMarsToDTO("LEFT")

        with(handleRequest(HttpMethod.Put, "/marsRover/rotate") {
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            setBody(Gson().toJson(rotateMarsToDTO))
        }) {
            response.status() `should be equal to` HttpStatusCode.NotFound
            response.content `should be equal to` null
        }
    }
}
