package com.wallapop.application.findMarsRover

import com.wallapop.domain.MarsRover
import com.wallapop.domain.MarsRoverRepository

class FindMarsRover (private val repository: MarsRoverRepository) {
    fun execute(): MarsRover {
        return repository.findOrFail()
    }
}
