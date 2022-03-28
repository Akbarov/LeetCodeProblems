package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val list = groupAnagrams2(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    for (item in list) {
        println(item.joinToString())
    }
}

private fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val list = mutableListOf<MutableList<String>>()
    val isAdded = BooleanArray(strs.size)
    for ((index, word) in strs.withIndex()) {
        if (isAdded[index]) continue
        val temp = mutableListOf<String>()
        temp.add(word)
        isAdded[index] = true
        val alif = IntArray(26)
        for (c in word) {
            alif[c - 'a']++
        }
        for (i in index + 1..strs.lastIndex) {
            if (isAdded[i]) continue
            val tempAlif = IntArray(26)
            for (c in strs[i]) {
                tempAlif[c - 'a']++
            }
            if (alif.contentEquals(tempAlif)) {
                temp.add(strs[i])
                isAdded[i] = true
            }
        }
        list.add(temp)
    }
    return list
}

private fun groupAnagrams2(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, MutableList<String>>()
    for (item in strs) {
        val sorted = item.split("").sorted().joinToString()
        if (sorted in map) {
            map[sorted]?.add(item)
        } else {
            val list = mutableListOf<String>()
            list.add(item)
            map[sorted] = list
        }
    }
    val result = mutableListOf<MutableList<String>>()
    for (temp in map.values) {
        result.add(temp)
    }
    return result
}
