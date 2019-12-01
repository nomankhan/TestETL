package com.tdbfg.tdsecurities.rnc.fw.wf

import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data

class Start(str: String) extends Activity {
  this: Activity =>

  def ->(_next: Activity): Activity = { next ::= _next; this }

  def run(data: Data, context: Context.type): Data = {
//    println(str)
    var temp: Data = new Data
    var _data:Data  = new Data()
    next foreach { (r) =>
      {
        temp = r.run(data, context)
      }
    }
    temp
  }
  def start(data:Data,context:Context.type):Data ={
    this.run(new Data, context)
  }
}