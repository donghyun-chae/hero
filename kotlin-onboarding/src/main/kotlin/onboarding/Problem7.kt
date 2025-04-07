package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val table = hashMapOf<String, Int>()
    val myFriends = mutableSetOf<String>()

    friends.forEach { acc -> when {
        user == acc[0] -> myFriends.add(acc[1])
        user == acc[1] -> myFriends.add(acc[0])
    } }

    friends.forEach { acc -> when {
        acc[0] == user || acc[1] == user -> {}
        acc[0] in myFriends && acc[1] !in myFriends -> table[acc[1]] = table.getOrDefault(acc[1], 0) + 10
        acc[1] in myFriends && acc[0] !in myFriends -> table[acc[0]] = table.getOrDefault(acc[0], 0) + 10
    } }

    visitors.forEach { acc -> when {
        acc !in myFriends && acc != user -> table[acc] = table.getOrDefault(acc, 0) + 1
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
