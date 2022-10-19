package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(countAndSay(5))
    map.clear()
    println(countAndSay(1))
}

private val map = mutableListOf<Pair<Int,Int>>()
private fun countAndSay(n: Int): String {
    var result = "1"
    map.add(Pair(1,1))
    for (i in 2..n) {
        result = getString()
        stringToMap(result)
    }
    return result
}

private fun getString(): String {
    val sb = StringBuilder()
    for (m in map) {
        sb.append("${m.second}${m.first}")
    }
    return sb.toString()
}

private fun stringToMap(s: String) {
    map.clear()
    var count = 1
    var c = s.first()
    for (i in 1 until s.length) {
        if (c == s[i]) count++
        else {
            map.add(Pair(c -'0',count))
            count = 1
            c = s[i]
        }
    }
    map.add(Pair(c -'0',count))
}