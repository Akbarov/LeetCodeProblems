package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(findEvenNumbers(intArrayOf(2,1,3,0)).joinToString())
}

private fun findEvenNumbers(digits: IntArray): IntArray {
    val list = mutableListOf<Int>()
    for (i in digits.indices) {
        if (digits[i] == 0) continue
        for (j in digits.indices) {
            if (i == j) continue
            for (t in digits) {
                if (t == i || j == t || digits[t] % 2 == 1) continue
                val number = digits[i]*100+digits[j]*10+digits[t]
                list.add(number)
            }
        }
    }
    return list.sorted().toIntArray()
}