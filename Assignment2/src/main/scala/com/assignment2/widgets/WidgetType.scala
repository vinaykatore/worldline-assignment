package com.assignment2.widgets

object WidgetType extends Enumeration {
  type WidgetType = Int

  val Rectangle = 1
  val Square = 2
  val Ellipse = 3
  val Circle = 4
  val TextBox = 5


  def getSourceType(value: Int): WidgetType = {
    value match {
      case 1 => Rectangle
      case 2 => Square
      case 3 => Ellipse
      case 4 => Circle
      case 5 => TextBox

    }
  }

  def getWidgetName(value: Int): String = {
    value match {
      case 1 => "Rectangle"
      case 2 => "Square"
      case 3 => "Ellipse"
      case 4 => "Circle"
      case 5 => "TextBox"
    }
  }

}
