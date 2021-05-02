package com.assignment1.problem1.datacheck

import java.time.{DayOfWeek, LocalDate}

object DataCheck {

  def isItMonday: LocalDate => Int = { day => if (day.getDayOfWeek == DayOfWeek.SUNDAY) 1 else 0 }

}
