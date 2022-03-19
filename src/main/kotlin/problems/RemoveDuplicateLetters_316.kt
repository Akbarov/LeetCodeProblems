package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(removeDuplicateLetters("bcabc"))
    println(removeDuplicateLetters("cbacdcbc"))
}

private fun removeDuplicateLetters(s: String): String {

    if (s.length <= 1) return s
    val visited = BooleanArray(26)
    val stack = Stack<Char>()
    val lastIndex = IntArray(26)
    for ((index, c) in s.withIndex()) {
        lastIndex[c - 'a'] = index
    }

    for ((index, c) in s.withIndex()) {
        if (visited[c - 'a']) continue
        while (stack.isNotEmpty() && stack.peek() > c && index < lastIndex[stack.peek() - 'a']) {
            visited[stack.pop() - 'a'] = false
        }
        stack.push(c)
        visited[c - 'a'] = true
    }
    val stringBuilder = StringBuilder()
    while (stack.isNotEmpty()) {
        stringBuilder.append(stack.pop())
    }
    return stringBuilder.reverse().toString()
}