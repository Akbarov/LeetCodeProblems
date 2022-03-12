package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(addStrings("11", "123"))
    println(addStrings("0", "0"))
    println(addStrings("456", "77"))
}

private fun addStrings(num1: String, num2: String): String {
    if (num1.isEmpty()) return num2
    if (num2.isEmpty()) return num1
    val builder = StringBuilder()
    var number = 0
    val firstLength = num1.lastIndex
    val secondLength = num2.lastIndex
    repeat(min(firstLength, secondLength)+1) {
        number += (num1[firstLength - it] - '0')
        number += (num2[secondLength - it] - '0')
        builder.append(number % 10)
        number /= 10
    }
    if (firstLength > secondLength) {
        for (i in secondLength + 1..firstLength) {
            number += (num1[firstLength - i] - '0')
            builder.append(number % 10)
            number /= 10
        }
    } else {
        for (i in firstLength + 1..secondLength) {
            number += (num2[secondLength - i] - '0')
            builder.append(number % 10)
            number /= 10
        }
    }
    if (number > 0) {
        builder.append(number)
    }
    return builder.reverse().toString()
}