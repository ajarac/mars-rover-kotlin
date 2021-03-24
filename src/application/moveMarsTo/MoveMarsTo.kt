package com.wallapop.application.moveMarsTo

import com.wallapop.domain.MarsRover
import com.wallapop.domain.MarsRoverRepository

class MoveMarsTo (private val repository: MarsRoverRepository) {

    fun execute(command: MoveMarsToCommand) {
        val rover: MarsRover = repository.findOrFail()

        rover.moveTo(command.movement)

        repository.update(rover)
    }
}
