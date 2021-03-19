package com.wallapop.application.moveMarsTo

import com.wallapop.application.ApplicationService
import com.wallapop.domain.MarsRover
import com.wallapop.domain.MarsRoverNotFoundException
import com.wallapop.domain.MarsRoverRepository
import java.util.*

class MoveMarsTo (private val repository: MarsRoverRepository): ApplicationService<MoveMarsToCommand> {

    override fun execute(command: MoveMarsToCommand) {
        val optionalMars: Optional<MarsRover> = repository.get()
        if(optionalMars.isPresent) {
            val mars = optionalMars.get()
            mars.moveTo(command.movement)

            repository.update(mars)
        } else {
            throw MarsRoverNotFoundException()
        }
    }
}
