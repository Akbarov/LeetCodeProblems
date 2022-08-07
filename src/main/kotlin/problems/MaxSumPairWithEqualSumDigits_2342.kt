package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun maximumSum(nums: IntArray): Int {
    val map = mutableMapOf<Int, MutableList<Int>>()
    var result = -1
    for (item in nums) {
        val sum = getDigitSum(item)
        if (map[sum] == null) {
            map[sum] = mutableListOf(item)
        } else map[sum]?.add(item)
    }
    for (set in map.values) {
        if (set.size > 1) {
            var max1 = Int.MIN_VALUE
            var max2 = Int.MIN_VALUE
            for (item in set) {
                if (item > max1) {
                    max2 = max1
                    max1 = item

                } else if (item > max2) max2 = item
            }
            if (max1 + max2 > result) result = max1 + max2
        }
    }
    return result
}

private fun getDigitSum(number: Int): Int {
    var temp = number
    var sum = 0
    while (temp != 0) {
        sum += temp % 10
        temp /= 10
    }
    return sum
}