package com.wallapop.application.rotateMarsTo

import com.wallapop.domain.MarsRover
import com.wallapop.domain.MarsRoverRepository

class RotateMarsTo(private val repository: MarsRoverRepository)  {

    fun execute(command: RotateMarsToCommand) {
        val rover: MarsRover = repository.findOrFail()

        rover.rotateTo(command.rotate)

        repository.update(rover)
    }
}
