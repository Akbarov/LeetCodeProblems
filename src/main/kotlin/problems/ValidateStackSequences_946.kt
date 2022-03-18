package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 5, 3, 2, 1)))
    println(validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 3, 5, 1, 2)))
}

private fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
    val stack = Stack<Int>()
    var secondCount = 0
    for (item in pushed) {
        stack.push(item)
        while (stack.isNotEmpty() && stack.peek() == popped[secondCount]) {
            stack.pop()
            secondCount++
        }
    }
    return stack.isEmpty()
}