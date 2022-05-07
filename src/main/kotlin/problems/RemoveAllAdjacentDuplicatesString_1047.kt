package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(removeDuplicates("abbaca"))
    println(removeDuplicates("azxxzy"))
}

private fun removeDuplicates(s: String): String {
    val stack = Stack<Char>()
    for (item in s) {
        if (stack.isNotEmpty() && stack.peek() == item) {
            stack.pop()
        }else{
            stack.push(item)
        }
    }
    val stringBuilder = StringBuilder()
    while (stack.isNotEmpty()) {
        stringBuilder.append(stack.pop())
    }
    return stringBuilder.reverse().toString()
}

