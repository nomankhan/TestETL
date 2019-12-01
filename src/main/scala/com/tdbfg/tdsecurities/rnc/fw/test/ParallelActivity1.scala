package com.tdbfg.tdsecurities.rnc.fw.test

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data

class ParallelActivity1 extends Activity {
  override def run(data: Data, context: Context.type): Data = { 
    Thread.sleep(3000); 
    println("ParallelActivity1"); 
    context("test") = "1"; 
    new TestData("P1"); }
}