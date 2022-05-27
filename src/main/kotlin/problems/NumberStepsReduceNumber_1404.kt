package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(numSteps("10000"))
    println(numSteps("1101"))
    println(numSteps("10"))

}

private fun numSteps(s: String): Int {
    if (s.length <= 1) return 0
    var count = 0
    var sb = s.toList()
    while (sb.size != 1) {
        sb = if (sb.last() == '0') {
            sb.dropLast(1)
        } else {
            addOne(sb)
        }
        count++
    }
    return count
}

private fun addOne(sb: List<Char>): List<Char> {
    var one = 1

    val array = mutableListOf<Char>()
    array.addAll(sb.reversed())
    for (i in array.indices) {
        var temp = array[i] - '0'
        one += temp
        temp = one % 2
        array[i] = '0' + temp
        one /= 2
        if (one == 0) break
    }
    if (one == 1) {
        array.add('1')
    }

    return array.reversed()
}