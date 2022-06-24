package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(repeatedStringMatch("baa", "abaab"))
//println(repeatedStringMatch("a","aaaaaa"))
}

private fun repeatedStringMatch(a: String, b: String): Int {
    val bools = BooleanArray(26)
    for (c in a) {
        bools[c - 'a'] = true
    }
    for (c in b) {
        if (!bools[c - 'a']) return -1
    }
    val k = b.length / a.length
    var repeat = if (b.length  == k * a.length) {
        k
    } else {
        k + 1
    }

    if (b.indexOf(a) != 0) repeat++
    if (a.length >= b.length) repeat = 2
    val sb = StringBuilder()
    repeat(repeat) {
        sb.append(a)
        if (sb.contains(b)) return it + 1
    }
    return -1
}