package com.wallapop.domain

interface MarsRoverRepository {

    fun findOrFail(): MarsRover

    fun create(marsRover: MarsRover)

    fun update(marsRover: MarsRover)

    fun delete()
}
