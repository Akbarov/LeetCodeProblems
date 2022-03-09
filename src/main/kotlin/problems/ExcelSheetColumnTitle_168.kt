package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(convertToTitle(701))
    println(convertToTitle(26))
}

private fun convertToTitle(columnNumber: Int): String {
    val builder = java.lang.StringBuilder()
    var number = columnNumber
    while (number != 0) {
        number -= 1
        val per = ('A' + number % 26)

        builder.append(per)
        number /= 26
    }
    return builder.reverse().toString()
}