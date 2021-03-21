package com.wallapop.domain

import com.wallapop.domain.world.World
import com.wallapop.domain.position.Movement
import com.wallapop.domain.position.Position
import com.wallapop.domain.position.Rotate

data class MarsRover(private var position : Position = Position(), private val world: World = World()) {

    init {
        world.checkPointInsideWorld(position.point)
    }

    fun getPosition(): Position {
        return position
    }

    fun moveTo(movement: Movement) {
        position = position.moteTo(movement, world)
        world.checkPointInsideWorld(position.point)
    }

    fun rotateTo(rotate: Rotate) {
        position = position.rotateTo(rotate)
        world.checkPointInsideWorld(position.point)
    }

    fun getWorld(): World {
        return world
    }

}
