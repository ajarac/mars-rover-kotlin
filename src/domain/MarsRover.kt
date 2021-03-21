package com.wallapop.domain

import com.wallapop.domain.planet.World
import com.wallapop.domain.position.Movement
import com.wallapop.domain.position.Position
import com.wallapop.domain.position.Rotate

data class MarsRover(private var position : Position = Position(), private val world: World = World(10, 10)) {

    fun getPosition(): Position {
        return position
    }

    fun moveTo(movement: Movement) {
        position = position.moteTo(movement, world)
    }

    fun rotateTo(rotate: Rotate) {
        position = position.rotateTo(rotate)
    }

    fun getPlanet(): World {
        return world
    }

}
