
fun main(args: Array<String>){
    println(findSumFromOne(1000))
    println(findSumFromOneReduce(1000))
    println(findSumFromOneConstantTime(1000))
}

//find the sum of numbers from 1 to n. This example uses O(n) linear time.
fun findSumFromOne(n: Int): Int{
    var sum = 0
    for (num in 1..n) sum += num
    return sum
}

//writing same function using reduce O(n) linear time.
fun findSumFromOneReduce(n: Int):Int {
    return (1..n).reduce { sum, num -> sum + num }
}

//To improve on this, we can use constant time O(1) to perform the same function.
fun findSumFromOneConstantTime(n: Int): Int {
    return n * (n + 1) /2
}