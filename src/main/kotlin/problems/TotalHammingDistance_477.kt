package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(totalHammingDistance(intArrayOf(4, 14, 2)))
    println(totalHammingDistance(intArrayOf(4, 14, 4)))
}

private fun totalHammingDistance(nums: IntArray): Int {
    if(nums.size==1) return hummingDistance(nums.first(),0)
    var sum = 0
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            sum+= hummingDistance(nums[i],nums[j])
        }
    }
    return sum
}

private fun hummingDistance(x: Int, y: Int): Int {
    var xorD = x xor y
    var count = 0
    while (xorD > 0) {
        if (xorD % 2 == 1) {
            count++
        }
        xorD = xorD shr 1
    }
    return count
}