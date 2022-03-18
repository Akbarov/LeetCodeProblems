package algorithm_II.day_11_recursion

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(letterCombinations("23").joinToString())
    println(letterCombinations("2").joinToString())
}

private lateinit var list: MutableList<String>
private fun letterCombinations(digits: String): List<String> {
    list = mutableListOf()
    if (digits.isEmpty()) return list
    generateCombinations(digits, "")
    return list
}

private fun generateCombinations(digits: String, current: String) {
    if (digits.length == current.length) return
    val letters = getLettersForDigit(digits[current.length])
    for (char in letters) {
        if (current.length == digits.length - 1) {
            list.add(current + char)
        } else {
            generateCombinations(digits, current + char)
        }
    }
}

private fun getLettersForDigit(char: Char): List<Char> {
    return when (char) {
        '2' -> {
            listOf('a', 'b', 'c')
        }
        '3' -> {
            listOf('d', 'e', 'f')
        }
        '4' -> {
            listOf('g', 'h', 'i')
        }
        '5' -> {
            listOf('j', 'k', 'l')
        }
        '6' -> {
            listOf('m', 'n', '0')
        }
        '7' -> {
            listOf('p', 'q', 'r', 's')
        }
        '8' -> {
            listOf('t', 'u', 'v')
        }
        else -> {
            listOf('w', 'x', 'y', 'z')
        }
    }
}