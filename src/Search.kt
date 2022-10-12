

val numbers = listOf(1, 3, 56, 66, 68, 80, 99, 105, 450)
//find if if a particular value exists O(n) algorithm
fun ifContainsValue(value: Int, numbers: List<Int>): Boolean{
    for (number in numbers){
        if(number == value) return true
    }
    return false
}


fun main(args: Array<String>) {
    println(ifContainsValue(90, numbers))
    println(ifContainsValueImproved(105,numbers))
}

//To improve on this, we can use the logarithmic time complexity O(log n)
//If you were checking if the number 451 existed in the list, this algorithm would have
//to iterate from the beginning to end, making a total of nine inspections for the nine
//values in the list. However, since the list is sorted, you can, right off the bat, drop half
//of the comparisons necessary by checking the middle value:

fun ifContainsValueImproved(value: Int, numbers: List<Int>):Boolean{
    //check middle index
    val middleIndex = numbers.size/2
    if (value <= numbers[middleIndex])
        //iterate over the first batch to middle index
        for (index in 0..middleIndex){
            if (numbers[index] == value) return true
        } else {
            //iterate over the second batch from middle index to end of list
            for (index in middleIndex until numbers.size){
                if (numbers[index] == value) return true
            }
        }
    return false
}