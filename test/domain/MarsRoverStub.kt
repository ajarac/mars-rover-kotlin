package domain

import com.wallapop.domain.MarsRover
import com.wallapop.domain.world.World
import com.wallapop.domain.position.Position
import domain.world.PlanetStub
import domain.position.PositionStub

class MarsRoverStub {
    companion object {
        fun random(position: Position = PositionStub.random(), world: World = PlanetStub.random()): MarsRover {
            return MarsRover(position = position, world = world)
        }
    }
}
