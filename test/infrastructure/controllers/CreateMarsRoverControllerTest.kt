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
import shared.FakerSingleton

class CreateMarsRoverControllerTest {

    @Test
    fun `should create a mars rover as Post Request`(): Unit = withTestApplication (Application::main) {

        val createMarsRoverDTO = CreateMarsRoverDTO(
            point = PointStub.random(),
            direction = DirectionStub.random().toString(),
            heightPlanet = FakerSingleton.randomInt(0, 100),
            widthPlanet = FakerSingleton.randomInt(0, 100),
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
