package com.wallapop.domain

import java.util.*

interface MarsRoverRepository {

    fun get(): Optional<MarsRover>

    fun create(marsRover: MarsRover)

    fun update(marsRover: MarsRover)

    fun delete()
}
