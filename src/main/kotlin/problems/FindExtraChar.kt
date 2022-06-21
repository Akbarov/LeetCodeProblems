package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(extraChar("abcd", "cabde"))
    println(extraChar("kxml", "klxml"))
}

private fun extraChar(str1: String, str2: String): Char {
    val char1 = str1.toCharArray().sortedArray()
    val char2 = str2.toCharArray().sortedArray()
    for (i in char1.indices) {
        if (char1[i] != char2[i]) {
            return char2[i]
        }
    }
    return char2.last()
}