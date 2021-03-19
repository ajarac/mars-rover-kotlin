package com.wallapop.application.deleteMarsRover

import com.wallapop.domain.MarsRoverRepository

class DeleteMarsRover(private val repository: MarsRoverRepository) {

    fun execute() {
        repository.delete()
    }
}
