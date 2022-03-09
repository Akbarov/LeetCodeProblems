package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    val obj = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
    println(obj.sumRange(4,5))

}

private class NumArray(nums: IntArray) {
    val res = IntArray(nums.size+1)

    init {
        if (nums.isNotEmpty()) {

            for (i in 1..nums.size) {
                res[i] = res[i - 1] + nums[i-1]
            }
            println(res.joinToString())
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return res[right+1] - res[left]
    }
}