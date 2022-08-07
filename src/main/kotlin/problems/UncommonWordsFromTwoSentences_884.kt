package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun uncommonFromSentences(s1: String, s2: String): Array<String> {
    val map = mutableMapOf<String, Int>()
    val set = mutableSetOf<String>()
    for (item in "$s1 $s2".split(" ")) {
        map[item] = (map[item] ?: 0) + 1
    }
    for (m in map) {
        if (m.value == 1) {
            set.add(m.key)
        }
    }
    return set.toTypedArray()
}