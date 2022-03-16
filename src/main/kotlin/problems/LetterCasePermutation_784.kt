package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(letterCasePermutation("a1b2").joinToString())
    println(letterCasePermutation("1b2").joinToString())
}

private val list = mutableListOf<String>()
private fun letterCasePermutation(s: String): List<String> {
    createPermutation(s, 0)
    return list
}

private fun createPermutation(s: String, index: Int) {
    if (index < 0) return
    if (index >= s.length) {
        list.add(s)
        return
    }

    if (s[index].isLetter()) {
        val array = s.toCharArray()
        if (array[index] in 'A'..'Z') {
            array[index] = array[index].lowercaseChar()
            createPermutation(array.joinToString(""), index + 1)
        } else {
            array[index] = array[index].uppercaseChar()
            createPermutation(array.joinToString(""), index + 1)
        }
    }
    createPermutation(s, index + 1)
}
