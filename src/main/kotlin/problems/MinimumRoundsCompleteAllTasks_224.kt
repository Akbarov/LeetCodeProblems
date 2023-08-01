package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minimumRounds(intArrayOf(2, 2, 3, 3, 2, 4, 4, 4, 4)))
}

private fun minimumRounds(tasks: IntArray): Int {
    val group = tasks.groupBy { it }
    var result = 0
    group.forEach {
        val size = it.value.size
        if (size <= 1) return -1
        result += if (size % 3 == 0) size / 3 else size / 3 + 1
    }
    return result
}