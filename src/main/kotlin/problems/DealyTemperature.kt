package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(dailyTemperature2(intArrayOf(73, 74, 75, 69, 71, 76, 70)).joinToString())
}

private fun dailyTemperature(temperatures: IntArray): IntArray {
    val result = IntArray(temperatures.size)
    val stack = Stack<Int>()
    for (i in 0..temperatures.lastIndex) {
        while (stack.isNotEmpty() && temperatures[stack.peek()] < temperatures[i]) {
            val temp = stack.pop()
            result[temp] = i - temp
        }
        stack.push(i)
    }
    return result
}

private fun dailyTemperature2(temperatures: IntArray): IntArray {
    val result = IntArray(temperatures.size)
    val stack = IntArray(temperatures.size)
    var top = -1
    for (i in 0..temperatures.lastIndex) {
        while (top >= 0 && temperatures[stack[top]] < temperatures[i]) {
            val temp = stack[top--]
            result[temp] = i - temp
        }
        stack[++top] = i
    }
    return result
}