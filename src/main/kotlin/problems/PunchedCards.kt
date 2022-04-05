package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val t = readLine()?.toIntOrNull() ?: 0
    repeat(t) {
        val line = readLine()?.split(" ")
        draw(it + 1, line?.first()?.toIntOrNull() ?: 0, line?.last()?.toIntOrNull() ?: 0)
    }

}

private fun draw(testNumber: Int, row: Int, column: Int) {
    println("Case #$testNumber:")
    for (i in 1..row) {

        for (j in 1..column) {
            if (i == 1 && j == 1) {
                print("..")
            } else if (j == column) {
                print("+-+")
            } else {
                print("+-")
            }
        }
        println()
        for (j in 1..column) {
            if (i == 1 && j == 1) {
                print(".")
            } else {
                print("|")
            }
            print(".")
            if (j == column) {
                print("|")
            }
        }
        println()

    }
    for (j in 1..column) {
        if (j != column)
            print("+-")
        else {
            print("+-+")
        }
    }
}
