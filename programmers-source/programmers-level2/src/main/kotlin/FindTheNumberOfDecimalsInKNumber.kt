package main.kotlin

import kotlin.math.sqrt

/**
 * Title : k진수에서 소수 개수 구하기
 * Url : https://school.programmers.co.kr/learn/courses/30/lessons/92335
 *
 * 0P0
 * P0
 * 0P
 * P
 */
class FindTheNumberOfDecimalsInKNumber {
    fun solution(n: Int, k: Int): Int {
        var answer = 0
        val transfer = n.toString(k).split("0").filter { it != "" }.map {it.toLong()}

        for (i in transfer.indices) {
            if (transfer[i] != 1.toLong()) {
                if (isDecimalCalc(transfer[i])) answer++
            }
        }

        return answer
    }

    private fun isDecimalCalc(n: Long): Boolean {
        var isDecimal = true
        for (i in 2..sqrt(n.toDouble()).toInt()) {
            if (n % i == 0.toLong())  {
                isDecimal = false
                break
            }
        }
        return isDecimal
    }
}

private fun main() {
    println(FindTheNumberOfDecimalsInKNumber().solution(437674, 3)) // 3
    println(FindTheNumberOfDecimalsInKNumber().solution(110011, 10)) // 2
}