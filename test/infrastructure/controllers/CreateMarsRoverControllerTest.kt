package infrastructure.controllers

import com.google.gson.Gson
import com.wallapop.infrastructure.controllers.CreateMarsRoverDTO
import com.wallapop.main
import domain.point.PointStub
import domain.position.DirectionStub
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.amshove.kluent.`should be equal to`
import org.junit.Test

class CreateMarsRoverControllerTest {

    @Test
    fun `should create a mars rover in a Post Request`(): Unit = withTestApplication (Application::main) {

        val createMarsRoverDTO = CreateMarsRoverDTO(
            point = PointStub.random(),
            direction = DirectionStub.random().toString(),
            heightPlanet = 100,
            widthPlanet = 100,
            obstacles = arrayListOf(PointStub.random()))
        with(handleRequest(HttpMethod.Post, "/marsRover") {
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            setBody(Gson().toJson(createMarsRoverDTO))
        }) {
            response.status() `should be equal to` HttpStatusCode.Accepted
            response.content `should be equal to` null
        }
    }
}
