// Expressions
val s = for (x <- 1 to 25 if x * x > 50) yield 2*x

val x = 'c'
val hexDigit = if (x >= 10) x + 'A' - 10 else x + '0'

// Type Inference
def printValue(x: String) = println("I ate a %s" format x)
def formatApples(x: Int) = "I ate %d apples" format x

def factorial(x: Int): Int = if (x == 1) 1 else x * factorial(x - 1)

// Anonymous Functions
val list = List(1, 2, 3, 4, 5) map { _.toDouble } map math.sqrt

// Case classes and pattern matching
def qsort(list: List[Int]): List[Int] = list match {
	case Nil => Nil
	case pivot :: tail => 
		val (smaller, rest) = tail.partition(_ < pivot)
		qsort(smaller) ::: pivot :: qsort(rest)
}

// Object-oriented extensions
abstract class Window {
	// abstract
	def draw()
}

class SimpleWindow extends Window {
	def draw() {
		println("in SimpleWindow")
		// draw a basic window
	}
}

trait WindowDecoration extends Window {}

trait HorizontalScrollbarDecoration extends WindowDecoration {
	// "abstract override" is needed here in order for "super()" to work because the parent
	// function is abstract. If it were concrete, regular "override" would be enough.
	abstract override def draw() {
		println("in HorizontalScrollbarDecoration")
		super.draw()
		// now draw a horizontal scollbar
	}
}

trait VerticalScrollbarDecoration extends WindowDecoration {
	abstract override def draw() {
		println("in VerticalScollbarDecoration")
		super.draw()
		// now draw a vertical scrollbar
	}
}

trait TitleDecoration extends WindowDecoration {
	abstract override def draw() {
		println("in TitleDecoration")
		super.draw()
		// now draw the title bar
	}
}

val myWindow = new SimpleWindow with VerticalScrollbarDecoration with HorizontalScrollbarDecoration with TitleDecoration

myWindow.draw()

// Type enrichment
object IntExtensions {
	implicit class IntPredicates(i: Int) {
		def isEven = i % 2 == 0
		def isOdd = !isEven
	}
}
import IntExtensions._
4.isEven

// Concurrency
/*
val echoServer = actor(new Act {
	become {
		case msg => println("echo " + msg)
	}
})
echoServer ! "hi"
*/

val urls = List("http://scala-lang.org", "https://github.com/scala/scala")
def fromURL(url: String) = scala.io.Source.fromURL(url)
	.getLines().mkString("\n")
val t = System.currentTimeMillis()
urls.par.map(fromURL(_))
println("time: " + (System.currentTimeMillis - t) + "ms")
