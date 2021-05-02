package com.assignment2.inputchannels
import com.assignment2.attributes.{CircleAttributes, EllipseAttributes, PositionAttributes, RectangleAttributes, SquareAttributes, TextBoxAttributes}
import com.assignment2.widgets.Widget
import com.assignment2.widgets.WidgetType.{Circle, Ellipse, Rectangle, Square, TextBox, WidgetType}

object HardCodedInput extends Input {
  case class Shape(override val name: WidgetType, properties: Map[String, Any]) extends Widget
  override def read: String => Seq[Widget] = { x =>
    val rectangle = Shape(Rectangle, Map("name" -> RectangleAttributes.NAME.name , PositionAttributes.X.name -> 10, PositionAttributes.Y.name -> 10, RectangleAttributes.WIDTH.name -> 30, RectangleAttributes.HEIGHT.name -> 40))
    val square = Shape(Square, Map("name" -> SquareAttributes.NAME.name , PositionAttributes.X.name -> 15, PositionAttributes.Y.name -> 30, SquareAttributes.SIZE.name -> 35))
    val ellipse = Shape(Ellipse, Map("name" -> EllipseAttributes.NAME.name , PositionAttributes.X.name -> 100, PositionAttributes.Y.name -> 150, EllipseAttributes.DIAMETER_H.name -> 300, EllipseAttributes.DIAMETER_V.name -> 200))
    val circle = Shape(Circle, Map("name" -> CircleAttributes.NAME.name , PositionAttributes.X.name -> 1, PositionAttributes.Y.name -> 1, CircleAttributes.SIZE.name -> 300))
    val textbox = Shape(TextBox, Map("name" -> TextBoxAttributes.NAME.name , PositionAttributes.X.name -> 5, PositionAttributes.Y.name -> 5, TextBoxAttributes.WIDTH.name -> 200, TextBoxAttributes.HEIGHT.name -> 100, TextBoxAttributes.TEXT.name -> "sample text" ))


    Seq(rectangle,square,ellipse, circle,textbox)
  }
}
