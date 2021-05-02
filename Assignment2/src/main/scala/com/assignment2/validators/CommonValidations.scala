package com.assignment2.validators

import com.assignment2.attributes.{DataType, PositionAttributes, RectangleAttributes}
import com.assignment2.attributes.PositionAttributes.Attributes
import com.assignment2.logging.LogF

object CommonValidations extends LogF{

  def isNumberPositive : (Int,String,String) => Boolean = (number,propertyName, widgetType)  => if(number > 0) true else {
    loggerF.error(s"${widgetType} has invalid ${propertyName} ${number}")
    false
  }

  def positionValidator : ((Int,String,String) => Boolean, Map[String, Any], StringBuilder) => Unit  =  {
    (validator,properties,message) =>

      if(validator(properties(PositionAttributes.X.name).asInstanceOf[Int], PositionAttributes.X.name,RectangleAttributes.NAME.name)){
      message.append(s" (${properties(PositionAttributes.X.name).asInstanceOf[Int]}")
     } else{
        message.append(ValidatorFactory.errorMessage)
      }
      if(validator(properties(PositionAttributes.Y.name).asInstanceOf[Int], PositionAttributes.Y.name,RectangleAttributes.NAME.name)){
      message.append(s",${properties(PositionAttributes.Y.name).asInstanceOf[Int]}) ")
    } else{
        message.append(ValidatorFactory.errorMessage)
      }
  }







}
