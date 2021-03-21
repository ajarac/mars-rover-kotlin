package com.wallapop.application.findMarsRover

import com.wallapop.domain.MarsRover
import com.wallapop.domain.MarsRoverNotFoundException
import com.wallapop.domain.MarsRoverRepository
import java.util.*

class FindMarsRover (private val repository: MarsRoverRepository) {
    fun execute(): MarsRover {
        return repository.findOrFail()
    }
}
