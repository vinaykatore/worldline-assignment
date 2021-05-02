package com.assignment2.validators

import com.assignment2.widgets.Widget

trait Validator {

  def validate: Widget => String
}
