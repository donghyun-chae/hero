package onboarding

fun cmpBig(a: Int, b: Int): Int {
    return when {
        a >= b -> a
        else -> b
    }
}

fun addeachNum(a: Int): Int {
    var result = 0
    a.toString().forEach { digit -> result += digit.toString().toInt() }
    return result
}
fun multeachNum(a: Int): Int {
    var result = 1
    a.toString().forEach { digit -> result *= digit.toString().toInt() }
    return result
}

fun checkException(a: Int, b:Int){
    when {
        a <= 0 || b >= 400 -> throw IllegalArgumentException("[ERROR] Given number is out of range")
        a >= b -> throw IllegalArgumentException("[ERROR] Left page number can't bigger than right page number")
        b - a != 1 -> throw IllegalArgumentException("[ERROR] Size of diff is not 1")
    }
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    try {
        checkException(pobi[0], pobi[1])
        checkException(crong[0], crong[1])
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return -1
    }
    val p = cmpBig(cmpBig(addeachNum(pobi[0]), multeachNum(pobi[0])), cmpBig(addeachNum(pobi[1]), multeachNum(pobi[1])))
    val c = cmpBig(cmpBig(addeachNum(crong[0]), multeachNum(crong[0])), cmpBig(addeachNum(crong[1]), multeachNum(crong[1])))
    return when {
        p > c -> 1
        c > p -> 2
        else -> 0
    }
}

fun main() {
    print(solution1(listOf(99, 102), listOf(211, 212)))
}