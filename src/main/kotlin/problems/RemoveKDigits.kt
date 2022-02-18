package problems

import java.util.*

fun main() {
    println(removeKdigits("1432219", 3))
    println(removeKdigits("10200", 1))
    println(removeKdigits("1234", 2))
    println(removeKdigits("10", 2))
}

private fun removeKdigits(num: String, k: Int): String {
    val stack: Stack<Int> = Stack()
    var count = k
    for (i in num) {
        val a = i - '0'
        if (stack.isNotEmpty()) {
            while (stack.isNotEmpty() && stack.peek() > a && count > 0) {
                stack.pop()
                count--
            }
        }
        if (a != 0) {
            stack.push(a)
        } else {
            if (stack.isNotEmpty()) {
                stack.push(a)
            }
        }
    }

    val res = StringBuilder()
    while (stack.isNotEmpty()) {
        if (count <= 0)
            res.append(stack.pop())
        else {
            stack.pop()
        }
        count--
    }
    val result = res.toString().reversed()
    return result.ifEmpty { "0" }
}