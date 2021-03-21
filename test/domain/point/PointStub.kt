package domain.point

import com.wallapop.domain.point.Point
import shared.FakerSingleton

class PointStub {
    companion object {
        fun random(x: Int = FakerSingleton.randomInt(0, 99), y: Int = FakerSingleton.randomInt(0, 99)): Point {
            return Point(x, y)
        }
    }
}
