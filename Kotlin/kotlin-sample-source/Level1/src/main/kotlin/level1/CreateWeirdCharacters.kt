package level1

class CreateWeirdCharacters {
    fun solution(s: String): String {
        var answer = ""
        val cArray = s.toCharArray()
        var cnt = 0
        for (char in cArray) {
            if (char == ' ') {
                cnt = 0
                answer += char
            } else {
                answer += if (cnt % 2 == 0) char.toUpperCase() else char.toLowerCase()
                cnt++
            }
        }
        return answer
    }
}