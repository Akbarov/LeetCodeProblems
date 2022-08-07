package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(checkIfExist(intArrayOf(2, 3, 4, 5, 10)))
}

private fun checkIfExist(arr: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    for (item in arr) {
        if ((item * 2) in set) return true
        if (item % 2 == 0 && (item / 2) in set) return true
        set.add(item)
    }
    return false
}