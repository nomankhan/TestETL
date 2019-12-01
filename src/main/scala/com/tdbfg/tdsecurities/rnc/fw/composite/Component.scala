package com.tdbfg.tdsecurities.rnc.fw.composite

import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context

trait Component[I] {
  def +=(_child: Component[I]): Unit
  def run(prv:Data,context:Context.type):I

}