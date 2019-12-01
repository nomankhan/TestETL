package com.tdbfg.tdsecurities.rnc.fw.activities.ext

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data._
import com.tdbfg.tdsecurities.rnc.fw.wf.NullActivity

class ExceptionActivity extends Activity {
  override def run(data: Data, context: Context.type): Data = {
    try {
      var temp = this.params("try")
      var tryActivity: Activity = new NullActivity
      if (temp != null)
        tryActivity = Class.forName(temp).newInstance().asInstanceOf[Activity]
      tryActivity.run(data, context)
    } catch {
      case e: Exception => {
        var temp = this.params("catch")
        var catchActivity: Activity = new NullActivity
        if (temp != null)
          catchActivity = Class.forName(temp).newInstance().asInstanceOf[Activity]
        catchActivity.run(data, context)
      }
    } finally {
      var temp = this.params("finally")
      var finalyActivity: Activity = new NullActivity
      if (temp != null)
        finalyActivity = Class.forName(temp).newInstance().asInstanceOf[Activity]
      finalyActivity.run(data, context)
    }
  }

}