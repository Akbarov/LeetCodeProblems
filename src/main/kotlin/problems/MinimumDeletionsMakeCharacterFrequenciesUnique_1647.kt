package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minDeletions("aab"))
    println(minDeletions("aaabbbcc"))
    println(minDeletions("ceabaacb"))
}

private fun minDeletions(s: String): Int {
    val letterCount = IntArray(26)
    for (c in s) {
        letterCount[c - 'a']++
    }
    var count = 0
    letterCount.sortDescending()
    for (i in 0 until letterCount.lastIndex) {
        var j = i + 1
        while (letterCount[i] > 0 && letterCount[i] == letterCount[j]) {
            count++
            letterCount[j]--
            j++
        }
    }
    return count
}