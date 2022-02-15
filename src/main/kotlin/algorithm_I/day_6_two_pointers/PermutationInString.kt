package algorithm_I

fun main() {

    println(checkInclusion("abc", "kjdfjkcab"))
    println(checkInclusion("abc", "cba"))
    println(checkInclusion("abc", "abc"))

}

private fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.length > s2.length) return false
    val firstArray = IntArray(26)
    val secondArray = IntArray(26)
    var right = 0
    for (i in s1.indices) {
        firstArray[s1[i] - 'a']++
        secondArray[s2[i] - 'a']++
        right++
    }
    var left = 0
    right--
    while (right < s2.length) {
        if (firstArray.contentEquals(secondArray)) {
            return true
        }
        right++
        if (right < s2.length) {
            secondArray[s2[right] - 'a']++
            secondArray[s2[left] - 'a']--
        }
        left++

    }
    return false
}