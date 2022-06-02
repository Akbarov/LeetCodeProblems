package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(hasAllCodes("00110110", 2))
    println(hasAllCodes("0110", 2))
}

private fun hasAllCodes(s: String, k: Int): Boolean {
    val set = HashSet<String>()
    var need = 1 shl  k
    for (i in k  .. s.length) {
        val sub = s.substring(i - k, i)
        if (!set.contains(sub)) {
            set.add(sub)
            need--
            if (need == 0) return true
        }
    }
    return need == 0
}