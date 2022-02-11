package problems

fun main() {
    println(strStr("", ""))
}

private fun strStr(haystack: String, needle: String): Int {
    return haystack.indexOf(needle)

}