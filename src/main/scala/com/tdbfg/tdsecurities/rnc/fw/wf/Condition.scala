package com.tdbfg.tdsecurities.rnc.fw.wf

import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context

case class Branch(_ture: Activity, _false: Activity) extends Activity { override def run(data: Data, context: Context.type): Data = { data } }

class Condition(predicate: Predicate) extends Activity {
  this: Activity =>

  def >(_true: Activity, _false: Activity): Condition = { next ::= new Branch(_true, _false); this }

  def <(_next: Activity): Activity = { next ::= _next; this }

  def run(data: Data, context: Context.type): Data = {
    var temp: Data = new Data()
    next.reverse foreach { (r) =>
      {
        if (r.isInstanceOf[Branch])
          if (predicate.condition(data,context)) temp = r.asInstanceOf[Branch]._ture.run(data, context)
          else temp = r.asInstanceOf[Branch]._false.run(data, context)
        else
          temp = r.run(data, context)
      }
    }
    temp
  }
}