package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").joinToString())
    println(findRepeatedDnaSequences("AAAAAAAAAAAAA").joinToString())
}

private fun findRepeatedDnaSequences(s: String): List<String> {
    val resultList = mutableSetOf<String>()
    val set = mutableSetOf<String>()
    for (i in 10..s.length) {
        val subString = s.substring(i - 10, i)
        if (subString in set) {
            resultList.add(subString)
        } else {
            set.add(subString)
        }
    }
    return resultList.toList()
}