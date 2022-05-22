package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val myStack = MyStack()
    myStack.push(1)
    myStack.push(2)
    println(myStack.top())
    println(myStack.pop())
    println(myStack.empty())
}

private class MyStack() {
    private val queue: Queue<Int> = LinkedList()

    fun push(x: Int) {
        queue.offer(x)
        val size = queue.size
        for (i in 0 until size) {
            queue.offer(queue.poll())
        }
    }

    fun pop(): Int {
        return queue.poll()
    }

    fun top(): Int {
        return queue.peek()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }

}