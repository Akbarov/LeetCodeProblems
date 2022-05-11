package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val myQueue = MyCircularQueue(3)
    println(myQueue.enQueue(1))
    println(myQueue.enQueue(2))
    println(myQueue.enQueue(3))
    println(myQueue.Front())
    println(myQueue.enQueue(4))
    println(myQueue.Rear())
    println(myQueue.isFull())
    println(myQueue.deQueue())
    println(myQueue.enQueue(4))
    println(myQueue.Rear())
}

private class MyCircularQueue(val k: Int) {

    val list = IntArray(k)
    var front = 0
    var tail = 0

    fun enQueue(value: Int): Boolean {
        if (isFull()) return false
        list[tail % k] = value
        tail++
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) return false
        list[front % k]
        front++
        return true
    }

    fun Front(): Int {
        if (isEmpty()) return -1
        return list[(front) % k]
    }

    fun Rear(): Int {
        if (isEmpty()) return -1
        return list[(tail-1) % k]
    }

    fun isEmpty(): Boolean {
        return front == tail
    }

    fun isFull(): Boolean {
        return tail >= front + k
    }

}