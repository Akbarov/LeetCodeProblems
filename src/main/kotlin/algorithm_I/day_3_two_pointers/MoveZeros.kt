package algorithm_I.day_3_two_pointers

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    moveZeros(intArrayOf(0, 1, 0, 3, 12))
    moveZeros2(intArrayOf(0, 1, 0, 3, 12))
    moveZeros(intArrayOf(0, 0, 1))
}
private fun moveZeros2(nums: IntArray){
    var i =0
    for (j in 0..nums.lastIndex) {
        if (nums[j] != 0) {
            val temp = nums[j]
            nums[j] = nums[i]
            nums[i] = temp
            i++
        }
    }
    println(nums.joinToString())
}
private fun moveZeros(nums: IntArray) {
    var c = 0
    var zeros = 0
    while (c < nums.size-zeros) {
        if (nums[c] == 0) {
            for (j in c + 1..(nums.lastIndex - zeros)) {
                val temp = nums[j - 1]
                nums[j - 1] = nums[j]
                nums[j] = temp
            }
            zeros++
        } else
            c++
    }
    println(nums.joinToString())
}