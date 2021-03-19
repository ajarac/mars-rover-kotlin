package com.wallapop.domain.point

data class Point (val x: Int,val y: Int) {

    fun add(point: Point): Point = Point(x + point.x, y + point.y)

    fun subtract(point: Point): Point = Point(x - point.x, y - point.y)

    fun normalize(height: Int, width: Int): Point = Point(Math.floorMod(x, height), Math.floorMod(y , width))
}
