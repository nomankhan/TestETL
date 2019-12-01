package com.tdbfg.tdsecurities.rnc.fw.test

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Try
import scala.concurrent.Await
import scala.util.Failure
import scala.util.Success

import scala.concurrent.duration._
import scala.concurrent._

class A { def run: String = { "test" } }
class A1 extends A { override def run(): String = { println("A1"); "A1" } }
class A2 extends A { override def run(): String = {Thread.sleep(100); println("A2"); "A2" } }
class A3 extends A { override def run(): String = {Thread.sleep(1000); println("A3"); "A3" } }

object TestThread {
  def main(args: Array[String]) = {
    var l: List[A] = List()
    l ::= new A2()
    l ::= new A3()
//    var future = 
      
    var fk: List[Future[Any]]= List()
      for (k <- l) {fk::=Future {
        k.run
      }}
    
    var ff: List[Future[String]] = List()
    Try(Await.result(Future.sequence(fk), Int.MaxValue.second)) match {
      case Success(retVal) => { println("fs -sdf - " + retVal) }
      case Failure(e)      => println(e.getMessage)
    }
    for (f <- fk)
      f onComplete {
        case Success(posts) => println(posts)
        case Failure(t)     => println("An error has occured: " + t.getMessage)
      }
  }
}

