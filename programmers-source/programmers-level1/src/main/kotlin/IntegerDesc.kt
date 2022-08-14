package level1

class IntegerDesc {
    fun solution(n: Long): Long {
        var array = n.toString().toCharArray()
        array.sort()
        var answer = ""
        for (a in array)
            answer = a + answer
        return answer.toLong()
    }
}