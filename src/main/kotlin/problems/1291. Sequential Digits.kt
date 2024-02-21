package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(sequentialDigits(1000, 13000))
}

private val resultList = PriorityQueue<Int> { o1, o2 -> o1.compareTo(o2) }
private fun sequentialDigits(low: Int, high: Int): List<Int> {
    for (i in 1..9) {
        checkDfs(low, i, high)
    }
    val result = mutableListOf<Int>()
    while (resultList.isNotEmpty()) {
        result.add(resultList.poll())
    }
    return result
}

private fun checkDfs(low: Int, current: Int, high: Int) {
    if (current in low..high) {
        resultList.add(current)
    } else if (current > high) {
        return
    }
    val lastDigit = current % 10
    val nextDigit = (current + 1) % 10
    if (lastDigit < nextDigit)
        checkDfs(low, current * 10 + nextDigit, high)

}