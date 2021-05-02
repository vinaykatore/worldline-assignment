package com.assignment2.validators
import com.assignment2.attributes.{CircleAttributes, EllipseAttributes, PositionAttributes, RectangleAttributes, SquareAttributes, TextBoxAttributes}
import com.assignment2.logging.LogF
import com.assignment2.widgets.Widget

object ValidatorFactory extends LogF{

  val errorMessage = "+++++Abort+++++"
  val blank = ""
  val billHeader = "----------------------------------------------------------------\nBill of Materials\n----------------------------------------------------------------"
  val billFooter = "\n----------------------------------------------------------------"

  object  RectangleValidator extends Validator {
    override def validate: Widget => String = { widget =>
      val validator = CommonValidations.isNumberPositive
      val positionValidator = CommonValidations.positionValidator
      val properties = widget.properties

      val message = new StringBuilder(s"\n${RectangleAttributes.NAME.name}")
      positionValidator(validator,properties,message)
      RectangleAttributes.values.filter(!_.name.equalsIgnoreCase(RectangleAttributes.NAME.name)).toSeq.map { property =>

      properties(property.name) match {
        case i: Int => if(validator(i, property.name, RectangleAttributes.NAME.toString())){
             message.append(s"${property.name}=${i} ")
        }else{
            message.append(errorMessage)
        }
        case _ =>
          val propertyValue = properties(property.name).asInstanceOf[String]
          if(propertyValue!= null && propertyValue.trim != ""){
            message.append(s"${property.name}=${propertyValue} ")
          } else message.append(blank)
        }
        message
      }
      message.toString
    }
  }

  object  SquareValidator extends Validator {
    override def validate: Widget => String = { widget =>
      val validator = CommonValidations.isNumberPositive
      val positionValidator = CommonValidations.positionValidator
      val properties = widget.properties

      val message = new StringBuilder(SquareAttributes.NAME.name)
      positionValidator(validator,properties,message)
      SquareAttributes.values.filter(!_.name.equalsIgnoreCase(SquareAttributes.NAME.name)).toSeq.map { property =>

        properties(property.name) match {
          case i: Int => if(validator(i, property.name, SquareAttributes.NAME.toString())){
            message.append(s"${property.name}=${i} ")
          }else{
            message.append(errorMessage)
          }
          case _ =>
            val propertyValue = properties(property.name).asInstanceOf[String]
            if(propertyValue!= null && propertyValue.trim != ""){
              message.append(s"${property.name}=${propertyValue} ")
            } else message.append(blank)
        }
        message
      }
      message.toString
    }
  }

  object EllipseValidator extends Validator {
    override def validate: Widget => String = { widget =>
      val validator = CommonValidations.isNumberPositive
      val positionValidator = CommonValidations.positionValidator
      val properties = widget.properties

      val message = new StringBuilder(EllipseAttributes.NAME.name)
      positionValidator(validator,properties,message)
      EllipseAttributes.values.filter(!_.name.equalsIgnoreCase(EllipseAttributes.NAME.name)).toSeq.map { property =>

        properties(property.name) match {
          case i: Int => if(validator(i, property.name, EllipseAttributes.NAME.toString())){
            message.append(s"${property.name}=${i} ")
          }else{
            message.append(errorMessage)
          }
          case _ =>
            val propertyValue = properties(property.name).asInstanceOf[String]
            if(propertyValue!= null && propertyValue.trim != ""){
              message.append(s"${property.name}=${propertyValue} ")
            } else message.append(blank)
        }
        message
      }
      message.toString
    }
  }

  object  CircleValidator extends Validator {
    override def validate: Widget => String = { widget =>
      val validator = CommonValidations.isNumberPositive
      val positionValidator = CommonValidations.positionValidator
      val properties = widget.properties

      val message = new StringBuilder(CircleAttributes.NAME.name)
      positionValidator(validator,properties,message)
      CircleAttributes.values.filter(!_.name.equalsIgnoreCase(CircleAttributes.NAME.name)).toSeq.map { property =>

        properties(property.name) match {
          case i: Int => if(validator(i, property.name, CircleAttributes.NAME.toString())){
            message.append(s"${property.name}=${i} ")
          }else{
            message.append(errorMessage)
          }
          case _ =>
            val propertyValue = properties(property.name).asInstanceOf[String]
            if(propertyValue!= null && propertyValue.trim != ""){
              message.append(s"${property.name}=${propertyValue} ")
            } else message.append(blank)
        }
        message
      }
      message.toString
    }
  }

  object  TextBoxValidator extends Validator {
    override def validate: Widget => String = { widget =>
      val validator = CommonValidations.isNumberPositive
      val positionValidator = CommonValidations.positionValidator
      val properties = widget.properties

      val message = new StringBuilder(TextBoxAttributes.NAME.name)
      positionValidator(validator,properties,message)
      TextBoxAttributes.values.filter(!_.name.equalsIgnoreCase(TextBoxAttributes.NAME.name)).toSeq.map { property =>
        if(!property.name.equalsIgnoreCase(TextBoxAttributes.TEXT.name)){
          if(validator(properties(property.name).asInstanceOf[Int], property.name, TextBoxAttributes.NAME.toString())){
            message.append(s"${property.name}=${properties(property.name).asInstanceOf[Int]} ")
          }else{
            message.append(errorMessage)
          }
        } else {
          if(properties.contains(property.name)) {
            message.append(s"${property.name}=${properties(property.name).asInstanceOf[String]} ")
          }
          else message.append(blank)
        }
        message
      }
      message.toString
    }
  }





}
