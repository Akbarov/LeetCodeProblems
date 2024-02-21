package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
    val map = mutableMapOf<Int, MutableList<Int>>()
    val set = mutableSetOf<Int>()
    for (arr in adjacentPairs) {
        if (map[arr[0]] == null) {
            map[arr[0]] = mutableListOf()
        }
        if (map[arr[1]] == null) {
            map[arr[1]] = mutableListOf()
        }
        map[arr[0]]?.add(arr[1])
        map[arr[1]]?.add(arr[0])
        set.add(arr[0])
        set.add(arr[1])
    }
    val list = mutableListOf<Int>()
    var key = 0
    for ((k, v) in map) {
        if (v.size == 1) {
            key = k
            break
        }
    }
    while (key !in set) {
        set.remove(key)
        list.add(key)
        val values = map[key] ?: emptyList()
        for (item in values) {
            if (item in set) {
                key = item
                break
            }
        }
    }
    return list.toIntArray()
}