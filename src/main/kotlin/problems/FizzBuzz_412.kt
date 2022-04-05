package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    println(fizzBuzz(5).joinToString())
}

private fun fizzBuzz(n: Int): List<String> {

    val list = mutableListOf<String>()
    for (i in 1..n) {
        if (i % 15 == 0) {
            list.add("FizzBuzz")
        } else if (i % 5 == 0) {
            list.add("Buzz")
        } else if (i % 3 == 0) {
            list.add("Fizz")
        } else {
            list.add(i.toString())
        }
    }
    return list

}