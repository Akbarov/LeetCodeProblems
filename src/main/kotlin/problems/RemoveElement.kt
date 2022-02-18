package problems

fun main() {
    println(removeElement(intArrayOf(3, 2, 2, 3), 3))
    println(removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
}

private fun removeElement(nums: IntArray, `val`: Int): Int {
    var counter = 0
    var removes = 0
    while (counter < nums.size - removes) {
        if (nums[counter] == `val`) {
            nums[counter] = nums[nums.lastIndex - removes]
            removes++
        } else
            counter++
    }
    println(nums.joinToString())
    return nums.size - removes
}

private fun removeElement2(nums: IntArray, `val`: Int): Int {
    var c = 0
    for (i in nums) {
        if (i != `val`) nums[c++] = i
    }
    return c
}