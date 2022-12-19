package src.main.kotlin

import kotlin.collections.ArrayList

/**
 * Title: 110 옮기기
 * Url: https://school.programmers.co.kr/learn/courses/30/lessons/77886
 *
 * 사전순으로 0 > 1
 */
class MoveOneOneZero {
    fun solution(s: Array<String>): Array<String> {
        val answer: ArrayList<String> = arrayListOf()

        s.forEach {
            var delzzo = it
            var chWord = ""
            var zzo = ""
            var zeroIdx = -1

            while (true) {
                if (delzzo.contains("110")) {
                    delzzo = delzzo.replace("110", "")
                } else {
                    break
                }
            }

            val count = (it.length - delzzo.length)/3
            for (i in 0 until count) {
                zzo += "110"
            }

            delzzo.forEachIndexed { index, c ->
                if (c == '0') zeroIdx = index
            }

            if (zeroIdx == -1) {
                chWord = zzo + delzzo
            } else {
                delzzo.forEachIndexed { index, c ->
                    chWord += c
                    if (index == zeroIdx) {
                        chWord += zzo
                    }
                }
            }

            answer.add(chWord)
        }

        return answer.toTypedArray()
    }
}

private fun main() {
    println(MoveOneOneZero().solution(arrayOf("1110","100111100","0111111010"))) // 정답: "1101","100110110","0110110111"
    println(MoveOneOneZero().solution(arrayOf("1011110","01110","101101111010"))) // 정답: "1011011","01101","101101101101"
    println(MoveOneOneZero().solution(arrayOf("101101111010"))) // 정답: "101101101101"
    println(MoveOneOneZero().solution(arrayOf("1100111011101001"))) // 정답: "0101101101101101"
}