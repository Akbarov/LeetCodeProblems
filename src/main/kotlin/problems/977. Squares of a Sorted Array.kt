package problems


fun main() {

}

private fun sortedSquares(nums: IntArray): IntArray {
    var left = 0
    var right = nums.lastIndex
    val result = IntArray(nums.size)
    var counter = right
    while (right >= left) {
        val rsq = nums[right] * nums[right]
        val lsq = nums[left] * nums[left]
        if (rsq > lsq) {
            result[counter] = rsq
            right--
        } else {
            result[counter] = lsq
            left++
        }
        counter--
    }
    return nums
}


