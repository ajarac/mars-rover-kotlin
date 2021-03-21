package com.wallapop

import io.ktor.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

const val portArgName = "--server.port"
const val defaultPort = 3000

fun main(args: Array<String> = arrayOf()) {
    val portConfigured = args.isNotEmpty() && args[0].startsWith(portArgName)

    val port = if (portConfigured) {
        args[0].split("=") .last().trim().toInt()
    } else defaultPort

    embeddedServer(Netty,port, module = Application::main).start(wait = true)
}

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
}

