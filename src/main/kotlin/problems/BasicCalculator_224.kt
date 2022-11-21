package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(calculate("1+1-(2-3+4)"))
}

private fun calculate(s: String): Int {

    val nums = Stack<Int>()
    var sign = 1
    var temp = 0
    var result = 0
    for (c in s) {
        when (c) {
            '(' -> {
                nums.push(result)
                nums.push(sign)
                result = 0
                sign = 1
            }
            ')' -> {
                result += sign * temp
                temp = 0
                result *= nums.pop()
                result += nums.pop()
            }
            '+' -> {
                result += sign * temp
                sign = 1
                temp = 0
            }
            '-' -> {
                result += sign * temp
                temp = 0
                sign = -1
            }
            ' ' -> {}
            else -> {
                temp = temp * 10 + (c - '0')
            }
        }
    }
    if (temp != 0) result += temp * sign
    return result
}