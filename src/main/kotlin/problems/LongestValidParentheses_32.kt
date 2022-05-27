package problems

import java.util.*
import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(longestValidParentheses("()(()"))
    println(longestValidParentheses(")()())"))
    println(longestValidParentheses(""))
}

private fun longestValidParentheses(s: String): Int {
    val stack = Stack<Int>()
    for ((i, c) in s.withIndex()) {
        if (c == '(') {
            stack.push(i)
        } else {
            if (stack.isNotEmpty() && s[stack.peek()] == '(') {
                stack.pop()
            } else stack.push(i)
        }
    }
    if (stack.isEmpty()) return s.length
    var a = s.length
    var longest = 0
    while (stack.isNotEmpty()) {
        val b = stack.pop()
        longest = max(longest, a - b - 1)
        a = b
    }
    longest = max(longest, a)
    return longest
}