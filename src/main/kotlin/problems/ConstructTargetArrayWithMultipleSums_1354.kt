package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(isPossible(intArrayOf(9, 3, 5)))
    println(isPossible2(intArrayOf(1, 1, 1, 2)))
}

private fun isPossible2(target: IntArray): Boolean {
    if (target.size == 1) return target[0] == 1
    var sum = 0
    val pq = PriorityQueue<Int> { a, b -> b - a }
    for (item in target) {
        sum += item
        pq.add(item)
    }
    while (pq.peek() != 1) {
        val current = pq.poll()
        if (sum - current == 1) return true
        val x = current % (sum - current)
        if (x == 0 || x == current) return false
        sum = sum - current + x
        pq.add(x)
    }
    return true
}

private fun isPossible(target: IntArray): Boolean {
    while (!isAllOne(target)) {
        val maxIndex = getMax(target)
        val sum = sumArray(target) - target[maxIndex]
        if (target[maxIndex] == target[maxIndex] % sum) return false
        target[maxIndex] = target[maxIndex] % sum
        if (target[maxIndex] < 1) return false
    }
    return true
}

private fun sumArray(target: IntArray): Int {
    var sum = 0
    for (item in target) {
        sum += item
    }
    return sum
}

private fun getMax(target: IntArray): Int {
    var index = 0
    for (i in target.indices) {
        if (target[i] > target[index]) index = i
    }
    return index
}

private fun isAllOne(target: IntArray): Boolean {
    for (item in target) {
        if (item != 1) return false
    }
    return true
}
