package com.wallapop.application.createMarsRover

import com.wallapop.domain.MarsRover
import com.wallapop.domain.MarsRoverRepository
import com.wallapop.domain.world.World
import com.wallapop.domain.position.Position

class CreateMarsRover(private val repository: MarsRoverRepository) {

    fun execute(command: CreateMarsRoverCommand) {
        val position = Position(point = command.point, direction = command.direction)
        val world = World(height = command.heightPlanet, width = command.widthPlanet, obstacles = command.obstacles)
        val marsRover = MarsRover(position = position, world = world)

        repository.create(marsRover)
    }

}
