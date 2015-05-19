def mathFunction(num: Int): Int = {
	var numSquare: Int = num * num
	return (math.cbrt(numSquare) + math.log(numSquare)).asInstanceOf[Int]
}
