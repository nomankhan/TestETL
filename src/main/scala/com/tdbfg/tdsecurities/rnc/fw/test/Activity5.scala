package com.tdbfg.tdsecurities.rnc.fw.test

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data

class Activity5 extends Activity{
  override def run(data:Data,context:Context.type): Data = { println(name);println("Activity5");println("Context Value : "+context("test")) ;new TestData("noman");  } 
}