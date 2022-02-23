package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val result = generate(6)
    for (arr in result) {
        println(arr.joinToString())
    }
}

private fun generate(numRows: Int): List<List<Int>> {

    val list = mutableListOf<List<Int>>()
    for (i in 1..numRows) {
        var c = 1
        val tempList = mutableListOf<Int>()
        for (k in 1..i) {
            tempList.add(c)
            c = c * (i - k) / k
        }
        list.add(tempList)
    }
    return list
}