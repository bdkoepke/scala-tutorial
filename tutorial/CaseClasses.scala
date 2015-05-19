abstract class Exp
case class ESum(l: Exp, r: Exp) extends Exp
case class TVar(n: String) extends Exp
case class TInt(v: Int) extends Exp

type Environment = String => Int

def eval(t: Exp, env: Environment): Int = t match {
	case ESum(l, r) => eval(l, env) + eval(r, env)
	case TVar(n) => env(n)
	case TInt(v) => v
}

def derive(t: Exp, v: String): Exp = t match {
	case ESum(l, r) => ESum(derive(l, v), derive(r, v))
	case TVar(n) if (v == n) => TInt(1)
	case _ => TInt(0)
}

def main(args: Array[String] = null) {
	val exp: Exp = ESum(ESum(TVar("x"), TVar("x")), ESum(TInt(7), TVar("y")))
	val env: Environment = { case "x" => 5 case "y" => 7 }
	println("Expression: " + exp)
	println("Evaluation with x=5, y=7: " + eval(exp, env))
	println("Derivative relative to x:\n " + derive(exp, "x"))
	println("Derivative relative to y:\n " + derive(exp, "y"))
}

main()
