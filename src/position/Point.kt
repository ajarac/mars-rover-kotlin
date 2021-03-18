package com.wallapop.position

data class Point (val x: Int,val y: Int) {

    fun add(point: Point): Point = Point(x + point.x, y + point.y)

    fun subtract(point: Point): Point = Point(x - point.x, y - point.y)

    fun normalize(height: Int, width: Int): Point {
        return Point(x % height, y % width)
    }
}
