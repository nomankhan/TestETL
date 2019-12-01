package com.tdbfg.tdsecurities.rnc.fw.wf
import scala.util.Success
import scala.util.Try
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context

case class DataList(var data: List[Data]) extends Data //{ def +=(_data: Data): Unit = { data ::= _data } }

class Merge extends Sequence(new NullActivity){
  this: Activity =>
    
  override def run(data: Data, context: Context.type): Data = {
    var temp: Data = new Data()
    next foreach { (r) => temp = r.run(data, context) }
    temp
  }
}