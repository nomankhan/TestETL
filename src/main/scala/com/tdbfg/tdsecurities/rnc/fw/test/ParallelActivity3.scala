package com.tdbfg.tdsecurities.rnc.fw.test

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data

class ParallelActivity3 extends Activity{
  override def run(data:Data,context:Context.type): Data = { Thread.sleep(1800);println("ParallelActivity3");context("test")="1" ;new TestData("P3");  } 
}