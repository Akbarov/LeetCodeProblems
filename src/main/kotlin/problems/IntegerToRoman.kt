package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(intToRoman(1994))
println(intToRoman(19))
}

private fun intToRoman(num: Int): String {
    val map = mapOf<Int, String>(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )
    var temp = num
    val builder = StringBuilder()
    for ((key, value) in map) {
        while (temp >= key) {
            builder.append(value)
            temp -= key
        }
    }
    return builder.toString()
}