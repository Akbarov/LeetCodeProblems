package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun findLongestChain(pairs: Array<IntArray>): Int {
    var result = 0
    pairs.sortWith { o1, o2 ->  o1[1].compareTo(o2[1])  }
    var current = Int.MIN_VALUE
    for (point in pairs) {
        if (current < point[0]) {
            current = point[1]
            result++
        }
    }
    return result
}