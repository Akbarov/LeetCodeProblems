package weekly_contest_298

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun minimumNumbers(num: Int, k: Int): Int {
    val list = mutableListOf<Int>()
    var temp = k
    while (temp <= num) {
        if (temp.toString().contains('9')) {
            list.add(temp)
        }
        temp++
    }
    list.sortDescending()
    return 0

}