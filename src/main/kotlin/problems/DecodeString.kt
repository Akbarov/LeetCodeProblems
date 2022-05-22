package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(decodeString("3[a2[c]]"))
}

private fun decodeString(s: String): String {
    var sb = ""
    val stackInt = Stack<Int>()
    val stackString = Stack<String>()
    var k = 0
    for (c in s) {
        when (c) {
            '[' -> {
                stackString.push(sb)
                stackInt.push(k)
                sb = ""
                k = 0
            }
            ']' -> {
                val num = stackInt.pop()
                val prevStr = stackString.pop()
                var temp = ""
                repeat(num) {
                    temp += sb
                }
                sb = prevStr + temp
            }
            in '0'..'9' -> {
                k = k * 10 + (c - '0')
            }
            else -> {
                sb += c
            }
        }
    }
    return sb
}