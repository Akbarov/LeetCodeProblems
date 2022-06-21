package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(largestNumber(intArrayOf(10, 2)))
    println(largestNumber(intArrayOf(3, 30, 34, 5, 9)))
    println(largestNumber(intArrayOf(432, 43243)))
    println(largestNumber(intArrayOf(1113, 111311)))
}

private fun largestNumber(nums: IntArray): String {
    val result = nums.map { it.toString() }.sortedWith { o1, o2 -> (o2 + o1).compareTo(o1 + o2) }.joinToString("")
    return if (result.firstOrNull() == '0') "0" else result
}