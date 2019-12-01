package com.tdbfg.tdsecurities.rnc.fw.test

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data


class Commit extends Activity{
  override def run(data:Data,context:Context.type): Data = { 
    println("Commit"); 
    new TestData("");  } 
}