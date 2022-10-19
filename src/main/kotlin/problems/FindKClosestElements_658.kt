package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        findClosestElements(
            intArrayOf(0, 1, 1, 1, 2, 3, 6, 7, 8, 9),
            9,
            4
        ).joinToString()
    )
    println(findClosestElements(intArrayOf(1, 2, 3, 4, 5), 4, -1).joinToString())
}
private fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    val result = mutableListOf<Int>()
    var left = 0
    var right = arr.size - k
    while (left < right) {
        val mid = (left + right) / 2
        if (x - arr[mid] > arr[mid + k] - x) {
            left = mid + 1

        } else {
            right = mid
        }
    }
    return arr.toList().subList(left, left + k)

}

