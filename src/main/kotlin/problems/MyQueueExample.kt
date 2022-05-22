package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val myQueue = MyQueue()
    myQueue.push(1)
    println(myQueue.empty())

}

private class MyQueue() {

    private val first = Stack<Int>()
    private val second = Stack<Int>()

    fun push(x: Int) {
        if (second.isNotEmpty()) {
            first.clear()
            while (second.isNotEmpty()) {
                first.push(second.pop())
            }
        }
        first.push(x)
    }

    fun pop(): Int {
        if (first.isNotEmpty()) {
            second.clear()
            while (first.isNotEmpty()) {
                second.push(first.pop())
            }
        }
        return second.pop()
    }

    fun peek(): Int {
        return if (second.isNotEmpty()) {
            second.peek()
        } else {
            val result = pop()
            second.push(result)
            result
        }
    }

    fun empty(): Boolean {
        return first.isEmpty()&&second.isEmpty()
    }

}