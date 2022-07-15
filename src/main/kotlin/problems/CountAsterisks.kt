package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(countAsterisks("l|*e*et|c**o|*de|"))
    println(countAsterisks("yo|uar|e**|b|e***au|tifu|l"))
}

private fun countAsterisks(s: String): Int {
    val list = s.split("|")
    var count = 0
    for (i in list.indices) {
        if (i % 2 == 0) {
            count += list[i].count { it == '*' }
        }
    }
    return count
}