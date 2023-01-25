package main.kotlin

/**
 * Title: 카펫
 * Url: https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
class `ALG-P-15_카펫` {
    fun solution(brown: Int, yellow: Int): IntArray {
        // a*b = brown + yellow (carpet)
        // yellow = (a-2)*(b-2)
        val carpet = brown + yellow

        for (i in 2 .. 2500) {
            for (j in i .. 2500) {
                if (i*j == carpet
                    && (i-2)*(j-2) == yellow) {
                    return intArrayOf(j, i)
                }
            }
        }

        return intArrayOf(0,0)
    }
}

private fun main() {
    println(`ALG-P-15_카펫`().solution(10, 2).joinToString(" ")) // [4,3]
    println(`ALG-P-15_카펫`().solution(8, 1).joinToString(" ")) // [3,3]
    println(`ALG-P-15_카펫`().solution(24, 24).joinToString(" ")) // [8,6]
}