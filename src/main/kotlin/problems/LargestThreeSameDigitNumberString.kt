package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(largestGoodInteger("6777133339"))
    println(largestGoodInteger("2300019"))
    println(largestGoodInteger("42352338"))
    println(largestGoodInteger("230"))
}

private fun largestGoodInteger(num: String): String {

    var digit = -1
    var count = 1
    for (i in 1..num.lastIndex) {
        if (num[i] == num[i - 1]) {
            count++
            if (count == 3 && num[i] - '0' >= digit) {
                digit = num[i] - '0'
                count = 1
            }
        } else {
            count = 1
        }

    }
    val result = StringBuilder("")
    if (digit != -1) {
        for (i in 0 until 3) {
            result.append(digit)
        }
    }
    return result.toString()
}