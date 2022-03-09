package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(wordPattern("abba", "dog cat cat dog"))
    println(wordPattern("abba", "dog cat cat fish"))
    println(wordPattern("aaaa", "dog cat cat fish"))
    println(wordPattern("abba", "dog dog dog dog"))
}

private fun wordPattern(pattern: String, s: String): Boolean {
    val map = mutableMapOf<Char, String>()
    val array = s.split(" ")
    if (array.size != pattern.length || pattern.toSet().size != array.toSet().size) return false
    for ((index, c) in pattern.withIndex()) {
        val string = map[c]
        if (string != null) {
            if (array[index] != string) {
                return false
            }
        } else {
            map[c] = array[index]
        }
    }
    return true
}