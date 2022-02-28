package algorithm_II.day_4_two_pointers

import kotlin.math.min

fun main() {
    println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println(maxArea(intArrayOf(1,1)))
}

private fun maxArea(height: IntArray): Int {
    var maxArea = 0
    var left = 0
    var right = height.lastIndex
    while (left < right) {
        val area = (right - left) * min(height[left], height[right])
        if (area > maxArea) {
            maxArea = area
        }
        if (height[left] < height[right]) {
            left++
        } else right--
    }
    return maxArea
}