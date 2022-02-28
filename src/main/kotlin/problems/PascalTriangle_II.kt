package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(getRow(30).joinToString())


}

fun getRow(rowIndex: Int): List<Int> {
    val tempList = mutableListOf<Int>()
    var c = 1L
    for (k in 1..rowIndex+1) {
        tempList.add(c.toInt())
        c = c * ((rowIndex+1) - k) / k
    }
    return tempList
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