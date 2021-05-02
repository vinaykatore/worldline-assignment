package com.assignment2.outputchannel

import java.io.{File, PrintWriter}

object FileOutPut extends Output {
  override def write: String => Unit = { output =>
    val writer = new PrintWriter(new File(s"${System.getProperty("user.dir")}\\output.txt"))
    writer.write(output)
    writer.close()
  }
}
