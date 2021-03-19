package domain.position

import com.wallapop.domain.position.Direction
import shared.FakerSingleton

class DirectionStub {
    companion object {
        fun random(): Direction = Direction.values()[FakerSingleton.randomInt(Direction.values().size)]
    }
}
