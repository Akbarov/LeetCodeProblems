package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(countVowelStrings(1))
    println(countVowelStrings(2))
    println(countVowelStrings(33))
}

private fun countVowelStrings2(n: Int): Int {
    var a = 1
    var e = 1
    var i = 1
    var o = 1
    var u = 1
    var count = n
    while (--count > 0) {
        o += u
        i += o
        e += i
        a += e
    }
    return a + e + i + o + u
}

private var count = 0
private fun countVowelStrings(n: Int): Int {
    count = 0
    helper("", 0, n)
    return count

}

private val vowels = listOf('a', 'e', 'i', 'o', 'u')

private fun helper(string: String, index: Int, n: Int) {
    if (string.length > n) return
    if (string.length == n) {
        count++
    }
    for (i in index..4) {
        helper(string + vowels[i], i, n)
    }
}