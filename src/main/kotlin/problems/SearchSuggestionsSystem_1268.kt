package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(suggestedProducts(arrayOf("mobile","mouse","moneypot","monitor","mousepad"),"mouse"))
}

private fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
    val result = mutableListOf<MutableList<String>>()
    products.sort()
    for (i in searchWord.indices) {
        val temp = searchWord.substring(0, i + 1)
        val list = mutableListOf<String>()
        for (word in products) {
            if (word.startsWith(temp)) {
                list.add(word)
                if (list.size >= 3) break
            }
        }
        result.add(list)
    }
    return result
}