import math._
def intRoot23(num: Int) = {
	val numSquare = num*num
	(cbrt(numSquare) + log(numSquare)).toInt
}
