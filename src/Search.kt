

val numbers = listOf(1, 3, 56, 66, 68, 80, 99, 105, 450)
//find if if a particular value exists O(n) algorithm
fun ifContainsValue(value: Int, numbers: List<Int>): Boolean{
    for (number in numbers){
        if(number == value) return true
    }
    return false
}


fun main(args: Array<String>) {
    println(ifContainsValue(80, numbers))
}