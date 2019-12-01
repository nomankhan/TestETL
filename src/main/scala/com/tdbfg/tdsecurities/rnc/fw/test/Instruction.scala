package com.tdbfg.tdsecurities.rnc.fw.test

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data


class Instruction extends Activity{
  override def run(data:Data,context:Context.type): Data = { 
    println("Instruciton");
    context("var")="1" ; 
    new TestData("This is tes from Activity 1");  } 
}