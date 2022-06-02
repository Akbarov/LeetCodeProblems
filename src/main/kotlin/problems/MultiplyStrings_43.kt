package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
//    println(multiply("2","3"))
//    println(multiply("22","33"))
    println(multiply("123", "456"))
}

private fun multiply(num1: String, num2: String): String {
    if (num1.length == 1) {
        if (num1.first() == '1') return num2
        if (num1.first() == '0') return "0"
    }
    if (num2.length == 1) {
        if (num2.first() == '1') return num1
        if (num2.first() == '0') return "0"
    }

    var sb = StringBuilder()
    for (i in num2.lastIndex downTo 0) {
        val outer = num2[i] - '0'
        if (outer == 0) continue
        val temp = StringBuilder()
        repeat(num2.lastIndex - i) {
            temp.append('0')
        }
        var over = 0
        for (j in num1.lastIndex downTo 0) {
            val inner = num1[j] - '0'
            over += inner * outer
            temp.append(over % 10)
            over /= 10
        }
        if (over > 0) {
            temp.append(over)
        }
        sb = addTwoString(sb.toString(), temp.reversed().toString())
    }
    return sb.toString()
}

private fun addTwoString(s1: String, s2: String): StringBuilder {
    var over = 0
    var c1 = s1.lastIndex
    var c2 = s2.lastIndex
    val sb = StringBuilder()
    while (c1 >= 0 || c2 >= 0) {
        if (c1 >= 0) {
            over += (s1[c1] - '0')
            c1--
        }
        if (c2 >= 0) {
            over += (s2[c2] - '0')
            c2--
        }
        sb.append(over % 10)
        over /= 10
    }
    if (over > 0) {
        sb.append(over)
    }
    return sb.reverse()
}