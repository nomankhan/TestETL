package com.tdbfg.tdsecurities.rnc.fw.test

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data
import com.tdbfg.tdsecurities.rnc.fw.util.Util


class Commitable extends Activity{
  final val isDone="isDone"
  var status:String = "true"
  override def run(_data:Data,context:Context.type): Data = { 
    var data:Data=_data
    if(params(isDone).equals("true")) 
      return null
    data = commitableRun(data, context)          
    Util.writeObject(data,"")
    data
  }
  def commitableRun(data:Data,context:Context.type): Data = {
    return data;
  }
  
}