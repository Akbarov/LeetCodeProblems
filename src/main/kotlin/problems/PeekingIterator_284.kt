package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private class PeekingIterator(val iterator: Iterator<Int>) : Iterator<Int> {
    var next: Int? = null

    init {
        if (iterator.hasNext()) {
            next = iterator.next()
        }
    }

    fun peek(): Int {
        return next ?: 0
    }

    override fun next(): Int {
        val cur = next
        next = if (iterator.hasNext()) iterator.next()
        else null
        return cur ?: 0
    }

    override fun hasNext(): Boolean {
        return next != null || iterator.hasNext()
    }
}