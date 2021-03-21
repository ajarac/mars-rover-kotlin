package com.wallapop.infrastructure.controllers

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.checkController() {
    get("/check") {
        call.respond(HttpStatusCode.OK, "Hello mars rover!")
    }
}
