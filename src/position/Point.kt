package com.wallapop.position

data class Point (val x: Int,val y: Int) {

    fun add(point: Point): Point = Point(x + point.x, y + point.y)

    fun subtract(point: Point): Point = Point(x - point.x, y - point.y)
}
