package com.tdbfg.tdsecurities.rnc.fw.activities.ext

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.executor.Orchestrator


class WorkflowActivity extends Activity {
  override def run(data: Data, context: Context.type): Data = {
    var orchestrator:Orchestrator = new Orchestrator 
    return orchestrator.main(this.params("config").toString , data, context)
    
  }
}