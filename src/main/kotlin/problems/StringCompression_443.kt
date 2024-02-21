package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun compress(chars: CharArray): Int {
    var left = 0
    for (i in 0 until chars.lastIndex) {
        if (chars[i] != chars[i + 1]) {
            val dif = i - left
            chars[left++] = chars[i]
            if (dif > 0) {
                for (c in dif.toString()) {
                    chars[left++] = c
                }
            }
        }
    }
    val n = chars.lastIndex
    if (chars[n - 1] == chars[n]) {
        val dif = n - left
        chars[left++] = chars[n]
        if (dif > 0) {
            for (c in dif.toString()) {
                chars[left++] = c
            }
        }
    }else{
        chars[left++] = chars[n]
    }
    return left
}