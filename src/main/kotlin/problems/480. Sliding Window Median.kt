package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
    val result = DoubleArray(nums.size - k + 1)
    var list = nums.copyOfRange(0, k)
    list.sort()
    return result
}