package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minRemoveToMakeValid("lee(t(c)o)de)"))
    println(minRemoveToMakeValid("a)b(c)d"))
    println(minRemoveToMakeValid(")))((())"))
    println(minRemoveToMakeValid("())()((("))
}

private fun minRemoveToMakeValid(s: String): String {

    val removableIndex = Stack<Int>()
    val stack = Stack<Int>()
    for ((index, c) in s.withIndex()) {
        if (c == '(') {
            stack.add(index)
        } else if (c == ')') {
            if (stack.isEmpty()) {
                removableIndex.add(index)
            } else {
                stack.pop()
            }
        }
    }
    removableIndex.addAll(stack)
    val bools = BooleanArray(s.length)
    while (removableIndex.isNotEmpty()) {
        bools[removableIndex.pop()] = true
    }
    val stringBuilder = StringBuilder()
    for ((index, value) in bools.withIndex()) {
        if (!value) {
            stringBuilder.append(s[index])
        }
    }
    return stringBuilder.toString()
}
