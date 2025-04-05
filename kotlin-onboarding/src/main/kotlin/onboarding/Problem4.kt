package onboarding

fun solution4(word: String): String {
    var result = ""
    word.forEach { acc -> when {
        acc.isUpperCase() -> result += ('Z'.code - (acc.code - 'A'.code)).toChar()
        acc.isLowerCase() -> result += ('z'.code - (acc.code - 'a'.code)).toChar()
        acc.isWhitespace() -> result += " "
    }}
    return result
}

fun main() {
    print(solution4("I love you"))
}