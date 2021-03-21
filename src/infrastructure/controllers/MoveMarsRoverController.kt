package infrastructure.controllers

import com.wallapop.application.moveMarsTo.MoveMarsTo
import com.wallapop.application.moveMarsTo.MoveMarsToCommand
import com.wallapop.domain.position.Movement
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.generic.instance
import org.kodein.di.ktor.kodein

fun Route.moveMarsRoverController() {
    val moveMarsTo by kodein().instance<MoveMarsTo>()

    put("/marsRover/move") {
        val requestBody = call.receive<MoveMarsToDTO>()
        val command = MoveMarsToCommand(movement = Movement.valueOf(requestBody.movement))

        moveMarsTo.execute(command)

        call.respond(HttpStatusCode.Accepted)
    }
}

data class MoveMarsToDTO(val movement: String) {}
