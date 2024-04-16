package uber

fun main() {
    println(wordPattern("ab",
            "dog dog"))
}

private fun wordPattern(pattern: String, s: String): Boolean {

    val list = s.split(" ")
    val map = mutableMapOf<Char, String>()
    val reverseMap = mutableMapOf<String, Char>()
    var index = 0
    for (c in pattern) {
        if (map[c] == null && reverseMap[list[index]] == null) {
            map[c] = list[index]
            reverseMap[list[index]] = c
        } else {
            if (map[c] == list[index] && reverseMap[list[index]] == c) {
            } else return false
        }
        index++
    }
    return true
}