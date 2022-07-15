package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findMaxForm(arrayOf("10", "0001", "111001", "1", "0"), 5, 3))
}

private var maxCount = 0
private fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
    helper(strs, m, n, 0, 0, 0, -1)
    return maxCount
}

private fun helper(strs: Array<String>, m: Int, n: Int, mCount: Int, nCount: Int, count: Int, i: Int) {
    if (mCount == m && n == nCount) {
        if (count > maxCount) maxCount = count
        return
    }
    if (i >= strs.size) return
    for (index in i + 1 until strs.size) {
        var ones = 0
        var zeros = 0
        for (item in strs[index]) {
            if (item == '0') zeros++
            else ones++
        }
        helper(strs, m, n, mCount + zeros, nCount + ones, count + 1, index)
        helper(strs, m, n, zeros, ones, 1, index)
    }

}
