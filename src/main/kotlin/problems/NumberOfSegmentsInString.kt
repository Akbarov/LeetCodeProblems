package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(countSegments2("Hello, my   name is   John   "))
}

private fun countSegments(s: String): Int {

    if (s.isBlank()) return 0
    return s.split(" ").count { it.isNotBlank() }

}

private fun countSegments2(s: String): Int {
    if (s.isBlank()) return 0
    var count = 0
    var hasBlank = true
    for (c in s) {
        hasBlank = if (c.isWhitespace()) {
            true
        } else {
            if (hasBlank) {
                count++
            }
            false
        }
    }

    return count
}