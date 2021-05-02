package com.assignment2

import com.assignment2.attributes.{CircleAttributes, EllipseAttributes, PositionAttributes, RectangleAttributes, SquareAttributes, TextBoxAttributes}
import com.assignment2.inputchannels.HardCodedInput.Shape
import com.assignment2.logging.LogF
import com.assignment2.validators.ValidatorFactory
import com.assignment2.validators.ValidatorFactory.{CircleValidator, EllipseValidator, RectangleValidator, SquareValidator, TextBoxValidator}
import com.assignment2.widgets.WidgetType.{Circle, Ellipse, Rectangle, Square, TextBox}
import org.scalatest.BeforeAndAfterAll
import org.scalatest.funspec.AsyncFunSpec
import org.scalatest.matchers.must.Matchers

class BillOfMaterialTests extends  AsyncFunSpec with Matchers with BeforeAndAfterAll with LogF {

  val rectangle = Shape(Rectangle, Map("name" -> RectangleAttributes.NAME.name , PositionAttributes.X.name -> 10, PositionAttributes.Y.name -> 10, RectangleAttributes.WIDTH.name -> 30, RectangleAttributes.HEIGHT.name -> 40))
  val square = Shape(Square, Map("name" -> SquareAttributes.NAME.name , PositionAttributes.X.name -> 15, PositionAttributes.Y.name -> 30, SquareAttributes.SIZE.name -> 35))
  val ellipse = Shape(Ellipse, Map("name" -> EllipseAttributes.NAME.name , PositionAttributes.X.name -> 100, PositionAttributes.Y.name -> 150, EllipseAttributes.DIAMETER_H.name -> 300, EllipseAttributes.DIAMETER_V.name -> 200))
  val circle = Shape(Circle, Map("name" -> CircleAttributes.NAME.name , PositionAttributes.X.name -> 1, PositionAttributes.Y.name -> 1, CircleAttributes.SIZE.name -> 300))
  val textbox = Shape(TextBox, Map("name" -> TextBoxAttributes.NAME.name , PositionAttributes.X.name -> 5, PositionAttributes.Y.name -> 5, TextBoxAttributes.WIDTH.name -> 200, TextBoxAttributes.HEIGHT.name -> 100, TextBoxAttributes.TEXT.name -> "sample text" ))

  val invalidRectangle = Shape(Rectangle, Map("name" -> RectangleAttributes.NAME.name , PositionAttributes.X.name -> -10, PositionAttributes.Y.name -> 10, RectangleAttributes.WIDTH.name -> 30, RectangleAttributes.HEIGHT.name -> 40))
  val invalidSquare = Shape(Square, Map("name" -> SquareAttributes.NAME.name , PositionAttributes.X.name -> 15, PositionAttributes.Y.name -> -30, SquareAttributes.SIZE.name -> 35))
  val invalidEllipse = Shape(Ellipse, Map("name" -> EllipseAttributes.NAME.name , PositionAttributes.X.name -> 100, PositionAttributes.Y.name -> -150, EllipseAttributes.DIAMETER_H.name -> 300, EllipseAttributes.DIAMETER_V.name -> 200))
  val invalidCircle = Shape(Circle, Map("name" -> CircleAttributes.NAME.name , PositionAttributes.X.name -> 1, PositionAttributes.Y.name -> 1, CircleAttributes.SIZE.name -> -300))
  val invalidTextbox = Shape(TextBox, Map("name" -> TextBoxAttributes.NAME.name , PositionAttributes.X.name -> 5, PositionAttributes.Y.name -> 5, TextBoxAttributes.WIDTH.name -> 200, TextBoxAttributes.HEIGHT.name -> -100, TextBoxAttributes.TEXT.name -> "sample text" ))

  describe("validator Tests"){
    it("should return valid message for rectangle validator"){
        assert(RectangleValidator.validate(rectangle).trim.equalsIgnoreCase("Rectangle (10,10) width=30 height=40".trim))
    }

    it("should return valid message for square validator"){
      assert(SquareValidator.validate(square).trim.equalsIgnoreCase("Square (15,30) size=35".trim))
    }

    it("should return valid message for ellipse validator"){
      assert(EllipseValidator.validate(ellipse).trim.equalsIgnoreCase("Ellipse (100,150) diameterH=300 diameterV=200".trim))
    }

    it("should return valid message for circle validator"){
      assert(CircleValidator.validate(circle).trim.equalsIgnoreCase("Circle (1,1) size=300".trim))
    }

    it("should return valid message for textbox validator"){
      assert(TextBoxValidator.validate(textbox).trim.equalsIgnoreCase("Textbox (5,5) width=200 height=100 text=sample text".trim))
    }

    it("should return invalid message for rectangle validator"){
      assert(RectangleValidator.validate(invalidRectangle).trim.contains(ValidatorFactory.errorMessage))
    }

    it("should return invalid message for square validator"){
      assert(SquareValidator.validate(invalidSquare).trim.contains(ValidatorFactory.errorMessage))
    }

    it("should return invalid message for ellipse validator"){
      assert(EllipseValidator.validate(invalidEllipse).trim.contains(ValidatorFactory.errorMessage))
    }

    it("should return invalid message for circle validator"){
      assert(CircleValidator.validate(invalidCircle).trim.contains(ValidatorFactory.errorMessage))
    }

    it("should return invalid message for textbox validator"){
      assert(TextBoxValidator.validate(invalidTextbox).trim.contains(ValidatorFactory.errorMessage))
    }

  }



}
