package com.wallapop.infrastructure.controllers

import com.wallapop.application.createMarsRover.CreateMarsRover
import com.wallapop.application.createMarsRover.CreateMarsRoverCommand
import com.wallapop.domain.world.Obstacle
import com.wallapop.domain.point.Point
import com.wallapop.domain.position.Direction
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.generic.instance
import org.kodein.di.ktor.kodein

fun Route.createMarsRoverController() {
    val createMarsRover by kodein().instance<CreateMarsRover>()

    post("/marsRover") {
        val requestBody = call.receive<CreateMarsRoverDTO>()
        val command = CreateMarsRoverCommand(
            point = requestBody.point,
            direction = Direction.valueOf(requestBody.direction),
            heightPlanet = requestBody.heightPlanet,
            widthPlanet = requestBody.widthPlanet,
            obstacles = requestBody.obstacles.map { Obstacle(point = it) } as ArrayList<Obstacle>
        )
        createMarsRover.execute(command)
        call.respond(HttpStatusCode.Accepted)
    }
}

data class CreateMarsRoverDTO(
    val point: Point,
    val direction: String,
    val heightPlanet: Int,
    val widthPlanet: Int,
    val obstacles: ArrayList<Point>
)
