package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    print(largestInteger(1234))
}

private fun largestInteger(num: Int): Int {
    val pqOdd = PriorityQueue<Int> { o1, o2 -> o2.compareTo(o1) }
    val pqEven = PriorityQueue<Int> { o1, o2 -> o2.compareTo(o1) }
    var temp = num
    while (temp > 0) {
        val rem = temp % 10
        temp /= 10
        if (rem % 2 == 0) {
            pqEven.offer(rem)
        } else
            pqOdd.offer(rem)
    }
    var result = 0
    for (c in num.toString()) {
        result = if ((c - '0') % 2 == 0) {
            result * 10 + pqEven.poll()
        } else {
            result * 10 + pqOdd.poll()
        }
    }
    return result
}