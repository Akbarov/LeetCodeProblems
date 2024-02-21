package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun findMatrix(nums: IntArray): List<List<Int>> {
    val map = mutableMapOf<Int, Int>()
    for (item in nums) {
        map[item] = (map[item] ?: 0) + 1
    }
    val result = mutableListOf<MutableList<Int>>()
    for ((key, value) in map) {
        repeat(value) {
            if (result.size <= it) {
                result.add(mutableListOf())
            }
            result[it].add(key)
        }
    }
    return result
}