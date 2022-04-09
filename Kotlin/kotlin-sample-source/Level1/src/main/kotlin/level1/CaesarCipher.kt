package level1

class CaesarCipher {
    fun solution(s: String, n: Int): String {
        var answer = ""
        for (c in s.toCharArray()) {
            if (c == ' ') {
                answer += " "
                continue
            }
            val changeChar = c.toInt() + n
            // c가 소문자이면
            if (c.isLowerCase()) {
                if (changeChar > 122) {
                    answer += (changeChar-26).toChar()
                    continue
                }
            }
            // c가 대문자이면
            else if (c.isUpperCase()) {
                if (changeChar > 90) {
                    answer += (changeChar-26).toChar()
                    continue
                }
            }
            answer += changeChar.toChar()
        }
        return answer
    }

    fun solution1(s: String, n: Int): String =
        s.toList().joinToString(separator = "") {
            when (it) {
                in 'A'..'Z' -> ('A'.toInt() + (it.toInt() - 'A'.toInt() + n) % ('Z' - 'A' + 1)).toChar()
                in 'a'..'z' -> ('a'.toInt() + (it.toInt() - 'a'.toInt() + n) % ('z' - 'a' + 1)).toChar()
                else -> it
            }.toString()
        }
}