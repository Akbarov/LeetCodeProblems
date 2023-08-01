package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var left = Int.MAX_VALUE
    var right = 0
    for (item in piles) {
        if (item < left) left = item
        if (item > right) right = item
    }
    while (left < right) {
        val mid = left + (right - left) / 2
        val count = helper(piles, mid)
        if (count < h) left = mid + 1
        else right = mid
    }
    return left
}

private fun helper(piles: IntArray, value: Int): Int {
    var count = 0
    for (item in piles) {
        count += if (item % value == 0) item / value
        else item / value + 1
    }
    return count
}