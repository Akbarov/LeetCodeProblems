package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(addToArrayForm(intArrayOf(1, 2, 0, 0), 34).joinToString())
    println(addToArrayForm(intArrayOf(2,7,4), 181).joinToString())
    println(addToArrayForm(intArrayOf(2,1,5), 806).joinToString())
}

private fun addToArrayForm(num: IntArray, k: Int): List<Int> {

    val list = mutableListOf<Int>()
    var counter = 0
    var temp = k
    var sum = 0

    while (temp != 0 || counter < num.size) {
        if (counter < num.size) {
            sum += num[num.lastIndex - counter]
        }
        sum += temp % 10
        temp /= 10
        list.add(sum % 10)
        sum /= 10
        counter++
    }
    if (sum > 0) {
        list.add( sum)
    }

    return list.reversed()
}