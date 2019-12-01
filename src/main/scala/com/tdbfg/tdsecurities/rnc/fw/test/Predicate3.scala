package com.tdbfg.tdsecurities.rnc.fw.test

import com.tdbfg.tdsecurities.rnc.fw.wf.Predicate
import com.tdbfg.tdsecurities.rnc.fw.wf.BooleanData
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data

class Predicate3 extends Predicate {
   override def condition(data: Data, context: Context.type): Boolean = {
     return params("key").toBoolean
  }
}