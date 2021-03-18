package com.wallapop

import com.wallapop.position.Movement
import com.wallapop.position.Position
import com.wallapop.position.Rotate

class MarsRover(private var position : Position = Position(), private val planet: Planet = Planet(10, 10)) {

    fun getPosition(): Position {
        return position
    }

    fun moveTo(movement: Movement) {
        position = position.moteTo(movement)
    }

    fun rotateTo(rotate: Rotate) {
        position = position.rotateTo(rotate)
    }

    fun getPlanet(): Planet {
        return planet
    }

}
