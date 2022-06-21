package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(twoSum(intArrayOf(2, 7, 11, 15), 9).joinToString())
    println(twoSum(intArrayOf(2, 3, 4), 6).joinToString())
}

private fun twoSum(numbers: IntArray, target: Int): IntArray {
    var left = 0
    var right = numbers.lastIndex
    if (numbers.size < 2) return intArrayOf()
    while (left < right && numbers[left] + numbers[right] != target) {
        if (numbers[left] + numbers[right] > target) right--
        else left++
    }
    return intArrayOf(left + 1, right + 1)
}