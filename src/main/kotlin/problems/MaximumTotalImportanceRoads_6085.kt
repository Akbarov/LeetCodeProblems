package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
    val connects = IntArray(n)
    for (array in roads) {
        connects[array[0]]++
        connects[array[1]]++
    }
    var sum:Long = 0L

    return sum
}