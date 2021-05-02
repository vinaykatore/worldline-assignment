package com.assignment2.outputchannel

import com.assignment2.logging.LogF

object ConsoleOutPut extends Output with LogF{
  override def write: String => Unit = { x =>
    loggerF.info(x)
  }
}
