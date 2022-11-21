package problems

import kotlin.random.Random

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val solution = Solution(intArrayOf(1, 2, 3, 4))
    solution.nums
    solution.shuffle()
}

class Solution(val nums: IntArray) {

    fun reset(): IntArray {
        return nums
    }

    fun shuffle(): IntArray {
        val new = nums.clone()
        for (i in nums.indices) {
            val j = Random.nextInt(i + 1)
            swap(new, i, j)
        }
        return new
    }

    private fun swap(new: IntArray, i: Int, j: Int) {
        val temp = new[i]
        new[i] = new[j]
        new[j] = temp
    }

}