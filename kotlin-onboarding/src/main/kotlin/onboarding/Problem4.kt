package onboarding

fun solution4(word: String): String {
    return buildString {
        word.forEach { acc -> when {
            acc.isUpperCase() -> append(('Z'.code - (acc.code - 'A'.code)).toChar())
            acc.isLowerCase() -> append(('z'.code - (acc.code - 'a'.code)).toChar())
            acc.isWhitespace() -> append(" ")
        }}
    }
}