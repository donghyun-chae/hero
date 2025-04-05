package onboarding

fun solution2(cryptogram: String): String {
    val stack = ArrayDeque<Char>()
    for (c in cryptogram) {
        when {
            stack.isEmpty() -> stack.addLast(c)
            stack.last() == c -> stack.removeLast()
            else -> stack.addLast(c)
        }
    }
    return stack.fold("") {acc, digit -> acc + digit}
}
