package problems

import java.util.*
import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(removeDuplicates2("deeedbbcccbdaa", 3))
    println(removeDuplicates2("abcd", 2))
    println(removeDuplicates2("pbbcggttciiippooaais", 2))
}

private fun removeDuplicates2(s: String, k: Int): String {
    if (s.isBlank() || s.length < k) return s
    val stack = Stack<Pair<Char, Int>>()
    for (item in s) {
        if (stack.isNotEmpty() && stack.peek().first == item) {
            val t = stack.pop()
            stack.push(Pair(t.first, t.second + 1))
        } else {
            stack.push(Pair(item, 1))
        }
        if (stack.peek().second == k) {
            stack.pop()
        }
    }
    val result = java.lang.StringBuilder()
    while (stack.isNotEmpty()) {
        val t = stack.pop()
        var index = t.second
        while (index-- > 0) {
            result.append(t.first)
        }
    }
    return result.reverse().toString()

}


private fun removeDuplicates(s: String, k: Int): String {

    if (s.isBlank() || s.length < k) return s
    var result = s
    var index = 0
    var cChar = result.first()
    var count = 0
    while (index < result.length) {
        if (cChar == result[index]) {
            count++
            if (count == k) {
                result = result.removeRange(index - k + 1, index + 1)
                count = 0
                index = max(0, index - 2 * k)
                if (result.isNotBlank())
                    cChar = result[index]
                continue
            }
        } else {
            cChar = result[index]
            count = 1
        }
        index++
    }

    return result
}