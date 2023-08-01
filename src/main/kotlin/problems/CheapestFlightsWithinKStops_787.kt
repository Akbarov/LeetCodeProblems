package problems

import java.util.*
import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        findCheapestPrice(
            4,
            arrayOf(intArrayOf(0, 1, 100), intArrayOf(1, 2, 100), intArrayOf(1, 3, 600), intArrayOf(2, 3, 200)),
            0, 3, 1
        )
    )
}

private fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
    val graph = mutableMapOf<Int, MutableList<Flight>>()
    for (item in flights) {
        if (item.first() !in graph) {
            graph[item.first()] = mutableListOf()
        }
        graph[item.first()]?.add(Flight(item[0], item[1], item[2]))
    }
    val queue: Queue<IntArray> = LinkedList()
    queue.add(intArrayOf(src, 0))
    var count = 0
    var minPrice = Int.MAX_VALUE
    while (queue.isNotEmpty() && count++ <= k) {
        val size = queue.size
        repeat(size) {
            val current = queue.poll()
            if (current.first() == dst) {
                minPrice = min(minPrice, current.last())
            }
            val destList = graph[current.first()]
            destList?.forEach { flight ->
                if (flight.price + current.last() < minPrice) {
                    queue.offer(intArrayOf(flight.des,current.first()+flight.price))
                }
            }
        }
    }
    return if (minPrice== Int.MAX_VALUE) -1 else minPrice

}


data class Flight(val start: Int, val des: Int, var price: Int)