package problems

fun main() {
    println(romanToInt("LVIII"))
    println(romanToInt("III"))
}

private fun romanToInt(s: String): Int {
    var sum = 0
    if (s.isEmpty()) return 0
    for (c in 0 until s.lastIndex) {
        val now = getIntValue(s[c])
        val next = getIntValue(s[c + 1])
        if (now < next) {
            sum -= now
        } else
            sum += now
    }
    sum += getIntValue(s.last())
    return sum
}

private fun getIntValue(char: Char): Int {
    return when (char) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 100
        'M' -> 100
        else -> 0
    }
}