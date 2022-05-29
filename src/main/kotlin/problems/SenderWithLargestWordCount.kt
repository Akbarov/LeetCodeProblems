package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        largestWordCount(
            arrayOf("How is leetcode for everyone", "Leetcode is useful for practice"),
            arrayOf("Bob", "Charlie")
        )
    )
    println(
        largestWordCount(
            arrayOf("Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"),
            arrayOf("Alice","userTwo","userThree","Alice")
        )
    )
}

private fun largestWordCount(messages: Array<String>, senders: Array<String>): String {
    val map = mutableMapOf<String, Int>()
    for ((i, p) in senders.withIndex()) {
        val count = messages[i].split(" ").count()
        map[p] = (map[p] ?: 0) + count
    }
    var maxCount = 0
    var person = ""
    for ((s, c) in map) {
        if (maxCount < c) {
            maxCount = c
            person = s
        } else if (maxCount == c) {
            if (person < s) {
                person = s
            }
        }
    }
    return person
}