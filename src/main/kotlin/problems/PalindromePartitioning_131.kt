package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(partition("aab"))
}

private var result = mutableListOf<MutableList<String>>()
private var current = mutableListOf<String>()
private fun partition(s: String): List<List<String>> {
    helper(s, 0)
    return result
}

private fun helper(s: String, index: Int) {
    if (current.size > 0 && index >= s.length) {
        val temp = mutableListOf<String>()
        temp.addAll(current)
        result.add(temp)
    }
    for (i in index until s.length) {
        if (isPalindrome(s, index, i)) {
            current.add(s.substring(index, i + 1))
            helper(s, i + 1)
            current.removeAt(current.size - 1)
        }
    }
}

private fun isPalindrome(s: String, left: Int, right: Int): Boolean {
    var l = left
    var r = right
    while (l < r) {
        if (s[l++] != s[r--]) return false
    }
    return true
}