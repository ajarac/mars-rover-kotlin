package com.wallapop.application.rotateMarsTo

import com.wallapop.application.ApplicationService
import com.wallapop.domain.MarsRover
import com.wallapop.domain.MarsRoverNotFoundException
import com.wallapop.domain.MarsRoverRepository
import java.util.*

class RotateMarsTo(private val repository: MarsRoverRepository): ApplicationService<RotateMarsToCommand>  {

    override fun execute(command: RotateMarsToCommand) {
        val optionalMars: Optional<MarsRover> = repository.get()
        if(optionalMars.isPresent) {
            val mars = optionalMars.get()
            mars.rotateTo(command.rotate)

            repository.update(mars)
        } else {
            throw MarsRoverNotFoundException()
        }
    }
}
