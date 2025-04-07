package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val table = hashMapOf<String, Int>()
    val myfriends = mutableSetOf<String>()

    friends.forEach { acc -> when {
        user == acc[0] -> myfriends.add(acc[1])
        user == acc[1] -> myfriends.add(acc[0])
        else -> {}
    } }

    friends.forEach { acc -> when {
        acc[0] == user || acc[1] == user -> {}
        acc[0] in myfriends && acc[1] !in myfriends -> table[acc[1]] = table.getOrDefault(acc[1], 0) + 10
        acc[1] in myfriends && acc[0] !in myfriends -> table[acc[0]] = table.getOrDefault(acc[0], 0) + 10
        else -> {}
    } }
    visitors.forEach { acc -> when {
        acc !in myfriends && acc != user -> table[acc] = table.getOrDefault(acc, 0) + 1
        else -> {}
    } }

    val result = mutableListOf<String>()

    var cnt = 0
    table.entries.sortedByDescending { it.value }.map {
        when {
            cnt > 4 -> return result
            else -> {
                cnt += 1
                result.add(it.key)
            }
        }
    }
    return result
}
