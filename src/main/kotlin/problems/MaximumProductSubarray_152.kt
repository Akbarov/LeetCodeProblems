package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(maxProduct(intArrayOf(2, 3, -2, 4)))
    println(maxProduct(intArrayOf(-2, 0, -1)))
}

private fun maxProduct(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums[0]
    var product = nums[0]
    var maxProduct = nums[0]
    var left = 0
    var right = 1
    while (right < nums.size) {
        if (nums[right] == 0) {
            while (left < right) {
                if (nums[left] != 0)
                    product /= nums[left]
                left++
                if (left != right && maxProduct < product) maxProduct = product
            }
            if (maxProduct < 0) maxProduct = 0
            left = right + 1
        } else {
            product *= nums[right]
            if (maxProduct < product) maxProduct = product
        }
        right++
    }
    while (left < right) {
        if (nums[left] != 0)
            product /= nums[left]
        left++
        if (left != right && maxProduct < product) maxProduct = product
    }
    return maxProduct
}