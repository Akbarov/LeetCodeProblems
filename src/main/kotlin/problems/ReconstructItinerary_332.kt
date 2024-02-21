package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findItinerary(listOf(listOf("JFK", "ABC"))))
}

private fun findItinerary(tickets: List<List<String>>): List<String> {
    val map = mutableMapOf<String, MutableList<String>>()
    for (t in tickets) {
        if (map[t.first()] == null) {
            map[t.first()] = mutableListOf()
        }
        map[t.first()]?.add(t.last())
    }
    for (list in map.values) {
        list.sortDescending()
    }
    val result = mutableListOf<String>()
    result.add("JFK")
    val stack = Stack<String>()
    while (true) {
        val from = result.last()
        val toList = map[from]
        if (toList.isNullOrEmpty()) {
            if (result.isEmpty()) break
            stack.add(result.removeLast())
            continue
        }
        result.add(toList.removeLast())
        map[from] = toList
    }
    while (stack.isNotEmpty()) {
        result.add(stack.pop())
    }
    return result
}