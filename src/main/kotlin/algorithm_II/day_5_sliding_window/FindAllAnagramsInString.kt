package algorithm_II.day_5_sliding_window

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findAnagrams("abab", "ab").joinToString())
    println(findAnagrams("cbaebabacd", "abc").joinToString())
    println(findAnagrams("baa", "aa").joinToString())
}

private fun findAnagrams(s: String, p: String): List<Int> {
    if (s.isEmpty() || p.isEmpty() || p.length > s.length) emptyList<Int>()
    val list = mutableListOf<Int>()
    val firstArray = IntArray(26)
    val secondArray = IntArray(26)
    for ((i, v) in p.withIndex()) {
        secondArray[v - 'a'] += 1
        firstArray[s[i] - 'a'] += 1
    }
    val k = p.length
    if (firstArray.contentEquals(secondArray))
        list.add(0)
    for (i in k..s.lastIndex) {
        firstArray[s[i - k]-'a'] -=1
        firstArray[s[i] - 'a'] += 1
        if (firstArray.contentEquals(secondArray)) {
            list.add(i - k+1)
        }
    }
    return list
}