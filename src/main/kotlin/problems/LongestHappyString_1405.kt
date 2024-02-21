package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    print(longestDiverseString(1, 1, 7))
}

private fun longestDiverseString(a: Int, b: Int, c: Int): String {

    val sb = StringBuilder()
    val pq = PriorityQueue<Pair<Int, Char>> { o1, o2 -> o2.first.compareTo(o1.first) }
    pq.offer(Pair(a, 'a'))
    pq.offer(Pair(b, 'b'))
    pq.offer(Pair(c, 'c'))
    while (true) {
        val top = pq.poll()
        if (top.first == 0) break
        var topInt = top.first
        if (sb.length < 2 || sb[sb.length - 2] != top.second || sb.last() != top.second) {
            sb.append(top.second)
            topInt--

        } else {
            val secondTop = pq.poll()
            if (secondTop.first == 0) break
            sb.append(secondTop.second)
            pq.offer(Pair(secondTop.first - 1, secondTop.second))
        }
        pq.offer(Pair(topInt, top.second))
    }

    return sb.toString()

}