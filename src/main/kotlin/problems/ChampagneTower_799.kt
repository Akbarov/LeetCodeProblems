package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(champagneTower(3, 1, 1))
}

private fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
    var current = DoubleArray(1) { poured.toDouble() }
    for (i in 0..query_row) {
        val nextRow = DoubleArray(i + 2) { 0.0 }
        for (j in 0..i) {
            if (current[i] > 1) {
                nextRow[j] += (current[j] - 1) / 2.0
                nextRow[j + 1] += (current[j] - 1) / 2.0
                current[j] = 1.0
            }
        }
        if (i != query_row) {
            current = nextRow
        }
    }
    return current[query_glass]
}