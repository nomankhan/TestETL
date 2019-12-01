package com.tdbfg.tdsecurities.rnc.fw.wf

import com.tdbfg.tdsecurities.rnc.fw.composite.Composite
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data

trait Activity extends Composite[Data] {
  var _name:String = "start"
  def name = _name
  def name_=(value: String): Unit = _name = value

  
  var next: List[Activity] = List()

  var _params: Map[String, String] = Map[String,String]()
  def params = _params
  def params_=(value: Map[String, String]): Unit = _params = value

  def run(prv: Data, context: Context.type): Data
  
}