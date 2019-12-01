package com.tdbfg.tdsecurities.rnc.fw.test

import com.tdbfg.tdsecurities.rnc.fw.wf.Activity
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Context
import com.tdbfg.tdsecurities.rnc.fw.wf.data.Data
import com.tdbfg.tdsecurities.rnc.fw.util.FTP

class FTPActivity extends Activity {

  final val HOST = "host"
  final val USER = "user"
  final val PASSWORD = "password"

  private val client: FTP = new FTP() // create a new FTP client instance

  override def run(data: Data, context: Context.type): Data = {
    client.connect(params(HOST))
    client.login(USER, PASSWORD)
    
    client.disconnect()
    new Data()
  }

}