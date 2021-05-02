package com.assignment2.attributes

import com.assignment2.attributes.DataType.{DataType, INTEGER, STRING}

object DataType extends Enumeration {
  type DataType = Value

  val INTEGER = Value("INTEGER")
  val STRING = Value("STRING")
}

object PositionAttributes extends Enumeration {

  type PositionAttributes = Value

  val X = Attributes(1,"X",INTEGER)
  val Y = Attributes(2,"Y",INTEGER)

  protected case class Attributes(i: Int, name: String, dataType: DataType) extends super.Val(i, name)
  import scala.language.implicitConversions
  implicit def valueToPositionAttributesDetails(x: Value): Attributes =
    x.asInstanceOf[Attributes]
}

object RectangleAttributes extends Enumeration {

  type PositionAttributes = Value

  val NAME = Attributes(1,"Rectangle",INTEGER)
  val WIDTH = Attributes(2,"width",INTEGER)
  val HEIGHT = Attributes(3,"height",INTEGER)

  protected case class Attributes(i: Int, name: String, dataType: DataType) extends super.Val(i, name)
  import scala.language.implicitConversions
  implicit def valueToPositionAttributesDetails(x: Value): Attributes =
    x.asInstanceOf[Attributes]
}

object SquareAttributes extends Enumeration {

  type PositionAttributes = Value

  val NAME = Attributes(1,"Square",INTEGER)
  val SIZE = Attributes(2,"size",INTEGER)

  protected case class Attributes(i: Int, name: String, dataType: DataType) extends super.Val(i, name)
  import scala.language.implicitConversions
  implicit def valueToPositionAttributesDetails(x: Value): Attributes =
    x.asInstanceOf[Attributes]
}

object EllipseAttributes extends Enumeration {

  type PositionAttributes = Value

  val NAME = Attributes(1,"Ellipse",INTEGER)
  val DIAMETER_H = Attributes(2,"diameterH",INTEGER)
  val DIAMETER_V = Attributes(3,"diameterV",INTEGER)

  protected case class Attributes(i: Int, name: String, dataType: DataType) extends super.Val(i, name)
  import scala.language.implicitConversions
  implicit def valueToPositionAttributesDetails(x: Value): Attributes =
    x.asInstanceOf[Attributes]
}

object CircleAttributes extends Enumeration {

  type PositionAttributes = Value

  val NAME = Attributes(1,"Circle",INTEGER)
  val SIZE = Attributes(2,"size",INTEGER)


  protected case class Attributes(i: Int, name: String, dataType: DataType) extends super.Val(i, name)
  import scala.language.implicitConversions
  implicit def valueToPositionAttributesDetails(x: Value): Attributes =
    x.asInstanceOf[Attributes]
}

object TextBoxAttributes extends Enumeration {

  type PositionAttributes = Value

  val NAME = Attributes(1,"Textbox",INTEGER)
  val WIDTH = Attributes(2,"width",INTEGER)
  val HEIGHT = Attributes(3,"height",INTEGER)
  val TEXT = Attributes(4,"text",STRING)

  protected case class Attributes(i: Int, name: String, dataType: DataType) extends super.Val(i, name)
  import scala.language.implicitConversions
  implicit def valueToPositionAttributesDetails(x: Value): Attributes =
    x.asInstanceOf[Attributes]
}
