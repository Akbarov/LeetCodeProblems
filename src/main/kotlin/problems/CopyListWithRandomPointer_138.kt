package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun copyRandomList(node: RandomNode?): RandomNode? {
    val dammy = RandomNode(0)
    val map = mutableMapOf<RandomNode, RandomNode>()
    var head: RandomNode? = dammy
    var temp = node
    while (temp != null) {
        val current = RandomNode(temp.`val`)
        head?.next = current
        map[temp] = current
        temp = temp.next
    }
    temp = node
    head = dammy.next
    while (temp != null) {
        val random = temp.random
        head?.random = map[random]
    }
    return dammy.next
}

private class RandomNode(var `val`: Int) {
    var next: RandomNode? = null
    var random: RandomNode? = null
}