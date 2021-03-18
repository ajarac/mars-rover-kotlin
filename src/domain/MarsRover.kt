package com.wallapop.domain

import com.wallapop.domain.planet.Planet
import com.wallapop.domain.position.Movement
import com.wallapop.domain.position.Position
import com.wallapop.domain.position.Rotate

class MarsRover(private var position : Position = Position(), private val planet: Planet = Planet(10, 10)) {

    fun getPosition(): Position {
        return position
    }

    fun moveTo(movement: Movement) {
        position = position.moteTo(movement, planet)
    }

    fun rotateTo(rotate: Rotate) {
        position = position.rotateTo(rotate)
    }

    fun getPlanet(): Planet {
        return planet
    }

}
