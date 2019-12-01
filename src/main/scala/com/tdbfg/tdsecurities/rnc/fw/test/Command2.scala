package com.tdbfg.tdsecurities.rnc.fw.test

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data

class Command2 extends Activity {
  override def run(data: Data, context: Context.type): Data = {
    println("Command2");
    context("test") = "1";
    println(next.getClass.getName)
    for(l<-next)
      t(l)
    new TestData("This is tes from Activity 1");
  }

  def t(next: Activity): Activity = {
    println(next.getClass.getName)
    var c= t(next)
    while(c!=null)
      c=t(c)
           
    null 
      
  }
}