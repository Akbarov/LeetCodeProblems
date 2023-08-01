package problems


/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(totalFruit(intArrayOf(3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4)))
}

private fun totalFruit(fruits: IntArray): Int {
    val count: MutableMap<Int, Int> = HashMap()
    var res = 0
    var i = 0
    for (j in fruits.indices) {
        count[fruits[j]] = count.getOrDefault(fruits[j], 0) + 1
        while (count.size > 2) {
            count[fruits[i]] = (count[fruits[i]] ?: 0) - 1
            if (count[fruits[i]] == 0) {
                count.remove(fruits[i])
            }
            i++
        }
        res = Math.max(res, j - i + 1)
    }
    return res
}