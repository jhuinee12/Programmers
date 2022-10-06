package main.kotlin

/**
 * Title : 이진 변환 반복하기
 * Url : https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
class RepeatBinaryTransformation {
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
    println(RepeatBinaryTransformation().solution("110010101001")) // [3,8]
    println(RepeatBinaryTransformation().solution("01110")) // [3,3]
    println(RepeatBinaryTransformation().solution("1111111")) // [4,1]
}