package onboarding

fun solution5(money: Int): List<Int> {
    val curr = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    return curr.fold(Pair(money, mutableListOf<Int>())) { (remaining, acc), c ->
        val count = remaining / c
        acc.add(count)
        Pair(remaining - count * c, acc)
    }.second
}