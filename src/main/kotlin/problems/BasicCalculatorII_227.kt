package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(calculate("3-2 *4"))
    println(calculate("3 - 2 *4 "))
}

private fun calculate(s: String): Int {
    val stack = Stack<Int>()
    var number = 0
    var sign = '+'
    for (i in s.indices) {
        if (s[i].isDigit()) {
            number = 10 * number + (s[i] - '0')
        }
        if ((!s[i].isDigit()) && s[i] != ' ' || i == s.length - 1) {
            when (sign) {
                '-' -> stack.push(-number)
                '+' -> stack.push(number)
                '*' -> stack.push(stack.pop() * number)
                '/' -> stack.push(stack.pop() / number)
            }
            sign = s[i]
            number = 0
        }
    }
    var result = 0
    for (item in stack) {
        result += item
    }
    return result
}