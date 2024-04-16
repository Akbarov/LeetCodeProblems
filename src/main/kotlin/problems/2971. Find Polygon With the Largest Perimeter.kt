package problems

fun main() {

}

private fun largestPerimeter(nums: IntArray): Long {
    nums.sort()
    var p = -1L
    var sum = 0L
    for ((i, item) in nums.withIndex()) {
        if (sum > item && i >= 3) p = sum + item
        sum += item
    }
    return p
}