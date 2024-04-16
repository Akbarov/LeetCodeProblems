package problems

fun main() {

}

private fun findChampion(n: Int, edges: Array<IntArray>): Int {
    val res = IntArray(n)
    for (item in edges) {
        res[item[1]]++
    }
    var count = 0
    var index = 0
    for ((i, item) in res.withIndex()) {
        if (item == 0) {
            count++
            index = i
        }

    }
    return if (count == 1) index else -1
}