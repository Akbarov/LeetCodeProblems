package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val randomSet = RandomizedSet()
    randomSet.insert(1)
    randomSet.insert(2)
    randomSet.remove(1)
    randomSet.getRandom()
}

private class RandomizedSet() {
    val list = mutableListOf<Int>()
    val map = mutableMapOf<Int, Int>()

    fun insert(`val`: Int): Boolean {
        if (`val` in map) return false
        list.add(`val`)
        map[`val`] = list.size - 1
        return true
    }

    fun remove(`val`: Int): Boolean {
        if (`val` !in map) return false
        val index = map[`val`] ?: 0
        val temp = list.last()
        list[index] = temp
        list.removeLast()
        map.remove(`val`)
        return true
    }

    fun getRandom(): Int {
        return list.random()
    }

}