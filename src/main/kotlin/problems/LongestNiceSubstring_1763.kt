package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(longestNiceSubstring("abABB"))
    println(longestNiceSubstring("YazaAay"))
}

private fun longestNiceSubstring(s: String): String {
    var result = ""
    for (i in s.indices) {
        for (j in i + 1 .. s.length) {
            if (isNice(s.substring(i, j))) {
                if (j - i > result.length) {
                    result = s.substring(i, j)
                }
            }
        }
    }
    return result
}

fun isNice(s: String): Boolean {
   val set = s.toSet()
    val letters = IntArray(26)
    for (c in set) {
        if (c in 'A'..'Z') {
            letters[c - 'A']++
        } else {
            letters[c - 'a']--
        }
    }
    return letters.all { it == 0 }
}