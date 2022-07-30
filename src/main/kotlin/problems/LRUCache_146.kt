package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val lruCache = LRUCache(2)
    lruCache.put(2, 1)
    lruCache.put(2, 2)
    println(lruCache.get(2))
    lruCache.put(1, 1)
    lruCache.put(4, 1)
    println(lruCache.get(2))


}

private class LRUCache(val capacity: Int) {

    private val map = mutableMapOf<Int, Int>()
    private val stack = Stack<Int>()
    private var capacityFull = false
    private val queue: Queue<Int> = LinkedList()

    fun get(key: Int): Int {
        return map[key] ?: -1
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            map[key] = value
            return
        }
        map[key] = value
        if (capacityFull) {
            queue.offer(key)
            if (stack.isEmpty()) {
                map.remove(queue.poll())
            } else {
                map.remove(stack.pop())
            }
        } else {
            stack.add(key)
            if (stack.size == capacity) capacityFull = true
        }
    }
}