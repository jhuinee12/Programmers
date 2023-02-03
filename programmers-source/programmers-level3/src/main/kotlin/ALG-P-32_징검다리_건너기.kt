package src.main.kotlin

class `ALG-P-32_징검다리_건너기` {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = 0

        var max = 200000000
        var min = 1
        var mid = (max+min)/2

        while (true) {
            var cnt = 0
            val newStones = stones.clone()
            for (i in stones.indices) {
                newStones[i] = stones[i]-mid

                if (newStones[i] <= 0) cnt++
                else cnt = 0

                if (cnt == k) break
            }

            if (cnt == k) {
                answer = mid
                max = mid
            } else {
                min = mid
            }
            mid = (min+max) / 2

            if (max == mid || min == mid) break
        }

        return answer
    }
}

private fun main() {
    println(`ALG-P-32_징검다리_건너기`().solution(intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1), 3)) // 정답:3
}