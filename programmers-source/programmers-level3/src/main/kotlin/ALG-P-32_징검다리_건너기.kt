package src.main.kotlin

class `ALG-P-32_징검다리_건너기` {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = Int.MAX_VALUE

        for (i in 0 until stones.size-k+1) {
            var max = stones[i]
            for (j in i+1 until i+k) {
                if (stones[j] > max) max = stones[j]
            }
            if (max < answer) answer = max
        }

        return answer
    }
}

private fun main() {
    println(`ALG-P-32_징검다리_건너기`().solution(intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1), 3)) // 정답:3
}