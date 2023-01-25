package main.kotlin

/**
 * Title : H-Index
 * Url : https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
class HIndex {
    fun solution(citations: IntArray): Int {
        var answer = 0

        for (i in 1..citations.size) {
            val quotation = citations.filter { it >= i }.size

            if (i in (answer + 1)..quotation) {
                answer = i
            }
        }

        return answer
    }
}
fun main() {
    println(HIndex().solution(intArrayOf(3,0,6,1,5)))   // 정답 : 3
}
