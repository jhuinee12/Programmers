package src.main.kotlin

/**
 * Title: 섬 연결하기
 * Url: https://school.programmers.co.kr/learn/courses/30/lessons/42861
 */
class `ALG-P-30_섬_연결하기` {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        costs.sortBy { it[2] } // 가중치 기준으로 오름차순 정렬

        val root = IntArray(n) { it }

        var cost = 0
        var cnt = 0

        costs.forEach {
            if (root[it[0]] != root[it[1]]) {
                val first = Math.min( root[it[0]], root[it[1]] )
                val second = Math.max( root[it[0]], root[it[1]] )

                for (i in root.indices) {
                    if (root[i] == second) {
                        root[i] = first
                    }
                }

                cost += it[2]
                cnt++

                if (cnt == n-1) {
                    return cost
                }
            }
        }

        return cost
    }
}

private fun main() {
    println(`ALG-P-30_섬_연결하기`().solution(
        4,
        arrayOf(
            intArrayOf(0,1,1),intArrayOf(0,2,2),intArrayOf(1,2,5),intArrayOf(1,3,1),intArrayOf(2,3,8))
    )) // 4
    println(`ALG-P-30_섬_연결하기`().solution(
        4,
        arrayOf(
            intArrayOf(0,1,5), intArrayOf(1,2,3), intArrayOf(2,3,3), intArrayOf(3,1,2), intArrayOf(3,0,4))
    )) // 9
    println(`ALG-P-30_섬_연결하기`().solution(
        5,
        arrayOf(
            intArrayOf(0,1,5), intArrayOf(1,2,3), intArrayOf(2,3,3), intArrayOf(3,1,2), intArrayOf(3,0,4), intArrayOf(2,4,6), intArrayOf(4,0,7))
    )) // 15
    println(`ALG-P-30_섬_연결하기`().solution(
        7,
        arrayOf(
            intArrayOf(2,3,7), intArrayOf(3,6,13), intArrayOf(3,5,23), intArrayOf(5,6,25),
            intArrayOf(0,1,29), intArrayOf(1,5,34), intArrayOf(1,2,35), intArrayOf(4,5,53), intArrayOf(0,4,75))
    )) // 159
    println(`ALG-P-30_섬_연결하기`().solution(
        5,
        arrayOf(
            intArrayOf(0, 1, 1), intArrayOf(3, 4, 1), intArrayOf(1, 2, 2), intArrayOf(2, 3, 4))
    )) // 8
    println(`ALG-P-30_섬_연결하기`().solution(
        4,
        arrayOf(
            intArrayOf(0,1,1),intArrayOf(0,2,2),intArrayOf(2,3,1))
    )) // 4
    println(`ALG-P-30_섬_연결하기`().solution(
        5,
        arrayOf(
            intArrayOf(0, 1, 1), intArrayOf(0, 2, 2), intArrayOf(1, 2, 5), intArrayOf(1, 3, 3), intArrayOf(2, 3, 8), intArrayOf(3, 4, 1))
    )) // 7
    println(`ALG-P-30_섬_연결하기`().solution(
        6,
        arrayOf(
            intArrayOf(0, 1, 5), intArrayOf(0, 3, 2), intArrayOf(0, 4, 3), intArrayOf(1, 4, 1),
            intArrayOf(3, 4, 10), intArrayOf(1, 2, 2), intArrayOf(2, 5, 3), intArrayOf(4, 5, 4))
    )) // 11
    println(`ALG-P-30_섬_연결하기`().solution(
        5,
        arrayOf(
            intArrayOf(0, 1, 1), intArrayOf(3, 1, 1), intArrayOf(0, 2, 2), intArrayOf(0, 3, 2), intArrayOf(0, 4, 100))
    )) // 104
}