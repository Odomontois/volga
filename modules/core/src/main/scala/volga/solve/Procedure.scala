package volga.solve

import cats.free.Free
import cats._

case class Proc[+C, +N](impl: Impl[C, N], inputs: C, outputs: C)

enum Impl[+C, +N]{
   case Block(procs: List[List[Proc[C, N]]])
   case Call(name: N)        
}

enum Pairs[+A]{
  case Pair(first: Pairs[A], next: Pairs[A])
  case One(elem : A)
}

trait SymMon[N, A]{
  def (n: N) call: A
  def swap: A
  def (x: A) compose(y: A): A
  def (x: A) product(y: A): A
}

type VarClause = Free[List, Int]

def varList(xs: Int*): VarClause = Free.liftF(xs.toList)

trait Arr[N, A] extends SymMon[N, A]{
  def (in: VarClause) projectTo (out: VarClause): A
  def swap = varList(1, 2) projectTo varList(2, 1)
}

def solveArr[V, N, A](proc: Proc[List[V], N]) given  Arr[N, A] : A = {
  

  proc.impl match {
    case Impl.Call(name) => name.call
    case Impl.Block(pars) =>  ???
  }
  ???
}



