package com.tdbfg.tdsecurities.rnc.fw.test

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data

class Activity3 extends Activity{
  override def run(data:Data,context:Context.type): Data = { println("Activity3");context("test")="1" ;new TestData("noman");  } 
}