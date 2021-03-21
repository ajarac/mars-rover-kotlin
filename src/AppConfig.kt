package com.wallapop

import com.wallapop.application.createMarsRover.CreateMarsRover
import com.wallapop.domain.MarsRoverRepository
import com.wallapop.infrastructure.controllers.checkController
import com.wallapop.infrastructure.controllers.createMarsRoverController
import com.wallapop.infrastructure.repository.inmemory.InMemoryMarsRoverRepository
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*
import io.ktor.serialization.*
import org.kodein.di.ktor.kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import java.text.DateFormat

import java.time.Duration


fun Application.main() {
    install(DefaultHeaders)
    install(CORS) {
        maxAgeInSeconds = Duration.ofDays(1).seconds
    }
    install (ContentNegotiation) {
        gson {
            setDateFormat(DateFormat.LONG)
            setPrettyPrinting()
        }
        json()
    }
    kodein {
        bind<MarsRoverRepository>() with singleton { InMemoryMarsRoverRepository() }
        bind<CreateMarsRover>() with singleton { CreateMarsRover(instance()) }
    }
    routing {
        checkController()
        createMarsRoverController()
    }
}
