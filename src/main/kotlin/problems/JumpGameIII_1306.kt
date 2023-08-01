package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 5))
}

private fun canReach(arr: IntArray, start: Int): Boolean {
    if (start < 0 || start >= arr.size) return false
    val jump = arr[start]
    arr[start] += arr.size
    return jump == 0 || canReach(arr, start - arr[start]) || canReach(arr, start + arr[start])
}
