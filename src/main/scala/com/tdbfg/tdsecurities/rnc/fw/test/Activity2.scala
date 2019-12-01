package com.tdbfg.tdsecurities.rnc.fw.test

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data

class Activity2 extends Activity {
  override def run(data: Data, context: Context.type): Data = {
//println(name)
    println("Activity2");
    context("test") = "1";
    data
  }
}