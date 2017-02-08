/**
  * Andrew Magnus
  * amm215
  * 1114088
  * Assignment 1 - Problem 1
  */


import scala.math._

object Assign1Prob1 {

  //2a
  /**
    * this function takes in a string vector, an int threshold and a prefix string, for every string in the vector
    * with a length greater than threshhold, the prefix is added onto the string, a new vector string is returned
    * */
  def myAppend(v: Vector[String], t:Int, str:String): Vector[String] = {
    v.map(((item:String) => (if(item.length > t){(str+item)}else{item})))
  }

  //2b
  /**
    * This function takes in a string and returns a function that, when given a vector and integer threshold,
    * appends the given string to every string in the vector of length greater than threshhold, the function returns a new vector*/
  def myAppendCurriedString(str:String): (Vector[String],Int)=> Vector[String] = {
    myAppend(_:Vector[String], _:Int, str)
  }
  //2c
  /**
    * This function takes a vector, and  returns a function that takes in an integer threshhold and string prefix
    * this function returns a new vector where every string of length greater then the threshhold has the prefix added on
    * */
  def myAppendCurriedVec(v:Vector[String]): (Int,String)=> Vector[String] = {
    myAppend(v, _:Int, _:String)

    //2.d) You have the ability to write general functions and with currying make them more specific and targeted like the instance above a pretty customizable function that  takes 3 parameter
    // you like in 2d you can make a function like prefixSir that always prefixes Sir to the values of a vector, if you need to do that over and over it makes sense and makes things easier to read to
    //defined targeted functions from more general ones

    //Curried functions give you the ability to easily reuse general functions to make more targeted or specific
    // functions for a more singular purpose, for example the above prefixSir has a very singular goal, whereas
    //the function its made from is pretty general and could be used for a variety of different append uses

  }

  //4b
  /**
    * taking in an offset, frequency and amplitude, this function returns a function that computes the waveform at time t
    * */
  def createWaveformFunc(offset: Double, freq:Double, amp:Double): ((Int)=>Double) = {
    t:Int => offset+(amp*sin(2*3.14159*freq*t))
  }


  //4d

  //Calculates the Root mean square of the given vector of doubles
  def RMSFromMean(waveform: Vector[Double]):Double ={
    val n = waveform.length
    val average = (waveform.reduce(_+_)/n)
    sqrt((waveform.map(_-average).map(pow(_,2)).reduce(_+_))/n)
  }



  def main(args: Array[String]): Unit = {
    val vec = Vector(-1.0, 1.0, 2.0, 3.0)
    val prob1 =vec.filter(_>=0).map(sqrt(_)).reduce(_+_)
    println("Problem 1")

    println("1.")
    println("vec.filter(_>=0).map(sqrt(_)).reduce(_+_)\n"+prob1)


    println("2.a)")
    println("myAppend(Vector(\"This\", \"is\", \"A\", \"String\"), 4, \"bla-\")")
    println(myAppend(Vector("This", "is", "A", "String"), 4, "bla-"))

    println("2.b)")
    var prefixSir = myAppendCurriedString("Sir. ")
    println("prefixSir = myAppendCurriedString(\"Sir. \")")
    println("prefixSir(Vector(\"Nate\", \"Alex\", \"Andrew\"), 5)")
    println(prefixSir(Vector("Nate", "Alex", "Andrew"), 5))

    println("2.c)")
    var appendNameList = myAppendCurriedVec(Vector("Nate", "Alex", "Andrew"))
    println("var appendNameList = myAppendCurriedVec(Vector(\"Nate\", \"Alex\", \"Andrew\"))")
    println("appendNameList(3,\"Mr. \")")
    println(appendNameList(3,"Mr. "))
    println("appendNameList(4,\"Great \")")
    println(appendNameList(4,"Great "))

    println("2.d)")
    println("Curried functions give you the ability to easily reuse general functions to make more targeted or specific functions for a more singular purpose, for example the above prefixSir has a very singular goal, whereas the function its made from is pretty general and could be used for a variety of different append uses")
    //3 TODO

    //4a
    val sampleTimes = (1 to 1000).toVector
    println("4a")
    println("sampleTimes = ")
    println(sampleTimes)
    //4b
    println("4b")
    val waveformFunc = createWaveformFunc(10.0, 0.1, 1.0)
    println("waveformFunction closure = createWaveformFunc(10.0, 0.1, 1.0)")
    println(waveformFunc)
    println("4c")
    val Waveform = sampleTimes.map(waveformFunc(_))
    println("Waveform = ")
    println(Waveform)
    println("4e")
    println("RMSFromMean(Waveform) = ")
    println(RMSFromMean(Waveform))

  }
}