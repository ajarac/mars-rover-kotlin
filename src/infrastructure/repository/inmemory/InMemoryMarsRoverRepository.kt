package com.wallapop.infrastructure.repository.inmemory

import com.wallapop.domain.MarsRover
import com.wallapop.domain.MarsRoverRepository
import java.util.*

class InMemoryMarsRoverRepository : MarsRoverRepository {
    private  var marsRover: MarsRover? = null

    override fun get(): Optional<MarsRover> {
        return Optional.ofNullable(marsRover)
    }

    override fun create(marsRover: MarsRover) {
       this.marsRover = marsRover.copy()
    }

    override fun update(marsRover: MarsRover) {
        this.marsRover = marsRover.copy()
    }

    override fun delete() {
        marsRover = null
    }
}
