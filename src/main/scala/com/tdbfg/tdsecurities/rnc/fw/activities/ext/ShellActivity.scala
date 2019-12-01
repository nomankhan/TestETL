package com.tdbfg.tdsecurities.rnc.fw.activities.ext

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data

import scala.sys.process._
import org.slf4j.LoggerFactory

class ShellActivity extends Activity {
  val logger = LoggerFactory.getLogger(classOf[ShellActivity])
  override def run(data: Data, context: Context.type): Data = {
    val output: String = this.params("shellcmd").toString !!

    logger.debug(this.name + "") 
    logger.debug("" + output + "")
    logger.debug("Activity1"); context("test") = "1";
    logger.debug(name)
    new Data();

  }
}