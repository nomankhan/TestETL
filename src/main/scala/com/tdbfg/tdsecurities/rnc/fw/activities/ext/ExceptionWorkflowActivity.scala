package com.tdbfg.tdsecurities.rnc.fw.activities.ext

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data._
import com.tdbfg.tdsecurities.rnc.fw.executor.Orchestrator

class ExceptionWorkflowActivity  extends Activity {
  override def run(data: Data, context: Context.type): Data = {
    try{
      (new Orchestrator()).main(this.params("try").toString , data, context)
     }catch{
       case e:Exception => (new Orchestrator()).main(this.params("catch").toString , data, context)
     }finally{
      (new Orchestrator()).main(this.params("finally").toString , data, context)
     } 
  }
   
}