class Point(
	val x: Double, val y: Double,
	addToGrid: Boolean = false
) {
	import Point._

	if (addToGrid)
		grid += this

	def this() = this(0.0, 0.0)

	def distanceToPoint(other: Point) =
		distanceBetweenPoints(x, y, other.x, other.y)
}

object Point {
	import collection.mutable.MutableList
	private val grid = new MutableList[Point]

	def distanceBetweenPoints(x1: Double, y1: Double,
		x2: Double, y2: Double) = {
		math.hypot(x1 - x2, y1 - y2)
	}
}
