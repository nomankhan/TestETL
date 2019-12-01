package com.tdbfg.tdsecurities.rnc.fw.test

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.DataList
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data
//import com.tdbfg.tdsecurities.rnc.fw.wf.SplitData

class Activity4 extends Activity {
  override def run(data: Data, context: Context.type): Data = {
    println(name); 
    println("Activity4");new TestData("noman");
    for(datum <- data.asInstanceOf[DataList].data)
      println(datum)
    data  
  }
}