package algorithm_II.day_4_two_pointers

import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    println(backspaceCompare("ab#c", "ad#c"))
    println(backspaceCompare("ab##", "a#c#"))
    println(backspaceCompare("ab##", "a#c#d"))
    println(backspaceCompare("a##c", "#a#c"))
}

private fun backspaceCompare(s: String, t: String): Boolean {

    val stack = ArrayDeque<Char>()
    var backCount = 0
    for (i in s.lastIndex downTo 0) {
        if (s[i] == '#') {
            backCount++
        } else if (backCount > 0) {
            backCount--
        } else {
            stack.addFirst(s[i])
        }
    }
    backCount=0
    for (i in t.lastIndex downTo 0) {
        if (t[i] == '#') {
            backCount++
        } else if (backCount > 0) {
            backCount--
        } else {
            if (stack.isEmpty() || stack.removeLast() != t[i]) {
                return false
            }
        }
    }
    return stack.isEmpty()

}