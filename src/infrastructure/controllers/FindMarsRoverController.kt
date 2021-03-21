package com.wallapop.infrastructure.controllers

import com.wallapop.application.findMarsRover.FindMarsRover
import com.wallapop.domain.MarsRover
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.generic.instance
import org.kodein.di.ktor.kodein

fun Route.finMarsRoverController() {
    val findMarsRover by kodein().instance<FindMarsRover>()

    get("/marsRover") {
        val marsRover: MarsRover = findMarsRover.execute()

        call.respond(HttpStatusCode.OK, marsRover)
    }
}
