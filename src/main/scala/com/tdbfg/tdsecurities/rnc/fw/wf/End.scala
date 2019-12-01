package com.tdbfg.tdsecurities.rnc.fw.wf

import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context

class End() extends Activity {
  this: Activity =>
  def run(data: Data, context: Context.type): Data = {
    var temp:Data = new Data()
    next foreach { (r) =>{temp = r.run(data,context)}
    }
    temp
  }
}
