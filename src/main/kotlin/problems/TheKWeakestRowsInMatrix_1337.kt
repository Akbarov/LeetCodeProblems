package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        kWeakestRows(
            arrayOf(
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 1),
                intArrayOf(1, 1, 1),
                intArrayOf(0, 0, 0),
                intArrayOf(1, 1, 1),
                intArrayOf(1, 0, 0),
            ), 6
        ).joinToString()
    )
}

private fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
    val pairs = mutableListOf<Pair<Int, Int>>()
    for ((index, array) in mat.withIndex()) {
        pairs.add(Pair(array.count { it == 1 }, index))
    }
    pairs.sortBy { it.first }
   return pairs.map { it.second }.subList(0,k).toIntArray()
}