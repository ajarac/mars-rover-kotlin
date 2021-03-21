package com.wallapop.application.createMarsRover

import com.wallapop.domain.planet.Obstacle
import com.wallapop.domain.point.Point
import com.wallapop.domain.position.Direction

data class CreateMarsRoverCommand(
    val point: Point,
    val direction: Direction,
    val heightPlanet: Int,
    val widthPlanet: Int,
    val obstacles: List<Obstacle>)
