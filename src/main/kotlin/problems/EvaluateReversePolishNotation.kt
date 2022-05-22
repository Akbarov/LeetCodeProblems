package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
}

private fun evalRPN(tokens: Array<String>): Int {

    val stack = Stack<Long>()
    for (s in tokens) {
        if (s == "+" || s == "-" || s == "*" || s == "/") {
            val result = calculateExpression(s, stack)
            stack.push(result)
        } else {
            stack.push(s.toLong())
        }
    }
    return stack.pop().toInt()
}

private fun calculateExpression(s: String, stack: Stack<Long>): Long {
    val first = stack.pop()
    val second = stack.pop()
    return when (s) {
        "*" -> {
            second * first
        }
        "-" -> {
            second - first
        }
        "/" -> {
            second / first
        }
        else -> {
            first + second
        }
    }
}