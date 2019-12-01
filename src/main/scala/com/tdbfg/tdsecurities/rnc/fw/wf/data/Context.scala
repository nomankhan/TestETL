package com.tdbfg.tdsecurities.rnc.fw.wf.data

import java.util.Hashtable

object Context {
  var session: Hashtable[Any, Any] = new Hashtable[Any, Any]
  def apply() = {}

  def apply(x: Any) = session.get(x)
  def update(x: Any, y: Any): Unit = session.put(x, y)
  def -(x: Any)=session.remove(x)
}

