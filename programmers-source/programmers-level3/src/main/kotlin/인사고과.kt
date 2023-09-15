package src.main.kotlin

class 인사고과 {
    val maxScore = mutableMapOf<Int, Int>()

    fun solution(scores: Array<IntArray>): Int {
        var answer = 0

        scores.forEach {
            val score: Int = maxScore[it[0]] ?: 0
            if (it[1] > score) maxScore[it[0]] = it[1]
        }

        scores.forEachIndexed { index, ints ->
            if (index != 0 && ints[0]+ints[1] <= scores[0][0]+scores[0][1]) return@forEachIndexed
            val isReturn = checkBeforeValue(ints)
            if (index == 0 && isReturn) return -1
            else if (index != 0 && !isReturn) answer++
        }

        return answer+1
    }

    private fun checkBeforeValue(pair: IntArray): Boolean {
        maxScore.forEach {
            if (it.key > pair[0] && it.value > pair[1]) {
                return true
            }
        }
        return false
    }
}

private fun main() {
    println(인사고과().solution(arrayOf(intArrayOf(2,2),intArrayOf(1,4),intArrayOf(3,2),intArrayOf(3,2),intArrayOf(2,1))))
}