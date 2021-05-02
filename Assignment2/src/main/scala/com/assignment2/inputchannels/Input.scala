package com.assignment2.inputchannels

import com.assignment2.widgets.Widget

trait Input {

  def read : String => Seq[Widget]
}
