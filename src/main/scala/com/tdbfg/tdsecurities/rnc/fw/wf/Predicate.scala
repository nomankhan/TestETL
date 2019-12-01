package com.tdbfg.tdsecurities.rnc.fw.wf

import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data

case class BooleanData(condition:Boolean) extends Data;

trait Predicate extends Activity {
  def condition(data: Data, context: Context.type):Boolean
  
  override def run(data: Data, context: Context.type): BooleanData = {
    new BooleanData(condition(data, context))
  }
}