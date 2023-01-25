package main.kotlin

/**
 * Title : 이진 변환 반복하기
 * Url : https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
class `ALG-P-10_이진_변환_반복하기` {
    fun solution(s: String): IntArray {
        var count = 0
        var zero = 0
        var number = s

        while (number != "1") {
            val firstLength = number.length
            val secondLength = number.replace("0","").length
            number = secondLength.toString(2)
            zero += firstLength-secondLength
            count++
        }

        return intArrayOf(count, zero)
    }
}

private fun main() {
    println(`ALG-P-10_이진_변환_반복하기`().solution("110010101001")) // [3,8]
    println(`ALG-P-10_이진_변환_반복하기`().solution("01110")) // [3,3]
    println(`ALG-P-10_이진_변환_반복하기`().solution("1111111")) // [4,1]
}