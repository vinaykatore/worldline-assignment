package com.assignment2.logging

import com.typesafe.scalalogging.{LazyLogging, Logger}

trait LogF extends LazyLogging {
  implicit val loggerF: Logger = logger

}
