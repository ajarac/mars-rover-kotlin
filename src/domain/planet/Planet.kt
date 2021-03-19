package com.wallapop.domain.planet

import com.wallapop.domain.point.Point

data class Planet(val height: Int, val width: Int, val obstacles: ArrayList<Obstacle> = arrayListOf()) {

    fun checkEncounterAnObstacle(point: Point) {
        val encounterAnObstacle: Boolean =  obstacles.any{it.point == point}
        if(encounterAnObstacle) {
            throw EncounterAnObstacleException("Encounter obstacle!")
        }
    }
}
