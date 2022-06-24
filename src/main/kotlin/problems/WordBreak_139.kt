package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(wordBreak("leetcode", arrayListOf("leet", "code")))
}

private fun wordBreak(s: String, wordDict: List<String>, current: String): Boolean {
    if (current.length > s.length) return false
    if (current.length == s.length) {
        return current == s
    }
    var has = false
    for (item in wordDict) {
        has = has || wordBreak(s, wordDict, current + item)
    }
    return has
}

private fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val bools = BooleanArray(s.length + 1)
    bools[0] = true
    for (i in 1..s.length) {
        for (j in 0 until i) {
            if (bools[j] && wordDict.contains(s.substring(j, i))) {
                bools[i] = true
                break
            }
        }
    }
    return bools[s.length]
}