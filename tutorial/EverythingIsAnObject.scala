val x = 10
1 + 2 * 3 / x
(1).+(((2).*(3))./(x))
1.+(2)
(1).+(2)

object Timer {
	def oncePerSecond(callback: () => Unit, count: Int = 1) = for (i <- 1 to count) { callback(); Thread sleep 1000 }
	def main(args: Array[String] = null) = oncePerSecond(() => println("time flies like an arrow..."))
}

Timer.main()
