package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
//    println(isHappy(19))
    println(isHappy(2))
//    println(isHappy(7))
//    println(isHappy(1_111_111))
}

private fun isHappy(n: Int): Boolean {
    var number = n.toLong()
    val set = mutableSetOf<Long>()
    do {
        set.add(number)
        var sum = 0L
        while (number != 0L) {
            val rem = number % 10
            sum += rem * rem
            number /= 10
        }
        number = sum

        if (number == 1L) return true

    } while (!set.contains(number))
    return false
}