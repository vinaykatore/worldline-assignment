package com.assignment2.widgets
import com.assignment2.widgets.WidgetType.WidgetType

case class Shape(override val x:Int, override val y:Int,  override  val name: WidgetType,override  val properties: Map[String, Any] ) extends Position with Widget


