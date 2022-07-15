package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun isIsomorphic(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val map = mutableMapOf<Char, Char>()
    for (i in s.indices) {
        if (s[i] in map || t[i] in map.values) {
            if (map[s[i]] != t[i]) return false
        } else {
            map[s[i]] = t[i]
        }
    }
    return true
}