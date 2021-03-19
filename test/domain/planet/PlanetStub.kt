package domain.planet

import com.wallapop.domain.planet.Obstacle
import com.wallapop.domain.planet.Planet
import shared.FakerSingleton

class PlanetStub {
    companion object {
        fun random(height: Int = FakerSingleton.randomInt(10, 100), width: Int = FakerSingleton.randomInt(10, 100), obstacles: ArrayList<Obstacle> = arrayListOf()): Planet {
            return Planet(height = height, width = width, obstacles =obstacles)
        }
    }
}
