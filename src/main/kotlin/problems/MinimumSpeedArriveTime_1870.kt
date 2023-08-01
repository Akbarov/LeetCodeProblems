package problems

import kotlin.math.ceil

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minSpeedOnTime(intArrayOf(1, 3, 2), 6.0))
    println(minSpeedOnTime(intArrayOf(1, 3, 2), 2.7))
    println(minSpeedOnTime(intArrayOf(1, 3, 2), 1.9))
}

private fun minSpeedOnTime(
    dist: IntArray,
    hour: Double,
    low: Int = 1,
    high: Int = 10_000_000,
    minSpeed: Int = -1
): Int {

    if (low >= high) return minSpeed
    val speed = (high + low) / 2
    var time = 0.0
    for ((index, km) in dist.withIndex()) {
        if (index == dist.lastIndex) {
            time += 1.0 * km / speed

        } else {
            time += ceil(1.0 * km / speed).toInt()
        }
    }
    return if (time <= hour) {
        minSpeedOnTime(dist, hour, low, speed - 1, speed)
    } else {
        minSpeedOnTime(dist, hour, speed + 1, high, minSpeed)
    }
}
