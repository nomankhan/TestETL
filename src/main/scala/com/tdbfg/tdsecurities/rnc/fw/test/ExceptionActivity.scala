package com.tdbfg.tdsecurities.rnc.fw.test

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data

class ExceptionActivity extends Activity{
  override def run(data:Data,context:Context.type): Data = { println("Exception");context("test")="1" ;throw new Exception("Exception	");new TestData("noman");  } 
}