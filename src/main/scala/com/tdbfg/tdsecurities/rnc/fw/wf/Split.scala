package com.tdbfg.tdsecurities.rnc.fw.wf

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import scala.util.Success
import scala.util.Try
import scala.util.Failure

case class SplitData(future: List[Future[Data]]) extends Data

class Split extends Activity {
  this: Activity =>
  def ==>(_nexts: Activity*): Split = { var temp: Activity = new Split(); _nexts foreach { temp += _ }; next ::= (temp); this }
  def ==>(_nexts: List[Activity]): Split = { var temp: Activity = new Split(); _nexts foreach { temp += _ }; next ::= (temp); this }

  def <==(_next: Merge): Split = { next ::= _next; this }
  def ->(_next: Activity): Activity = { next ::= _next; this }

  def run(data: Data, context: Context.type): Data = {
    var returnData=data

    var future: List[Future[Data]] = List[Future[Data]]()
    var splitData: SplitData = new SplitData(List())
    next.reverse foreach { (r) =>
      {
        if (r.children.length > 0) {
          for (k <- r.children) {
            future ::= Future {
              k.run(data, context)
            }
          }
        }

        var returnList:List[Data] = List()
        
        if (r.isInstanceOf[Merge]) {
          Try(Await.result(Future.sequence(future), Int.MaxValue.second)) match {
            case Success(retVal) => { returnList=retVal}//returnList = new DataList(retVal) }
            case Failure(e)      => println(e.getMessage)
          }
          for (f <- future)
            f onComplete {
              case Success(posts) => returnList::=posts
              case Failure(t)     => println("An error has occured: " + t.getMessage)
            }
          returnData= new DataList(returnList)   
          r.run(data, context)
        } else {
          r.run(new DataList(returnList), context)
        }
      }
    }
    returnData
  }
}
