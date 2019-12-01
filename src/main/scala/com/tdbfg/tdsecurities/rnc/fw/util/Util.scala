package com.tdbfg.tdsecurities.rnc.fw.util

import java.io.FileOutputStream
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data
import java.io.ObjectOutputStream
import java.io.FileInputStream
import java.io.ObjectInputStream
import scala.util.parsing.json.JSON
import com.tdbfg.tdsecurities.rnc.fw.wf.Step
import com.tdbfg.tdsecurities.rnc.fw.commons.Constants
import com.tdbfg.tdsecurities.rnc.fw.wf.Activity

object Util {
  class CC[T] { def unapply(a: Any): Option[T] = Some(a.asInstanceOf[T]) }

  object M extends CC[Map[String, Any]]
  object L extends CC[List[Any]]
  object S extends CC[String]
  object D extends CC[Double]
  object B extends CC[Boolean]

  def writeObject(data: Data, file: String) {
    val oos = new ObjectOutputStream(new FileOutputStream(file))
    oos.writeObject(data)
    oos.close
  }

  def readObject(file: String): Data = {
    val ois = new ObjectInputStream(new FileInputStream(file))
    val data = ois.readObject.asInstanceOf[Data]
    ois.close
    data

  }

//  var clazzes: Map[String, Activity] = collection.immutable.Map[String, Activity]()

  def processJson(jsonString: String): Map[String, Step] = {
    var json: Option[Any] = JSON.parseFull(jsonString)

//    var result = for {
//      Some(M(map)) <- List(json)
//      M(activities) = map(Constants.Json.ACTIVITIES)
//      S(packages) = activities(Constants.Json.PACKAGES)
//    } yield (packages)
//
//    var _packages = result

//    var result = for {
//      Some(M(map)) <- List(json)
//      M(activities) = map(Constants.Json.ACTIVITIES)
//      L(classes) = activities(Constants.Json.CLASSES)
//      S(classes) <- classes
//    } yield (classes)

//    for (_package <- _packages)
//      for (clazz <- result) clazzes += clazz -> Class.forName(_package + "." + clazz).newInstance().asInstanceOf[Activity]

    val wirings = for {
      Some(M(map)) <- List(JSON.parseFull(jsonString))
      M(wiring) = map(Constants.Json.WIRING)
    } yield (wiring)
    var workflow: Map[String, Step] = collection.immutable.Map[String, Step]()
    for (wiring <- wirings)
      wiring.keys.foreach((process) =>
        for (activity <- wiring(process).asInstanceOf[List[Map[String, Any]]]) {
//          var step: Step = new Step(activity(Constants.Json.NAME).asInstanceOf[String], clazzes(activity(Constants.Json.CMD).asInstanceOf[String]).getClass.newInstance(), activity(Constants.Json.CHILD).asInstanceOf[List[String]], activity(Constants.Json.NEXT).asInstanceOf[List[String]], activity(Constants.Json.PARAM).asInstanceOf[Map[String, String]])
          var step: Step = new Step(activity(Constants.Json.NAME).asInstanceOf[String], Class.forName(activity(Constants.Json.CMD).asInstanceOf[String]).newInstance().asInstanceOf[Activity], activity(Constants.Json.CHILD).asInstanceOf[List[String]], activity(Constants.Json.NEXT).asInstanceOf[List[String]], activity(Constants.Json.PARAM).asInstanceOf[Map[String, String]])
          workflow += activity(Constants.Json.ACTIVITY).asInstanceOf[String] -> step
        })
    workflow
  }
  
  
  def updateJson(jsonString:String,_activity:String,key:String,value:String):String={
    var json: Option[Any] = JSON.parseFull(jsonString)

//    var result = for {
//      Some(M(map)) <- List(json)
//      M(activities) = map(Constants.Json.ACTIVITIES)
//      S(packages) = activities(Constants.Json.PACKAGES)
//    } yield (packages)

//    var _package: String = result(0)

//    result = for {
//      Some(M(map)) <- List(json)
//      M(activities) = map(Constants.Json.ACTIVITIES)
//      L(classes) = activities(Constants.Json.CLASSES)
//      S(classes) <- classes
//    } yield (classes)

//    for (clazz <- result) clazzes += clazz -> Class.forName(_package + "." + clazz).newInstance().asInstanceOf[Activity]

    val wirings = for {
      Some(M(map)) <- List(JSON.parseFull(jsonString))
      M(wiring) = map(Constants.Json.WIRING)
    } yield (wiring)
    var workflow: Map[String, Step] = collection.immutable.Map[String, Step]()
    for (wiring <- wirings)
      wiring.keys.foreach((process) =>
        for (activity <- wiring(process).asInstanceOf[List[Map[String, Any]]]) {
            if(activity.equals(_activity)){
                println(activity(Constants.Json.PARAM))
//               activity(Constants.Json.PARAM).asInstanceOf[Map[String, String]].keys.foreach((key) => activity(Constants.Json.PARAM).asInstanceOf[Map[String, String]](key)="Noman"
                 
               
            }
//          var step: Step = new Step(activity(Constants.Json.NAME).asInstanceOf[String], clazzes(activity(Constants.Json.CMD).asInstanceOf[String]).getClass.newInstance(), activity(Constants.Json.CHILD).asInstanceOf[List[String]], activity(Constants.Json.NEXT).asInstanceOf[List[String]], activity(Constants.Json.PARAM).asInstanceOf[Map[String, String]])
//          workflow += activity(Constants.Json.ACTIVITY).asInstanceOf[String] -> step
        })
//    println(map)
    ""
  
  }
}