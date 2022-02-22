package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(titleToNumber("A"))
    println(titleToNumber("AA"))
    println(titleToNumber("ZY"))
}

private fun titleToNumber(columnTitle: String): Int {
    var result = 0
    for (c in columnTitle) {
        result = result * 26 + (c - 'A' + 1)
    }
    return result
}