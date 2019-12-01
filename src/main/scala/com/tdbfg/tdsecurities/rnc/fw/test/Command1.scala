package com.tdbfg.tdsecurities.rnc.fw.test

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data


class Command1 extends Activity{
  override def run(data:Data,context:Context.type): Data = { 
    println("Command1");context("test")="1" ; 
    println(next.getClass)
    new TestData("This is tes from Activity 1");  } 
}