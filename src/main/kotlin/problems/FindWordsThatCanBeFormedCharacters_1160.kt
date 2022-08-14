package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(countCharacters(arrayOf("cat", "hat"), "chat"))
}

private fun countCharacters(words: Array<String>, chars: String): Int {
    var count = 0
    val letters = IntArray(26)
    chars.forEach {
        letters[it - 'a']++
    }
    words.forEach { str ->
        val temp = IntArray(26)
        str.forEach {
            temp[it - 'a']++
        }
        var flag = true
        for (i in 0 until 26) {
            if (temp[i] > letters[i]) {
                flag = false
                break
            }
        }
        if (flag) {
            count += str.length
        }
    }

    return count
}