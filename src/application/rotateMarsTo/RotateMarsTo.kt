package com.wallapop.application.rotateMarsTo

import com.wallapop.domain.MarsRover
import com.wallapop.domain.MarsRoverNotFoundException
import com.wallapop.domain.MarsRoverRepository
import java.util.*

class RotateMarsTo(private val repository: MarsRoverRepository)  {

    fun execute(command: RotateMarsToCommand) {
        val rover: MarsRover = repository.findOrFail()

        rover.rotateTo(command.rotate)

        repository.update(rover)
    }
}
