package com.wallapop.domain

interface MarsRoverRepository {

    fun get(): MarsRover

    fun create(marsRover: MarsRover)

    fun update(marsRover: MarsRover)

    fun delete()
}
