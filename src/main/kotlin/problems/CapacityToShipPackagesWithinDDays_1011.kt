package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(shipWithinDays(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 5))
}

private fun shipWithinDays(weights: IntArray, days: Int): Int {
    var left = weights.minOrNull() ?: 1
    var right = weights.sum()
    while (left <= right) {
        val mid = (left + right) / 2
        val canShip = canShipCapacity(weights, days, mid)
        if (canShip) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return left
}

private fun canShipCapacity(weights: IntArray, days: Int, capacity: Int): Boolean {
    var sum = 0
    var count = 1
    for (w in weights) {
        if (count > days) return false
        if (w + sum > capacity) {
            count++
            sum = w
        } else {
            sum += w
        }
    }
    return count <= days
}