package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        canVisitAllRooms(
            listOf(
                listOf(1),
                listOf(2),
                listOf(3),
                listOf()
            )
        )
    )
    println(
        canVisitAllRooms(
            listOf(
                listOf(1,3),
                listOf(3,0,1),
                listOf(2),
                listOf(0)
            )
        )
    )
}

private fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    if (rooms.size <= 1) return true
    val stack = Stack<Int>()
    val visited = BooleanArray(rooms.size)
    for (item in rooms.first()) {
        stack.push(item)
    }
    visited[0] = true
    while (stack.isNotEmpty()) {
        val key = stack.pop()
        if (key < 0 || key > rooms.size) continue
        if (visited[key]) continue
        visited[key] = true
        for (item in rooms[key]) {
            stack.push(item)
        }
    }
    for (isOpened in visited) {
        if (!isOpened) {
            return false
        }
    }
    return true
}