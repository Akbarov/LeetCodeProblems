package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(getHint("1078","7018"))
}

private fun getHint(secret: String, guess: String): String {
    val secretDigits = IntArray(10)
    val guessDigits = IntArray(10)
    var bulls = 0

    for (i in secret.indices) {
        if (secret[i] == guess[i]) {
            bulls++
        } else {
            secretDigits[secret[i] - '0']++
            guessDigits[guess[i] - '0']++
        }
    }
    var cows = 0
    for (i in 0..9) {
        cows+= Math.min(secretDigits[i],guessDigits[i])
    }
    return "${bulls}A${cows}B"
}