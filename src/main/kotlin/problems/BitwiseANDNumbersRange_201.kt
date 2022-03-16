package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    println(rangeBitwiseAnd(5, 7))
    println(rangeBitwiseAnd(0, 0))
    println(rangeBitwiseAnd(0, 2147483647))
    println(rangeBitwiseAnd(2147483647, 2147483647))

}

private fun rangeBitwiseAnd(left: Int, right: Int): Int {


    var number = right
    if (left == 0 || left == Int.MAX_VALUE) return left
    while (number > left) {
        number = number and (number - 1)
    }
    return number

}