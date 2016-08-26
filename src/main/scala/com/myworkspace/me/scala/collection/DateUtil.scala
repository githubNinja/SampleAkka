package com.myworkspace.me.scala.collection

import java.text.SimpleDateFormat
import java.util.{TimeZone, Date}


object DateUtil {

  def main(args: Array[String]) = {
    val dateLong: Long = 1412631272252l

    val date: Date = new Date()
    date.setTime(dateLong)
    println("Time value in String::" + date)

    val format = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss.SSS")
    format.setTimeZone(TimeZone.getTimeZone("GMT"))
    val dateString: String = format.format(date)
    println("DateString::" + dateString)





  }

}
