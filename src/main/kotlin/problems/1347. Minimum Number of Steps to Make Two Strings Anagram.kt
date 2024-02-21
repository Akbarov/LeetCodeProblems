package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun minSteps(s: String, t: String): Int {

    if (t.length != s.length) return 0
    val firstArray = IntArray(26)
    val secondArray = IntArray(26)
    for (c in s) {
        firstArray[c - 'a']++
    }
    for (c in t) {
        if (firstArray[c - 'a'] > 0) firstArray[c - 'a']--
        else secondArray[c - 'a']++
    }
    var count = 0
    for (i in firstArray.indices) {
        count+=firstArray[i]
        count+=secondArray[i]
    }
    return count/2
}