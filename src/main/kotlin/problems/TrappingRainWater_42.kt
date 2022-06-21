package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trap(intArrayOf(4, 2, 0, 3, 2, 5)))
}

private fun trap(height: IntArray): Int {
    if (height.size < 3) return 0
    var left = 0
    var right = height.lastIndex
    var result = 0
    var maxLeft = 0
    var maxRight = 0
    while (left <= right) {
        if (height[left] <= height[right]) {
            if (maxLeft <= height[left]) maxLeft = height[left]
            else result += maxLeft - height[left]
            left++
        } else {
            if (maxRight <= height[right]) maxRight = height[right]
            else result += maxRight - height[right]
            right--
        }
    }
    return result
}