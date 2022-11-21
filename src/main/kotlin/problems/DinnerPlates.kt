package problems

import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
class DinnerPlates(private val capacity: Int) {

    val map = mutableMapOf<Int, Stack<Int>>()
    var count = 0
    var currentStack = 0
    var lastStack = 0

    fun push(`val`: Int) {
        while (map[currentStack] != null && map[currentStack]!!.size == capacity) {
            currentStack++
        }
        if (currentStack !in map) {
            map[currentStack] = Stack<Int>()
        }
        map[currentStack]?.push(`val`)
        lastStack = max(lastStack, currentStack)
        count++
    }

    fun pop(): Int {
        if (count == 0) return -1
        while (lastStack >= 0 && map[lastStack]?.isEmpty() == true) {
            lastStack--
        }
        currentStack = min(lastStack, currentStack)
        count--
        return map[lastStack]?.pop() ?: 0
    }

    fun popAtStack(index: Int): Int {
        if (index !in map || map[index]?.isEmpty() == true) {
            return -1
        }
        count--
        currentStack = min(currentStack, index)
        return map[index]?.pop() ?: 0
    }

}