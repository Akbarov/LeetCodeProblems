package algorithm_I.day_2_two_pointers

fun main() {
println(rotate(intArrayOf(1,2,3,4,5,6,7),3))
}

private fun rotate(nums: IntArray, k: Int) {
    if (nums.isEmpty()) return
    val rotate = k % nums.size
    val copy = nums.copyOf()
    for (i in nums.indices) {
        nums[(rotate + i) % nums.size] = copy[i]
    }
    println(nums.joinToString())
}