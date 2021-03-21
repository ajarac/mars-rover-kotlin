package com.wallapop.infrastructure.controllers

import com.wallapop.application.deleteMarsRover.DeleteMarsRover
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.generic.instance
import org.kodein.di.ktor.kodein

fun Route.deleteMarsRoverController() {
    val deleteMarsRover by kodein().instance<DeleteMarsRover>()

    delete("/marsRover") {
        deleteMarsRover.execute()

        call.respond(HttpStatusCode.OK)
    }
}
