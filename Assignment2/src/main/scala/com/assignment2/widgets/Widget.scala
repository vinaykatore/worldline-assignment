package com.assignment2.widgets

import com.assignment2.widgets.WidgetType.WidgetType

trait Widget {
  def name:WidgetType
  def properties: Map[String, Any]
}
