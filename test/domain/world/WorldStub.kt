package domain.world

import com.wallapop.domain.world.Obstacle
import com.wallapop.domain.world.World

class WorldStub {
    companion object {
        fun random(height: Int = 100, width: Int = 100, obstacles: List<Obstacle> = emptyList()): World {
            return World(height = height, width = width, obstacles =obstacles)
        }
    }
}
