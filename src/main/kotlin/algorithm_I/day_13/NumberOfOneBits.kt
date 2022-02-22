package algorithm_I.day_13

fun main() {
    println(hammingWeight(-3))
}

private fun hammingWeight(n: Int): Int {
    val string = n.toUInt().toString(2)
    println(string)
    var count = 0
    for (c in string) {
        if (c - '1' == 0) count++
    }
    return count
}