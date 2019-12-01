package com.tdbfg.tdsecurities.rnc.fw.executor

import com.tdbfg.tdsecurities.rnc.fw.wf.data._
//import com.tdbfg.tdsecurities.stars.rnc.common.factory.ExceptionFactory
//import com.tdbfg.tdsecurities.stars.rnc.common.exception.RNCException
//import com.tdbfg.tdsecurities.stars.rnc.common.exception.PipeLineException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
//import com.tdbfg.tdsecurities.rnc.common.exception.RNCException
//import com.tdbfg.tdsecurities.rnc.common.factory.ExceptionFactory
//import com.tdbfg.tdsecurities.rnc.common.exception.PipeLineException

object Main {
  val logger = LoggerFactory.getLogger("Main")
  def main(args: Array[String])  {
    var orch: Orchestrator = new Orchestrator
    orch.main("/condition.conf", new Data, Context) 
//  Exception throwing example
//    var factory:ExceptionFactory = ExceptionFactory.getInstance
//    try{
//      factory.throwRNCException(new RNCException)    
//    }catch{
//      case e: RNCException => println("Got RNC Exception")
//      case e2: Exception => println("Something else went wrong!")
//    }
//
//    try{
////      factory.throwRNCException(new PipeLineException)    
//    }catch{
//      case e: RNCException => logger.debug("Got PipLine Exception")
//      case e2: Exception => logger.debug("Something else went wrong! - {}", e2.getMessage)
//    }

  }
}  