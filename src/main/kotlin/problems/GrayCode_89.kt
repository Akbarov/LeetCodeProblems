package problems

import java.util.*


/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(grayCode(5).joinToString())
}

private fun grayCode(n: Int): List<Int> {
    val result: MutableList<Int> = LinkedList()
    for (i in 0 until (1 shl n)) result.add(i xor (i shr 1))
    return result
}