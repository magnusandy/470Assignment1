/**
  * Andrew Magnus
  * amm215
  * 1114088
  * Assignment 1 - Problem 3
  *
  * SEE OUTPUT AT BOTTOM
  */



object Problem3 {

  //PROBLEM 3 A
  /***
    * Returns an infinite stream of factorial numbers where the nth item in the stream is n!
    * series begins at 1!
    */
  def factorialStream(): Stream[Long] = {
    //helper function to make recursive call
    def facStreamParms(prev: Long, current:Long):Stream[Long] = {
      (current*prev) #:: facStreamParms((current*prev), (current+1))
    }
    return facStreamParms(1,1)
  }


  //PROBLEM 3 B

  //iterative and slow calculation of if a number is prime
  //returns true if Long l is prime, false if the l is not a prime
  def isPrime(l: Long): Boolean = {
    if (l <= 3) {
      return true
    }
    else if (l % 2 == 0) {
      // is even over 2 not prime{
      return false
    }
    else {
      //its odd and over 3 is the general case
      for (a <- 2.toLong to l - 1) {
        if (l % a == 0) // no remainder, meaning not prime excluding 1 and itself
        {
          return false
        }
      }
      return true
    }
  }

  /**
    *Returns an infinite stream of prime numbers starting at 1, uses a iterative calculation, pretty slow
    *  */
  def primeStream(): Stream[Long] = {
    //filters general list of longs from 1 to infinity to only primes
    Stream.from(1).map(_.toLong).filter(isPrime(_))
  }

  /**
    * returns and infinite stream of prime numbers starting at 1
    * */
  def primeStreamRecursive():Stream[Long] = {
    1#::primesRecursive(2, Stream(2))
  }

  //recursivly generates a stream of prime numbers, c is the number that is being checked currently for primality and
  // thusFar is the current stream of prime numbers
  def primesRecursive(c: Long, thusfar: Stream[Long]): Stream[Long] ={
    if(thusfar.filter((x:Long)=>(x*x <= c)).exists((p:Long) => (c%p==0))){
      //isntPrime
      primesRecursive(c+1, thusfar)
    }
    else{
      c#::primesRecursive(c+1, c#::thusfar)
    }
  }


  def main(args: Array[String]): Unit = {

    println("Factorial Stream\nfacStream().take(10).force")
    println(factorialStream().take(10).force)
    println("Prime Stream\nprimeStreamRecursive().take(30).force")
    println(primeStreamRecursive().take(30).force)
  }
}
/**

OUTPUT
Factorial Stream
println(facStream().take(10).force)
Stream(2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800)
Prime Stream
println(primeStream().take(30).force)
Stream(1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109)
  * */
