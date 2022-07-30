package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        numSubmatrixSumTarget(
            arrayOf(
                intArrayOf(1, -1),
                intArrayOf(-1, 1)
            ), 0
        )
    )
}

private fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
    val dp = matrix.copyOf()
    for (array in dp) {
        for (i in 1 until array.size) {
            array[i] += array[i - 1]
        }
    }
    var count = 0

    for (i in -1 until dp[0].size) {
        for (j in i + 1 until dp[0].size) {
            val map = mutableMapOf<Int, Int>()
            map[0] = 1
            var sumOfSubMatrix = 0
            for (k in dp.indices) {
                sumOfSubMatrix += if (i >= 0) dp[k][j] - dp[k][i] else dp[k][j]
                if (map.containsKey(sumOfSubMatrix - target)) {
                    count += map.getOrDefault(sumOfSubMatrix - target, 0)
                }
                map[sumOfSubMatrix] = (map[sumOfSubMatrix] ?: 0) + 1
            }
        }
    }
    return count
}