package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minMutation("AACCGGTT", "AAACGGTA", arrayOf("AACCGGTA", "AACCGCTA", "AAACGGTA")))
}

private fun minMutation(start: String, end: String, bank: Array<String>): Int {

    val queue: Queue<String> = LinkedList()
    val seenSet = mutableSetOf<String>()
    val letters = listOf('A', 'C', 'G', 'T')
    var step = 0
    queue.offer(start)
    seenSet.add(start)
    while (queue.isNotEmpty()) {
        val size = queue.size
        repeat(size) {
            val current = queue.poll()
            if (current == end) return step
            for (c in letters) {
                for (i in current.indices) {
                    val near = current.substring(0, i) + c + current.substring(i + 1)
                    if (near !in seenSet && bank.contains(near)) {
                        queue.add(near)
                        seenSet.add(near)
                    }
                }
            }
        }
        step++
    }
    return -1

}