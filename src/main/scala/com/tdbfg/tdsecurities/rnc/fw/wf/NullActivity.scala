package com.tdbfg.tdsecurities.rnc.fw.wf

import com.tdbfg.tdsecurities.rnc.fw.test.TestData
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data

class NullActivity extends Activity {
    override def run(data:Data,context:Context.type): Data = { println("testsfsdf");context("test")="1" ;new TestData("noman");  } 
}