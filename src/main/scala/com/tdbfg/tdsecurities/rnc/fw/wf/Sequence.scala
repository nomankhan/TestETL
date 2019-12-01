package com.tdbfg.tdsecurities.rnc.fw.wf

import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context

// Sequential Activities

class Sequence(activity: Activity) extends Activity {
  this: Activity =>
  def ->(_next: Activity): Activity = { next ::= _next; this }

  def run(data: Data, context: Context.type): Data = {
    var temp: Data = activity.run(data, context)
    next foreach { (r) =>
      {
        temp = r.run(temp, context)
      }
    }
    temp
  }
}