package main.kotlin

import kotlin.math.absoluteValue

/**
 * Title: 예상 대진표
 * Url: https://school.programmers.co.kr/learn/courses/30/lessons/12985
 */
class ExpectedDraw {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var fight1 = a
        var fight2 = b

        while (true) {
            answer++

            if ((fight1-fight2).absoluteValue == 1) {
                if (fight1 % 2 == 0) {
                    if (fight2 < fight1) break
                } else {
                    if (fight1 < fight2) break
                }
            }

            if (fight1 % 2 == 0) fight1 /= 2
            else fight1 = (fight1+1) / 2

            if (fight2 % 2 == 0) fight2 /= 2
            else fight2 = (fight2+1) / 2
        }

        return answer
    }
}

private fun main() {
    println(ExpectedDraw().solution(8,4,7)) // 3
    println(ExpectedDraw().solution(8,2,3)) // 2
}