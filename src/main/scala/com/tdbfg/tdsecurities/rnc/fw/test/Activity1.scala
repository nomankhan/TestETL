package com.tdbfg.tdsecurities.rnc.fw.test

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data


class Activity1 extends Activity{
  override def run(data:Data,context:Context.type): Data = { 
    println("Activity1");context("test")="1" ; 
//    println(name)
    new TestData("This is test from Activity 1");  } 
}