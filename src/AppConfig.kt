package com.wallapop

import com.wallapop.application.createMarsRover.CreateMarsRover
import com.wallapop.application.moveMarsTo.MoveMarsTo
import com.wallapop.application.rotateMarsTo.RotateMarsTo
import com.wallapop.domain.MarsRoverNotFoundException
import com.wallapop.domain.MarsRoverRepository
import com.wallapop.infrastructure.controllers.checkController
import com.wallapop.infrastructure.controllers.createMarsRoverController
import com.wallapop.infrastructure.controllers.rotateMarsRoverController
import com.wallapop.infrastructure.repository.inmemory.InMemoryMarsRoverRepository
import infrastructure.controllers.moveMarsRoverController
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import org.kodein.di.ktor.kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

import java.time.Duration


fun Application.main() {
    install(DefaultHeaders)
    install(CORS) {
        maxAgeInSeconds = Duration.ofDays(1).seconds
    }
    install (ContentNegotiation) {
        gson()
        json()
    }
    install(StatusPages) {
        exception<MarsRoverNotFoundException> {
            call.respond(HttpStatusCode.NotFound)
        }
    }
    kodein {
        bind<MarsRoverRepository>() with singleton { InMemoryMarsRoverRepository() }
        bind<CreateMarsRover>() with singleton { CreateMarsRover(instance()) }
        bind<MoveMarsTo>() with singleton { MoveMarsTo(instance()) }
        bind<RotateMarsTo>() with singleton { RotateMarsTo(instance()) }
    }
    routing {
        checkController()
        createMarsRoverController()
        moveMarsRoverController()
        rotateMarsRoverController()
    }
}
