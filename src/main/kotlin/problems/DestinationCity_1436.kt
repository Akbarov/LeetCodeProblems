package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(destCity(arrayListOf(listOf("A","B"))))
}

private fun destCity(paths: List<List<String>>): String {
    val set = mutableSetOf<String>()
    for (p in paths) {
        for (item in p) {
            if (set.contains(item)) set.remove(item)
            else set.add(item)
        }
    }
    for (item in set) {
        for (p in paths) {
            if (item == p.last()) return item
        }
    }
    return ""
}