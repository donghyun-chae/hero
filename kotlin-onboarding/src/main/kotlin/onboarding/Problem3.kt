package onboarding

fun solution3(number: Int): Int {
    var result = 0
    for (n in 1..number) {
        n.toString().map { acc -> if (acc == '3' || acc == '6' || acc == '9') {result += 1 }}
    }
    return result
}
