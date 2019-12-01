package com.tdbfg.tdsecurities.rnc.fw.executor

import scala.util.parsing.json._
import scala.io.Source
import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.Start
import com.tdbfg.tdsecurities.rnc.fw.wf.Condition
import com.tdbfg.tdsecurities.rnc.fw.wf.Sequence
import com.tdbfg.tdsecurities.rnc.fw.wf.End
import com.tdbfg.tdsecurities.rnc.fw.wf.Split
import com.tdbfg.tdsecurities.rnc.fw.wf.Merge
import com.tdbfg.tdsecurities.rnc.fw.wf.BooleanData
import com.tdbfg.tdsecurities.rnc.fw.wf.Predicate
import com.tdbfg.tdsecurities.rnc.fw.wf.NullActivity
import com.tdbfg.tdsecurities.rnc.fw.commons.Constants
import com.tdbfg.tdsecurities.rnc.fw.wf.Step
import scala.annotation.tailrec
import com.tdbfg.tdsecurities.rnc.fw.wf.data._



class Orchestrator {
  
  final val EoW = "End of Workflow"
  var workflow: Map[String, Step] = collection.immutable.Map[String, Step]()

  def main(args: String,data:Data,context:Context.type) :Data ={
    var jsonString=""
    var fileName=args;//"/parallel2.conf"
    for (line <- Source.fromInputStream(getClass.getResourceAsStream(fileName)).getLines()) jsonString= line
    workflow=com.tdbfg.tdsecurities.rnc.fw.util.Util.processJson(jsonString)
    process(workflow,data,context) 
  }
  
  //Creating the map 
  def process(wiringMap: Map[String, Step],data:Data,context:Context.type) :Data ={
    var start: Start = new Start(Constants.Json.START)
    wiringMap(Constants.Json.START).cmd.params=wiringMap(Constants.Json.START).params
    var startAcitivty: Sequence = new Sequence(wiringMap(Constants.Json.START).cmd)
    startAcitivty.name=Constants.Json.START
    start -> build(startAcitivty, wiringMap(Constants.Json.START).children, wiringMap(Constants.Json.START).nexts,wiringMap(Constants.Json.START).params)
    start.start(data,context)
  }

  // Binding current activity from the last activity as next step
  def bind(next:String,sequence:Sequence):Sequence={
    var nextInstance = workflow(next).cmd.getClass.newInstance()
    nextInstance.name=workflow(next).name
    nextInstance.params=workflow(next).params
    build(nextInstance, workflow(next).children, workflow(next).nexts,workflow(next).params)
  }
  
  // Building the graph from the Json
  def build(currentActivity: Activity, children: List[String], nexts: List[String],param:Map[String,String]): Sequence = {
    var sequence:Sequence=new Sequence(currentActivity)
    nexts.length match {
      case 0 => EoW
      case 1 => for (next <- nexts) sequence->bind(next,sequence)
      case 2 => if (currentActivity.asInstanceOf[Predicate].condition(null, null)) sequence->bind(nexts(0),sequence) else sequence->bind(nexts(1),sequence)
      case _ => throw new Exception("Incorrect number of next elements in json")
    }
    
    val split:Split=new Split
    var sequenceList: List[Sequence] = List();
    for (child <- children) sequenceList::=bind(child,sequence)
    if(sequenceList.length>0) split ==> (sequenceList) <== new Merge ; sequence->split
  
    sequence
  }  

}  

