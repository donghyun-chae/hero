package onboarding

fun isDup(s1: String, s2: String): Boolean {
    val shorter = if (s1.length <= s2.length) s1 else s2
    val longer = if (s1.length > s2.length) s1 else s2
    val subs = mutableListOf<String>()

    for (i in 0 until shorter.length - 1) {
        subs.add(shorter[i].toString()+shorter[i+1].toString())
    }

    for (i in 0 until longer.length - 1) {
        when{
            longer[i].toString()+longer[i+1].toString() in subs -> return true
        }
    }

    return false
}

fun solution6(forms: List<List<String>>): List<String> {
    val nicks = forms.fold(mutableListOf<String>()) { prev, acc ->
        prev.add(acc[1])
        prev
    }
    val result = mutableSetOf<String>()

    for (form in forms) {
        for (nick in nicks) {
            if (nick != form[1] && isDup(nick, form[1])) {
                result.add(form[0])
            }
        }
    }
    return result.sorted()
}

fun main() {
    print(solution6(listOf(listOf("jm@email.com", "제이엠"), listOf("jason@email.com", "제이슨"), listOf("woniee@email.com", "워니"), listOf("mj@email.com", "엠제이"), listOf("nowm@email.com", "이제엠"))))
}
