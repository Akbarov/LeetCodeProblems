package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
sortColors(intArrayOf(2,0,2,1,1,0))
sortColors(intArrayOf(2,1,0))
}

private fun sortColors(nums: IntArray): Unit {
    if (nums.size<=1)return
    for ((index, item) in nums.withIndex()) {
        if (item == 0) continue
        var minIndex = index
        for (i in index + 1..nums.lastIndex) {
            if (nums[minIndex] > nums[i]) {
                minIndex = i
            }
            if (nums[minIndex] == 0)
                break
        }
        if (minIndex != index) {
            swap(nums, index, minIndex)
        }
    }
    println(nums.joinToString())
}

private fun swap(nums: IntArray, l: Int, r: Int) {
    val temp = nums[l]
    nums[l] = nums[r]
    nums[r] = temp
}