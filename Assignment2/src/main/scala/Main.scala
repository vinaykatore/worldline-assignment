import com.assignment2.inputchannels.HardCodedInput
import com.assignment2.logging.LogF
import com.assignment2.outputchannel.{ConsoleOutPut, FileOutPut}
import com.assignment2.validators.ValidatorFactory.{CircleValidator, EllipseValidator, RectangleValidator, SquareValidator, TextBoxValidator, billFooter, billHeader, errorMessage}
import com.assignment2.widgets.{Widget, WidgetType}

import java.io.{File, PrintWriter}

object Main extends App with LogF {

  val input = HardCodedInput.read("emptyData")
  val message = new StringBuilder(billHeader)
  val output = input.map(validate(_))

  val dataForOutPutChannel = if(output.map(_.contains(errorMessage)).reduce(_ || _)) errorMessage else message.append(output.mkString("\n")).append(billFooter).toString



  ConsoleOutPut.write(dataForOutPutChannel)
  FileOutPut.write(dataForOutPutChannel)



  def validate: Widget => String = { widget =>
    widget.name match {
      case WidgetType.Rectangle => RectangleValidator.validate(widget)
      case WidgetType.Square => SquareValidator.validate(widget)
      case WidgetType.Ellipse => EllipseValidator.validate(widget)
      case WidgetType.Circle => CircleValidator.validate(widget)
      case WidgetType.TextBox => TextBoxValidator.validate(widget)
    }
  }

}
