package level1

class StringDescending {
    fun solution(s: String): String = s.toCharArray().sortedDescending().joinToString("")
}