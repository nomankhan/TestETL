package com.tdbfg.tdsecurities.rnc.fw.wf

case class Step(name:String,cmd: Activity, children: List[String], nexts: List[String],params:Map[String,String])
