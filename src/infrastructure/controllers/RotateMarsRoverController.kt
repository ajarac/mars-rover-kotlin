package com.wallapop.infrastructure.controllers

import com.wallapop.application.rotateMarsTo.RotateMarsTo
import com.wallapop.application.rotateMarsTo.RotateMarsToCommand
import com.wallapop.domain.position.Rotate
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.generic.instance
import org.kodein.di.ktor.kodein

fun Route.rotateMarsRoverController() {
    val rotateMarsTo by kodein().instance<RotateMarsTo>()

    post("/marsRover/rotate") {
        val requestBody = call.receive<RotateMarsToDTO>()
        val command = RotateMarsToCommand(rotate = Rotate.valueOf(requestBody.rotate))

        rotateMarsTo.execute(command)

        call.respond(HttpStatusCode.Accepted)
    }
}

data class RotateMarsToDTO(val rotate: String)
