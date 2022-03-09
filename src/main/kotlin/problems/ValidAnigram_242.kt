package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(isAnagram("anagram","nagaram"))
}

private fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val sArray = IntArray(26)
    val tArray = IntArray(26)
    for (i in s.indices) {
        sArray[s[i] - 'a']++
        tArray[t[i] - 'a']++
    }
    return sArray.contentEquals(tArray)
}