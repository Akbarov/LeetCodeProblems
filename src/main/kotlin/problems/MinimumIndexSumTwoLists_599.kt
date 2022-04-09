package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    println(
        findRestaurant(
            arrayOf("Shogun", "Tapioca Express", "Burger King", "KFC"),
            arrayOf("Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun")
        ).joinToString()
    )

}

private fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {

    val map = mutableMapOf<String, Int>()
    for ((index, item) in list1.withIndex()) {
        map[item] = index
    }
    val result = mutableListOf<String>()
    var minSum = Int.MAX_VALUE
    for ((index, item) in list2.withIndex()) {
        if (map[item] != null) {
            val sum = index + (map[item] ?: 0)
            if (sum < minSum) {
                result.clear()
                result.add(item)
                minSum = sum
            } else if (sum == minSum) {
                result.add(item)
            }
        }
    }
    return result.toTypedArray()
}