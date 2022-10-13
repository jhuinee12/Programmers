package main.kotlin

/**
 * Title: JadenCase 문자열 만들기
 * Url: https://school.programmers.co.kr/learn/courses/30/lessons/12951
 */
class JadenCaseStrings {
    fun solution(s: String): String {
        val array = s.split(" ").toMutableList()

        array.forEachIndexed { index, s ->
            var chars = ""
            s.forEachIndexed { i, c ->
                chars += if (i == 0) {
                    c.uppercaseChar()
                } else {
                    c.lowercaseChar()
                }
            }
            array[index] = chars
        }

        return array.joinToString(" ")
    }
}

private fun main() {
    println(JadenCaseStrings().solution("3people unFollowed me"))
    println(JadenCaseStrings().solution("for the last week"))
}