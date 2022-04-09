package level1

class Average {
    fun solution(arr: IntArray): Double {
        var answer = 0.0

        for (col in arr) answer += col

        answer /= arr.size

        return answer
    }
}