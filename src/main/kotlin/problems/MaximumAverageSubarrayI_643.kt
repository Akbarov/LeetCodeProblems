package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(findMaxAverage(intArrayOf(-5),1))
}

private fun findMaxAverage(nums: IntArray, k: Int): Double {

    var maxAv = Double.MIN_VALUE
    var sum = 0.0
    var right = 0
    while (right < nums.size) {
        sum += nums[right++]
        if (right >= k) {
            if (sum / k > maxAv) {
                maxAv = sum / k
            }
            sum -= nums[right - k]
        }
    }
    return maxAv
}