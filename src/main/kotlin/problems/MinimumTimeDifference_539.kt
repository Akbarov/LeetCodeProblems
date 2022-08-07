package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(findMinDifference(listOf("23:59","00:00","00:00")))
}

private fun findMinDifference(timePoints: List<String>): Int {
    if (timePoints.isEmpty()) return 0
    val day = 24 * 60
    var diff = day
    val list = mutableListOf<Int>()
    for (item in timePoints) {
        val temp = item.split(":")
        val minute = temp.last().toInt() + 60 * temp.first().toInt()
        list.add(minute)
    }
    list.sort()
    for (i in 1 until list.size) {
        if (diff > list[i] - list[i - 1]) diff = list[i] - list[i - 1]
        else if (diff > list[i - 1] - list[i] + day) diff = list[i - 1] - list[i] + day
    }
    if (diff > list.last() - list.first()) diff = list.last() - list.first()
    if (diff > list.first() - list.last() + day) diff = list.first() - list.last() + day

    return diff
}